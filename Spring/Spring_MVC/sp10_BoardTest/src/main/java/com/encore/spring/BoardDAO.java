package com.encore.spring;

import java.util.List;

public interface BoardDAO {

	void insert(Board vo) throws Exception;
	List<Board> selectAll() throws Exception;
	Board selectOne(int no) throws Exception;
	
	
}
