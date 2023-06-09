package com.rio.base.controller.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CheckboxFormatter implements Formatter<Boolean> {

	@Override
	public String print(Boolean object, Locale locale) {
		// TODO Auto-generated method stub
		return object.toString();
	}

	@Override
	public Boolean parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		if (text == null) {
			return false;
		}
		return text.equals("on");
	}
	

}
