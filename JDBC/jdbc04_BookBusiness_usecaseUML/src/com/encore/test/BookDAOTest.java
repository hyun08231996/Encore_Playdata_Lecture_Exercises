package com.encore.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.encore.dao.impl.BookDAOImpl;
import com.encore.exception.BookNotFoundException;
import com.encore.exception.DuplicateISBNException;
import com.encore.exception.InvalidInputException;
import com.encore.vo.Book;

import config.ServerInfo;

public class BookDAOTest {

	public static void main(String[] args) {
		BookDAOImpl dao = BookDAOImpl.getInstance();
		try {
			//dao.registerBook(new Book("8H8", "자율주행", "로드만", "encore", 34000));
		}catch(Exception e) {
			System.out.println("책 등록 실패"); 
		}
		try {
			//dao.deleteBook("8H8");
		}catch(Exception e) {
			System.out.println("책 삭제 실패"); 
		}
		
		try {
			ArrayList<Book> returnList = dao.findByWriter("나가타");
			for(Book b : returnList) System.out.println(b);
		}catch(Exception e) {
			
		}
		
		try {
			ArrayList<Book> returnList = dao.findByPrice(10000,20000);
			for(Book b : returnList) System.out.println(b);
		}catch(Exception e) {
			
		}
		
		try {
			dao.discountBook(10, "동아");
		}catch(Exception e) {
			
		}
		
		
//		try {
//			BookDAOImpl dao = BookDAOImpl.getInstance();
//			dao.registerBook(new Book("G3D", "Harry Potter", "Rowling", "Bloomsbury", 20000));
//			dao.deleteBook("G3D");
//			if(dao.findByBook("1A1", "강아지똥")==null) System.out.println("Book does not exist...");
//			else System.out.println(dao.findByBook("1A1", "강아지똥"));
//			ArrayList<Book> returnBook = dao.findByWriter("나가타");
//			for(Book b : returnBook) {
//				if(returnBook == null) System.out.println("Book does not exist...");
//				else System.out.println(b);
//			}
//			ArrayList<Book> returnBook1 = dao.findByPublisher("동아");
//			for(Book b : returnBook1) {
//				if(returnBook1 == null) System.out.println("Book does not exist...");
//				else System.out.println(b);
//			}
//			ArrayList<Book> returnBook2 = dao.findByPrice(10000,30000);
//			for(Book b : returnBook2) {
//				if(returnBook2 == null) System.out.println("Book does not exist...");
//				else System.out.println(b);
//			}
//			dao.discountBook(10, "동아");
//			
//			dao.printAllInfo();
//		} catch(DuplicateISBNException e) {
//			System.out.println(e.getMessage());
//		} catch(BookNotFoundException e) {
//			System.out.println(e.getMessage());
//		} catch(InvalidInputException e) {
//			System.out.println(e.getMessage());
//		} catch(ClassNotFoundException e) {
//			System.out.println("Driver loading failed...");
//		} catch(SQLException e) {
//			System.out.println("DB Connection failed...");
//		}
		
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER);
			System.out.println("드라이버 로딩 성공~~!!");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패~~!!");
		}
	}

}
