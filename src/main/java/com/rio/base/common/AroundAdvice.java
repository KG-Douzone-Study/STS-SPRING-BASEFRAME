package com.rio.base.common;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AroundAdvice {
	
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("[BEFORE] : 비지니스 메서드 수행 전에 처리할 내용 ...");
		Object returnObj = joinPoint.proceed();
		log.info("[AFTER] : 비지니스 메서드 수행 후에 처리할 내용 ...");
		return returnObj;
	}

}
