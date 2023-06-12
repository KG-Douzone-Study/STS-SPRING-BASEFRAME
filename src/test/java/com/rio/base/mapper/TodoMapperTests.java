package com.rio.base.mapper;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rio.base.domain.TodoVO;
import com.rio.base.dto.PageRequestDTO;
import com.rio.base.dto.PageResponseDTO;
import com.rio.base.dto.TodoDTO;

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
	
//	@Test
//	public void testInsert() {
//		
//		TodoVO todoVO = TodoVO.builder()
//				.title("스프링 테스트")
//				.dueDate(LocalDate.of(2022, 10, 10))
//				.writer("user00")
//				.build();
//		
//		todoMapper.insert(todoVO);
//	}
	
	@Test
	public void testSelectAll() {
		
		List<TodoVO> voList = todoMapper.selectAll();
		
		voList.forEach(vo -> log.info(vo));
		
	}
	
	@Test
	public void testSelectOne() {
		
		TodoVO todoVO = todoMapper.selectOne(3L);
		
		log.info(todoVO);
	}
	
	@Test
	public void testSelectList() {
		
		PageRequestDTO pageReqeustDTO = PageRequestDTO.builder()
				.page(1)
				.size(10)
				.build();
		
		List<TodoVO> voList = todoMapper.selectList(pageReqeustDTO);
		
		voList.forEach(vo -> log.info(vo));
	}
	
	

}
