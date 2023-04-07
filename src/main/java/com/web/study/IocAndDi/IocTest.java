package com.web.study.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IocTest {
	
	@Qualifier("t1")
	@Autowired
	private Test test;
	
	//DI 외부에서 의존성 주입.
//	public IocTest(Test test) {
//		this.test  = test;
//	}
	
	public void run() {
		test.printTest();
		System.out.println("IocTest출력!");
	}
}
