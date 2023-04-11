package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.dto.request.lecture.LectureReqDto;
import com.web.study.dto.response.LectureRespDto;
import com.web.study.dto.response.InstructorRespDto;
import com.web.study.repository.LectureRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService{

	private final LectureRepository lectureRepository;
	
	@Override
	public void registeLecture(LectureReqDto lectureReqDto) {
		// DTO -> ENTITY 변환
//		Lecture lecture = lectureReqDto.toEntity();
//		System.out.println("변환: " + lecture);
		lectureRepository.registe(lectureReqDto.toEntity()); // DB에 전달
	}

	@Override
	public List<LectureRespDto> getLectureAll() {
		List<LectureRespDto> dtos = new ArrayList<>();
		
		lectureRepository.getLectureAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		return dtos;
	}

}
