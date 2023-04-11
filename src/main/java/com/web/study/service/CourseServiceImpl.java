package com.web.study.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.web.study.domain.entity.Course;
import com.web.study.dto.request.course.CourseReqDto;
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
	public List<Course> getCourseAll() {
		return courseRepository.getCourseAll();
	}

	@Override
	public List<Course> searchCourse(int type, String searchValue) {
		Map<String, Object> parmeterMap = new HashMap<>();
		parmeterMap.put("type", type);
		parmeterMap.put("searchValue", searchValue);
		
		return courseRepository.searchCourse(parmeterMap);
	}

}
