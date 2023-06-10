package com.rio.base.common;

import org.aspectj.lang.JoinPoint;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AfterThrowingAdvice {
	
	// After Throwing Advice 는 포인트컷으로 지정한 메서드가 실행되다가 예외가 발생하는 시점에 동작한다.
	// 따라서 예외처리 어드바이스를 설정할 때 사용한다.
	// AOP xml 설정
//	public void exceptionLog() {
//		log.info("[예외처리] : 비지니스 로직 수행 중 예외 발생");
//	}
	
	
	public void exceptionLog(JoinPoint joinPoint, Exception e) {
		String method = joinPoint.getSignature().getName();
		log.info("[예외처리] : " + method + "() 메서드 수행 중 발생된 예외 메세지 : " + e.getMessage());
	}

}
