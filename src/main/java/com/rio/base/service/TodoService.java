package com.rio.base.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.rio.base.dto.PageRequestDTO;
import com.rio.base.dto.PageResponseDTO;
import com.rio.base.dto.TodoDTO;

public interface TodoService {
	
	void register(TodoDTO todoDTO);
	
	//List<TodoDTO> getAll();
	
	PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
	
	TodoDTO getOne(Long tno);
	
	void remove(Long tno);
	
	void modify(TodoDTO todoDTO);
	
	
	// Postman Test, React Test
//	ResponseEntity<?> getAllJson();

}
