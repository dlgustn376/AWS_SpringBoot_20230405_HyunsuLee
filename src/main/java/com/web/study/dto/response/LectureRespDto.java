package com.web.study.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LectureRespDto {
	private int id;
	private String lecture_name;
	private int lecture_price;
	private int instructor_id;
}
