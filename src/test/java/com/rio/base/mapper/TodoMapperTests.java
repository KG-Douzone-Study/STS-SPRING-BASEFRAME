package com.rio.base.mapper;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rio.base.domain.TodoVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TodoMapperTests {
	
	@Autowired(required = false)
	private TodoMapper todoMapper;
	
	@Test
	public void testGetTime() {
		log.info(todoMapper.getTime());
	}
	
	@Test
	public void testInsert() {
		
		TodoVO todoVO = TodoVO.builder()
				.title("스프링 테스트")
				.dueDate(LocalDate.of(2022, 10, 10))
				.writer("user00")
				.build();
		
		todoMapper.insert(todoVO);
	}

}
