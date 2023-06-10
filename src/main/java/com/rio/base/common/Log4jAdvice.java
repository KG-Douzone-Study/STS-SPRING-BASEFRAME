package com.rio.base.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Log4jAdvice {
	
	public void printLogging() {
		log.info("[로그 - Log4jAdvice] : 비지니스 로직 수행 전 동작");
	}
	
	// 결론 : OOP처럼 모듈화가 뛰어난 언어를 사용하여 개발을 하더라도 공통모듈에 해당하는 Advice
	// 클래스 객체를 생성하고 공통 메서드를 호출하는 코드가 비지니스 메서드에 있다면
	// 핵심관심과 횡단관심을 완벽하게 분리할 수 없다.
	// 스프링 AOP는 이런 OOP의 한계를 극복할 수 있게 도와준다.
}
