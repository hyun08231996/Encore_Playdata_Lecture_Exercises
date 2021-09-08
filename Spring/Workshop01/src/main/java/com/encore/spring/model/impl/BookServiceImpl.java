package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Book;
import com.encore.spring.model.BookDAO;
import com.encore.spring.model.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public void addBook(Book book) throws Exception {
		bookDAO.addBook(book);
		
	}

	@Override
	public List<Book> getBookList() throws Exception {
		return bookDAO.getBookList();
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.getBook(isbn);
	}

	@Override
	public List<Book> getBooksByTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.getBooksByTitle(title);
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.getBooksByAuthor(author);
	}

	@Override
	public List<Book> getBooksByCatalogue(String catalogue) throws Exception {
		// TODO Auto-generated method stub
		return bookDAO.getBooksByCatalogue(catalogue);
	}

}
