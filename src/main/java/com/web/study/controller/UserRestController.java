package com.web.study.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.UserAdditionDto;

class UserStore{
	public static Map<Integer, UserAdditionDto> userMap = new HashMap<>();
}


@RestController
public class UserRestController {
	
	@PostMapping("/api/user/addition")
	public ResponseEntity<? extends ResponseDto> addUser(@RequestBody UserAdditionDto userAdditionDto){
		Map<Integer, UserAdditionDto> userMap = UserStore.userMap;
		int maxKey=0;
		if(!userMap.keySet().isEmpty()) {
			maxKey = Collections.max(userMap.keySet());
		}
		userMap.put(maxKey + 1, userAdditionDto);
		System.out.println(userMap);
		
		return ResponseEntity.ok().body(DataResponseDto.of(userMap));
	}
	
	@GetMapping("/api/user/{id}")
	public ResponseEntity<? extends ResponseDto> getUser(@PathVariable int id) {
//		userMap에서 해당 id를 가진 객체를 응답
//		만약에 해당 id가 존재하지 않은면 ErrorResponse를 응답으로 준다. errorMessage = 존재하지 않는 id입니다.
		
		Map<Integer, UserAdditionDto> userMap = UserStore.userMap;
		UserAdditionDto userAdditionDto = userMap.get(id);
		try {
			if(userAdditionDto == null) {
				throw new RuntimeException("존재하지 않는 id입니다.");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(ErrorResponseDto.of(HttpStatus.BAD_REQUEST, e));
		}	
		
		return ResponseEntity.ok().body(DataResponseDto.of(userAdditionDto));			
	}
	
	@GetMapping("/api/users")
	public ResponseEntity<? extends ResponseDto> getUsers(){
		
//		Set<Entry<Integer, UserAdditionDto>> set = UserStore.userMap.entrySet();
//		List<Entry<Integer, UserAdditionDto>> list = new ArrayList<>();
//		list.addAll(set);
//		
//		Collection<Entry<Integer, UserAdditionDto>> list2 =
//				UserStore.userMap.entrySet().stream().collect(Collectors.toCollection(ArrayList::new));
		
	
		return ResponseEntity.ok().body(DataResponseDto.of(UserStore.userMap.values()));		
	}
	
}
