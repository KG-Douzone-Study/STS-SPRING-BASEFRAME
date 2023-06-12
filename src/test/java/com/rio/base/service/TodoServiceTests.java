package com.rio.base.service;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rio.base.dto.PageRequestDTO;
import com.rio.base.dto.PageResponseDTO;
import com.rio.base.dto.TodoDTO;
import com.rio.base.mapper.TodoMapperTests;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TodoServiceTests {
	
	@Autowired
	private TodoService todoService;
	
	@Test
	public void testRegister() {
		
		TodoDTO todoDTO = TodoDTO.builder()
				.title("Test.....")
				.dueDate(LocalDate.now())
				.writer("user1")
				.build();
		
		todoService.register(todoDTO);
	}
	
	@Test
	public void testPaging() {
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
		
		PageResponseDTO<TodoDTO> responseDTO = todoService.getList(pageRequestDTO);
		
		log.info(responseDTO);
		
		responseDTO.getDtoList().stream().forEach(todoDTO -> log.info(todoDTO));
	}

}
