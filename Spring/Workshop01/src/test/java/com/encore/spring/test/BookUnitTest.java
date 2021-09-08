package com.encore.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Book;

public class BookUnitTest {
	@Test
	public void unit() throws Exception{
		
		//1. 설정문서 읽어들여서
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. SqlSession
		SqlSession session = factory.openSession();
		
		Book book = new Book("1235-546-894","MyBatis","Programming","Foreign","2021-06-28","Encore","Peter",10,"$","asdf");
		
		//INSERT
		System.out.println(":: 1. addBook(INSERT)  ? ");
		System.out.println(":: "+session.insert("BookMapper.addBook", book) );
		
		//SELECT
		System.out.println(":: 2. getBookList(SELECT)  ? ");
		List<Book> list = session.selectList("BookMapper.getBookList");
		for(Book b : list) System.out.println(b);
		
	}
}
