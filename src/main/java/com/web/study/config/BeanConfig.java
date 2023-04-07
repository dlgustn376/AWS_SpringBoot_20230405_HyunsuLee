package com.web.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.study.IocAndDi.TestC;

//Bean을 등록해주는 Component
@Configuration
public class BeanConfig {
	
	@Bean
	public TestC testC() {  // 매서드 명이 Component name이 된다.
							// 라이브러리에서 생성해서 사용을 해야하는 것을 가져와서 쓰기 위해서
		return new TestC();
	}
	
	
}
