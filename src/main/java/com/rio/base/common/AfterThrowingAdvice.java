package com.rio.base.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AfterThrowingAdvice {
	
	// After Throwing Advice 는 포인트컷으로 지정한 메서드가 실행되다가 예외가 발생하는 시점에 동작한다.
	// 따라서 예외처리 어드바이스를 설정할 때 사용한다.
	public void exceptionLog() {
		log.info("[예외처리] : 비지니스 로직 수행 중 예외 발생");
	}

}
