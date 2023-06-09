package com.web.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.web.study.aop.annotation.ReturnDataAspect;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.dto.response.CourseRespDto;
import com.web.study.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
	
	private final CourseRepository courseRepository;
	
	@Override
	public void registeCourse(CourseReqDto courseReqDto) {
		courseRepository.saveCourse(courseReqDto.toEntity());
	}

	@Override
	public List<CourseRespDto> getCourseAll() {
		List<CourseRespDto> dtos = new ArrayList<>();
		
		courseRepository.getCourseAll().forEach(entity->{
			dtos.add(entity.toDto());
		});
		return dtos;
	}
	
	@ReturnDataAspect
	@Override
	public List<CourseRespDto> searchCourse(int type, String searchValue) {
		Map<String, Object> parmeterMap = new HashMap<>();
		parmeterMap.put("type", type);
		parmeterMap.put("searchValue", searchValue);
		
		List<CourseRespDto> dtos = new ArrayList<>();
		courseRepository.searchCourse(parmeterMap).forEach(entity->{
			dtos.add(entity.toDto());
		});
		return dtos;
	}

}
