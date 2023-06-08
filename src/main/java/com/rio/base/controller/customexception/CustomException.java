package com.rio.base.controller.customexception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author 
 * 일반 예외로 선언할 경우 Exception을 상속받아 구현하면 되고
 * 실행 예외로 선언할 경우에는 RuntimeException을 상속받아 구현하면 된다.
 *
 */
@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {

	private final ErrorCode errorCode;
}
