package com.rio.base.mapper;

import java.util.List;

import com.rio.base.domain.TodoVO;

public interface TodoMapper {
	
	String getTime();
	
	void insert(TodoVO todoVO);
	
	List<TodoVO> selectAll();
	
	TodoVO selectOne(Long tno);
	
	void delete(Long tno);
	
	void update(TodoVO todoVO);

}
