package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.BasicTestDto2;

@RestController
public class BasicRestController2 {
	
	@GetMapping("/info")
	public ResponseEntity<? extends ResponseDto> info(String username){
		
		String userInfo = username;
		
		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
	}
	@GetMapping("/info2")
	public ResponseEntity<? extends ResponseDto> info2(String username, String nickname, String email){
		
		String userInfo = username + "(" + nickname + ") : " + email;
		
		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
	}
	
	@GetMapping("/info3")
	public ResponseEntity<? extends ResponseDto> info3(BasicTestDto2 basicTestDto2){
		
		String userInfo = basicTestDto2.getUsername() + "(" + basicTestDto2.getNickname() + ") : " + basicTestDto2.getEmail();
		
		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
	}
	
	@GetMapping("/info4/{id}")
	public ResponseEntity<? extends ResponseDto> read2(BasicTestDto2 basicTestDto2,@PathVariable int id) {
	    Map<Integer, String> userMap = new HashMap<>();
	    userMap.put(1, basicTestDto2.getNickname());
	    userMap.put(2, "모코코2");
	    userMap.put(3, "모코코3");
	    userMap.put(4, "모코코4");
	    userMap.put(5, "모코코5");
	    
	    String userInfo = basicTestDto2.getUsername() + "("+ userMap.get(id) +"): " + basicTestDto2.getEmail();
	    
	    return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
	}
	
	
	@PostMapping("/create/info")
	public ResponseEntity<? extends ResponseDto> create(@RequestBody BasicTestDto2 basicTestDto2){
		System.out.println("데이터 추가");
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto2));
	}
	
	@PostMapping("/create/info2")
	public ResponseEntity<? extends ResponseDto> create2(BasicTestDto2 basicTestDto2){
		System.out.println("데이터 추가");
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto2));
	}
}
