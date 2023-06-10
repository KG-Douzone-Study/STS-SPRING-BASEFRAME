package com.rio.base.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogAdvice {
	
	// OOP를 활용한 공통기능 처리 : AOP 적용전, 문제점 많음 공통코드 양산과정 1
	
	public void printLog() {
		log.info("[로그] : 비지니스 로직 수행 전 동작");
	}

}
