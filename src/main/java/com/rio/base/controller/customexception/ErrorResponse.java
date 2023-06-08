package com.rio.base.controller.customexception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Builder
public class ErrorResponse {
	
	private final LocalDateTime timestmap = LocalDateTime.now();
	private final int status;
	private final String error;
	private final String code;
	private final String message;
	
	public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
		
		return ResponseEntity
				.status(errorCode.getHttpStatus())
				.body(ErrorResponse.builder()
						.status(errorCode.getHttpStatus().value())
						.error(errorCode.getHttpStatus().name())
						.code(errorCode.name())
						.message(errorCode.getDetail())
						.build()
				);
		
	}

}
