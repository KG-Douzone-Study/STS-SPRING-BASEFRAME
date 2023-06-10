package com.rio.base.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AfterAdvice {
	
	// try~catch~finally 구문에서 finally 블록처럼 예외 발생 여부에
	// 상관없이 무조건 수행되는 어드바이스를 등록할 때 
	public void finallyLog() {
		log.info("[사후처리] : 비지니스 로직 수행 후 무조건 동작");
	}

}
