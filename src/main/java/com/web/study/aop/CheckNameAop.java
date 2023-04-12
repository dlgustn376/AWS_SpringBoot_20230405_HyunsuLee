package com.web.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class CheckNameAop {
	
	@Pointcut("execution(* com.web.study..*.*(..))")
	private void pointCut() {}
	
	@Pointcut("@annotation(com.web.study.aop.annotation.CheckNameAspect)")
	private void annotationPointCut() {}
	
	@Around("annotationPointCut()&&pointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object logic = joinPoint.proceed();
		
		log.info("[ Name ] >>> 클래스명 {}: 메소드명 {}: ", 
				joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName());
		
		return logic;
		
	}

}
