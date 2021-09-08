package com.encore.services.book.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.services.book.BookDAO;
import com.encore.services.book.BookService;
import com.encore.services.domain.Book;

@Service
public class MyBatisBookServiceImpl implements BookService{
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public void bookAdd(Book book) throws Exception {
		bookDAO.bookAdd(book);
		
	}

	@Override
	public void bookUpdate(Book book) throws Exception {
		bookDAO.bookUpdate(book);
		
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return bookDAO.getBook(isbn);
	}

	@Override
	public List<Book> getBookList(Book book) throws Exception {
		return bookDAO.getBookList(book);
	}

}
