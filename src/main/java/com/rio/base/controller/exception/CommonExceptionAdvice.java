package com.rio.base.controller.exception;

import java.util.Arrays;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class CommonExceptionAdvice {
	
	// SampleController.java에 동작을 확인하기 위해 고의로 예외를 발생하는 코드를 추가
	
	/**
	 * 
	 * @annotation ExceptionHanlder가 지정되어 있고, NumberFormatException 타입을 지정하고 있는데
	 * @ExceptionHandler 를 가진 모든 메소드는 해당 타입의 예외를 파라미터로 전달받을 수 있다.
	 */
	@ResponseBody
	@ExceptionHandler(NumberFormatException.class)
	public String exceptionNumber(NumberFormatException numberFormatException) {
		
		log.error("-------------------------------");
		log.error(numberFormatException.getMessage());
		
		return "NUMBER FORMAT EXCEPTION";
	}
	
	// 범용적인 예외처리
	
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public String exceptCommon(Exception exception) {
		
		log.error("-----------------------------------");
		log.error(exception.getMessage());
		
		StringBuffer buffer = new StringBuffer("<ul>");
		
		buffer.append("<li>" + exception.getMessage() + "</li>");
		
		Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
			buffer.append("<li>" + stackTraceElement + "</li>");
		});
		
		buffer.append("<ul>");
		
		return buffer.toString();
		
	}
	

}
