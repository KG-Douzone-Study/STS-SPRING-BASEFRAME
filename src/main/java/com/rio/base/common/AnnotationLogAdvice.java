package com.rio.base.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
@Service
public class AnnotationLogAdvice {
	
	@Pointcut("execution(* com.rio.base..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Pointcut("execution(* com.rio.base..*Impl.get*(..))")
	public void getPointcut() {
		
	}
	
	@Before("allPointcut()")
	public void printLog() {
		log.info("[공통 로그] : 비지니스 로직 수행 전 동작 ");
	}
	
	@Before("allPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		log.info("[사전처리] : " + method + "()");
		}

}
