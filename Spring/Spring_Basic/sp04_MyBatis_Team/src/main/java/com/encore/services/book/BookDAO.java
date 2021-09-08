package com.encore.services.book;

import java.util.List;

import com.encore.services.domain.Book;

public interface BookDAO {
	int bookAdd(Book book) throws Exception;
	int bookUpdate(Book book) throws Exception;
	int bookDelete(String isbn) throws Exception;
	Book getBook(String isbn) throws Exception;
	List<Book> getBookList(Book book) throws Exception;
}
