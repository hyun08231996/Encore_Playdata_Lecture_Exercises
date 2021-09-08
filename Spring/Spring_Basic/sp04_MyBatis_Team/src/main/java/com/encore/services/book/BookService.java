package com.encore.services.book;

import java.util.List;

import com.encore.services.domain.Book;

public interface BookService {
	void bookAdd(Book book) throws Exception;
	void bookUpdate(Book book) throws Exception;
	Book getBook(String isbn) throws Exception;
	List<Book> getBookList(Book book) throws Exception;
}
