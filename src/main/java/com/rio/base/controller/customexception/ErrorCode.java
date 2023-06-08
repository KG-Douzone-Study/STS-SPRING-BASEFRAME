package com.rio.base.controller.customexception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	
	/* 404 NOT_FOUND */
	PAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "페이지를 찾을 수 없습니다.");
	
	private final HttpStatus httpStatus;
	private final String detail;

}
