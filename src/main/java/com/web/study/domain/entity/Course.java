package com.web.study.domain.entity;

import java.time.LocalDate;

import com.web.study.dto.response.CourseRespDto;

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
public class Course {
	private int csm_id;
	private int ltm_id;
	private int sdm_id;
	private LocalDate registe_date;
	private Lecture lecture;
	private Student student;
	
	public CourseRespDto toDto() {
		
		String lectureName = null;
		int lecturePrice = 0;
		String instuctorName = null;
		String studentName = null;
		
		if(lecture != null) {
			lectureName = lecture.getLtm_name();
		    lecturePrice = lecture.getLtm_price();
		    if(lecture.getInstructor() != null) {
		    	instuctorName = lecture.getInstructor().getItm_name();
		    }
		}
		if(lecture != null) {
			studentName = student.getSdm_name();
		}
		
		return CourseRespDto.builder()
				.courseId(csm_id)
				.registeDate(registe_date)
				.lectureName(lectureName)
				.lecturePrice(lecturePrice)
				.instructorName(instuctorName)
				.studentName(studentName)
				.build();
				
				
	}
}