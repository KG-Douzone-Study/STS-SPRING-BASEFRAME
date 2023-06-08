package com.rio.base.mapper;

import com.rio.base.domain.TodoVO;

public interface TodoMapper {
	
	String getTime();
	
	void insert(TodoVO todoVO);

}
