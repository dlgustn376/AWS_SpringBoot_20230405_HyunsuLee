package com.web.study.domain.entity;

import java.time.LocalDate;

import com.web.study.dto.response.LectureRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Lecture {
	private int ltm_id;
	private String ltm_name;
	private int ltm_price;
	private int itm_id;
	private Instructor instructor;
	
	public LectureRespDto toDto() {
		return LectureRespDto.builder()
				.id(ltm_id)
				.lecture_name(ltm_name)
				.lecture_price(ltm_price)
				.instructor_id(itm_id)
				.build();
	}
}
