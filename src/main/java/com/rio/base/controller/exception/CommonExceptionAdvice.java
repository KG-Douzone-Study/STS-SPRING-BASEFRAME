package com.rio.base.controller.exception;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

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
	
	// 404 에러페이지와 @ResponseStatus
	// custom404.jsp 페이지를 만들고 web.xml에 DispatcherServlet 설정을 조정해야 한다.
	// <servlet> 태그 내에 <init-param>을 추가하고 throwExcetionIfNoHandlerFound라는 파라미터 설정을 추가해야 한다.
	/**
	 * jsp가 아닌 react 같은 것을 쓸때는 @ExceptionHandler 나 ResponseStatusException 같은 걸 쓸거 같다.
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404
	public String notFound() {
		return "custom404";
	}
	

}
