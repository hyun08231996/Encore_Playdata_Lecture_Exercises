package com.encore.board.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int write(BoardVO vo) {
		// TODO Auto-generated method stub
		int row = boardDAO.write(vo);
		System.out.println("Before vo :: "+vo);
		
		String date = boardDAO.selectByNoForDate(vo.getNo());
		vo.setWriteDate(date);
		
		System.out.println("After vo :: "+vo);
		return row;
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList();
	}

	@Override
	public BoardVO showContent(int no) {
		// TODO Auto-generated method stub
		boardDAO.clickCount(no);
		return boardDAO.showContent(no);
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return boardDAO.delete(no);
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.update(vo);
	}


}
