package com.rio.base.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BeforeAdvice {
	
	// xml 기반 설정 메서드
//	public void beforeLog() {
//		log.info("[사전처리] : 비지니스 로직 수행 전 동작");
//	}
	
	// xml 기반 설정 메서
//	public void beforeLog(JoinPoint joinPoint) {
//		String method = joinPoint.getSignature().getName();
//		Object[] args = joinPoint.getArgs();
//		log.info("[사전처리] : " + method + "()" );
//	}
	
	// 안되는뎁...
	@Before("AnnotationPointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		log.info("[사전처리] : " + method + "()" );
	}

}
