package com.web.study.dto.request.student;

import java.time.LocalDate;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class StudentReqDto {
	
	private String name;
	private LocalDate birthDate;
	
}
