package com.rio.base.controller.formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.format.Formatter;

public class LocalDateFormatter implements Formatter<LocalDate>{
	
	/**
	 * Formatter 를 servlet-context.xml 에 적용하기 위해서는 조금 복잡한 과정이 필요하다.
	 * FormattingConversion-ServiceFactoryBean 객체를 스프링의 Bean 으로 등록해야 하고
	 * 이 안에 작성한 LocalDateFormatter를 추가해야 한다.
	 */

	@Override
	public String print(LocalDate object, Locale locale) {
		// TODO Auto-generated method stub
		return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

}
