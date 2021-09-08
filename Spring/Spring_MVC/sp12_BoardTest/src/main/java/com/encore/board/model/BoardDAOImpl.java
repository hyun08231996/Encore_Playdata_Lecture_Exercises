package com.encore.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.board.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	final String NS = "sql.board.mapper.";
	
	@Override
	public int write(BoardVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"write", vo);
	}

	@Override
	public String selectByNoForDate(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"selectByNoForDate",no);
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"getBoardList");
	}

	@Override
	public BoardVO showContent(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"showContent",no);
	}

	@Override
	public int clickCount(int no) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"clickCount", no);
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(NS+"delete", no);
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"update",vo);
	}


}
