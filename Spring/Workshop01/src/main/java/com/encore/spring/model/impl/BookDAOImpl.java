package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.Book;
import com.encore.spring.model.BookDAO;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addBook(Book book) throws Exception {
		sqlSession.insert("BookMapper.addBook",book);
		
	}

	@Override
	public List<Book> getBookList() throws Exception {
		return sqlSession.selectList("BookMapper.getBookList");
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return sqlSession.selectOne("BookMapper.getBook",isbn);
	}

	@Override
	public List<Book> getBooksByTitle(String title) throws Exception {
		return sqlSession.selectList("BookMapper.getBooksByTitle",title);
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws Exception {
		return sqlSession.selectList("BookMapper.getBooksByAuthor",author);
	}

	@Override
	public List<Book> getBooksByCatalogue(String catalogue) throws Exception {
		return sqlSession.selectList("BookMapper.getBooksByCatalogue",catalogue);
	}

}
