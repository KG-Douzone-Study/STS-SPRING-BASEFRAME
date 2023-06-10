package com.rio.base.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AfterReturningAdvice {

	// pointcut 으로 지정된 메서드가 정상적으로 실행되고 나서 메서드 수행결과로 생성된 데이터를 리턴하는 시점에 동작한다.
	public void afterLog() {
		log.info("[사후처리] : 비지니스 로직 수행 후 처리");
	}
}
