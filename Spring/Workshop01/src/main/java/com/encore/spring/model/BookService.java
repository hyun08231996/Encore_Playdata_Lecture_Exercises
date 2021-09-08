package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Book;

public interface BookService {
	void addBook(Book book) throws Exception;
	List<Book> getBookList() throws Exception;
	Book getBook(String isbn) throws Exception;
	List<Book> getBooksByTitle(String title) throws Exception;
	List<Book> getBooksByAuthor(String author) throws Exception;
	List<Book> getBooksByCatalogue(String catalogue) throws Exception;
}
