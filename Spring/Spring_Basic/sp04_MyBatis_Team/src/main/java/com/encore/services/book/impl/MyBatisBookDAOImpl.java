package com.encore.services.book.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.services.book.BookDAO;
import com.encore.services.domain.Book;

@Repository
public class MyBatisBookDAOImpl implements BookDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int bookAdd(Book book) throws Exception {
		int result = sqlSession.insert("bookMapper.bookAdd",book);
		//sqlSession.commit();
		return result;
	}

	@Override
	public int bookUpdate(Book book) throws Exception {
		int result = sqlSession.update("bookMapper.bookUpdate",book);
		//sqlSession.commit();
		return result;
	}

	@Override
	public int bookDelete(String isbn) throws Exception {
		int result = sqlSession.delete("bookMapper.bookDelete",isbn);
		//sqlSession.commit();
		return result;
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return sqlSession.selectOne("bookMapper.getBook", isbn);
	}

	@Override
	public List<Book> getBookList(Book book) throws Exception {
		return sqlSession.selectList("bookMapper.getBookList", book);
	}

}
