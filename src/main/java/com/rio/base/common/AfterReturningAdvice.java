package com.rio.base.common;

import org.aspectj.lang.JoinPoint;

import com.rio.base.domain.TodoVO;
import com.rio.base.domain.UserVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AfterReturningAdvice {

	// pointcut 으로 지정된 메서드가 정상적으로 실행되고 나서 메서드 수행결과로 생성된 데이터를 리턴하는 시점에 동작한다.
	// AOP xml 설정 기준
//	public void afterLog() {
//		log.info("[사후처리] : 비지니스 로직 수행 후 처리");
//	}
	
	
	public void afterLog(JoinPoint joinPoint, Object returnObj) {
		String method = joinPoint.getSignature().getName();
		
		// 설정상으로 아무거나 만들어 넣었지만 원래는 정말 사용하는 객체를 넣자.
		// instanceof 는 returnObj 와 TodoVO가 같은 객체인지 확인하는 것이다.
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if (user.getRole().equals("admin")) {
				log.info(user.getName() + " 로그인(Admin)");
			}
		}
		log.info("[사후처리] : " + method + "() 메서드 리턴값 : " + returnObj.toString());
	}
	
	/**
	 * 위의 예제에서 afterLog() 메서드에서 클라이언트가 호출한 비지니스 메서드 정보를 알아내기 위해서 JoinPoint 객체를 첫 번째 매개변수로 선언하였다.
	 * 그리고 Object 타입의 변수도 두 번째 매개변수로 선언하였는데 이를 "바인딩 변수" 라고 한다.
	 * 바인드 변수는 비지니스 메서드가 리턴한 결과 값을 바인딩 할 목적으로 사용하며 어떤 값이 리턴 될지 모르기 때문에 Object 타입으로 선언한다.
	 */
}
