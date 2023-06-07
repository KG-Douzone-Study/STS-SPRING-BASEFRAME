package com.rio.base.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
@Service
public class SampleService {
	
	@Qualifier("normal")
	private final SampleDAO sampleDAO;

}
