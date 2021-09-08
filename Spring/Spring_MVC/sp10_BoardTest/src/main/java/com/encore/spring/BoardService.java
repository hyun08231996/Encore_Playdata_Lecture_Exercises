package com.encore.spring;

import java.util.List;

public interface BoardService {
	void insert(Board vo) throws Exception;
	List<Board> selectAll() throws Exception;
	Board selectOne(int no) throws Exception;
}
