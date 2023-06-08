package com.rio.base.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {
	
	// MyBatis를 이용하는 개발 단계
	/**
	 * 1. VO 선언
	 * 2. Mapper 인터페이스 개발
	 * 3. XML의 개발
	 * 4. 테스트 코드의 개발
	 */
	
	private Long tno;
	private String title;
	private LocalDate dueDate;
	private String writer;
	private boolean finished;

}
