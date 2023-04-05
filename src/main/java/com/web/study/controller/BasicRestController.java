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
import com.web.study.dto.request.BasicTestDto;
import com.web.study.dto.request.BasicTestDto2;

@RestController
public class BasicRestController {
	
	// GET 요청의 param을 처리하는 방법
	@GetMapping("/read")
	public ResponseEntity<? extends ResponseDto> read(BasicTestDto basicTestDto) {   // key 값이 매개변수명이 되면 @RequsetParam("key값")을 생략할 수 있다.
																					// get post 밖에 안됨.
		String userInfo = basicTestDto.getName() + "(" + basicTestDto.getAge() + ")";
		
		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
	}
	
	@GetMapping("/read2/{id}")
	public ResponseEntity<? extends ResponseDto> read2(@PathVariable int id){  //post put delete 다 됨
		
		Map<Integer, String> userMap = new HashMap<>();
		
		userMap.put(1, "김준일");
		userMap.put(2, "김준이");
		userMap.put(3, "김준삼");
		userMap.put(4, "김준사");
		userMap.put(5, "김준오");
		
		return ResponseEntity.ok().body(DataResponseDto.of(userMap.get(id)));
	}
	
	//Post요청 데이터 처리 방법
	@PostMapping("/create/")
	public ResponseEntity<? extends ResponseDto> create(@RequestBody BasicTestDto basicTestDto){
		System.out.println("데이터 추가");
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto));
	}
}
