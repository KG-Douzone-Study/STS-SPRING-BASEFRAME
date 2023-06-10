package com.rio.base.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AroundAdvice {
	
	// AOP xml 설정
//	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
//		log.info("[BEFORE] : 비지니스 메서드 수행 전에 처리할 내용 ...");
//		Object returnObj = joinPoint.proceed();
//		log.info("[AFTER] : 비지니스 메서드 수행 후에 처리할 내용 ...");
//		return returnObj;
//	}
	
	
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		String method = joinPoint.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = joinPoint.proceed();
		stopWatch.stop();
		log.info(method + "() 메서드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}

}
