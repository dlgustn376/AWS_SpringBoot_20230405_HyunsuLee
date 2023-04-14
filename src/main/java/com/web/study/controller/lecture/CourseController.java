 package com.web.study.controller.lecture;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.aop.annotation.CheckNameAspect;
import com.web.study.aop.annotation.ParamsAspect;
import com.web.study.aop.annotation.TimerAspect;
import com.web.study.aop.annotation.ValidAspect;
import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.dto.request.course.SearchCourseReqDto;
import com.web.study.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CourseController {
	
	private final CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<? extends ResponseDto> registeCourse(@RequestBody CourseReqDto courseReqDto){
		
		courseService.registeCourse(courseReqDto);
		
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	@CheckNameAspect
	@TimerAspect
	@GetMapping("/courses")
		public ResponseEntity<? extends ResponseDto> getCourseAll(){
//		if(1 == 1) {
//			throw new CustomException("예외 만들기");
//		}
		return ResponseEntity.ok().body(DataResponseDto.of(courseService.getCourseAll()));
	}
	
	@ValidAspect
	@ParamsAspect
	@GetMapping("/search/courses")								// @Valid 와 BindingResult는 세트
	public ResponseEntity<? extends ResponseDto> searchCourse(@Valid SearchCourseReqDto searchCourseReqDto, BindingResult bindingResult){  //@RequestParam 생략된것
//		if(errorMap.isEmpty()) {
//			throw new CustomException("유효성 검사 실패", errorMap);
//		}
		
//		if(bindingResult.hasErrors()) {
//			Map<String,String> errorMap = new HashMap<>();
//			
//			bindingResult.getFieldErrors().forEach(error -> {
//				errorMap.put(error.getField(), error.getDefaultMessage());
//			});
//			
//			throw new CustomException("유효성 검사 실패",errorMap);
//		}
		
		return ResponseEntity.ok().body(DataResponseDto.of(courseService.searchCourse(searchCourseReqDto.getType(), searchCourseReqDto.getSearchValue())));
	}
	
	
	
}
