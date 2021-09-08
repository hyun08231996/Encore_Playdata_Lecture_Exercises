package com.encore.board.model;

import java.util.List;

import com.encore.board.domain.BoardVO;

public interface BoardService {
	int write(BoardVO vo);
	
	List<BoardVO> getBoardList();
	BoardVO showContent(int no);
	
	int delete(int no);
	int update(BoardVO vo);
}
