package com.web.study.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TimerApp {
	
//	private final Logger logger = LogManager.getLogger(TimerApp.class);  lombok 쓰면 필요 없어짐.
	
	// 접근지정자 public은 생략 가능
	@Pointcut("execution(* com.web.study..*.*(..))")
	private void pointCut() {}
	
	@Pointcut("@annotation(com.web.study.aop.annotation.TimerAspect)")
	private void annotationPointCut() {}
	
	@Around("annotationPointCut()&&pointCut()")  // advice라고 생각하면 됨.
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();		
		
		// 전처리
		Object logic = joinPoint.proceed(); // proceed = 메소드 호출, 해당 매소드 실행
		// 후처리
		
		stopWatch.stop();
		log.info("[ Time ] >>> {}.{}: {}초", 
				joinPoint.getSignature().getDeclaringTypeName(),// 클래스 명 
				joinPoint.getSignature().getName(), // 메소드 명
				stopWatch.getTotalTimeSeconds()); // 시간
		return logic;
	}
	
}
