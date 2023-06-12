package com.rio.base.mapper;

import java.util.List;

import com.rio.base.domain.TodoVO;
import com.rio.base.dto.PageRequestDTO;

public interface TodoMapper {
	
	String getTime();
	
	void insert(TodoVO todoVO);
	
	List<TodoVO> selectAll();
	
	TodoVO selectOne(Long tno);
	
	void delete(Long tno);
	
	void update(TodoVO todoVO);
	
	List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
	
	int getCount(PageRequestDTO pageRequestDTO);

}
