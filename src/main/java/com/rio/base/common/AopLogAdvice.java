package com.rio.base.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AopLogAdvice {
	
	public void printLog() {
		log.info("[로그] : 비지니스 로직 수행 전 동작");
	}

}
