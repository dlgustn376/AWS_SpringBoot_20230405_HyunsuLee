package com.web.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {
	
//	@Autowired
//	private IocTest iocTest;
	
	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
//		iocAndDiTest();
	}
	
//	public static void iocAndDiTest() {
//		Inversion Of Control
//		제어의 역전. Spring이 제어를 함.
//		IocTest iocTest =  new IocTest(new TestC());
//		iocTest.run();
//	}
}
