package com.encore.spring.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.Board;

public class BoardUnitTest {
	
	@Test
	public void unit() throws Exception{
		
		//1. 설정문서 읽어들여서
		Reader r = Resources.getResourceAsReader("spring/SqlMapConfig.xml");
		
		//2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. SqlSession
		SqlSession session = factory.openSession();
		
		//4. 쿼리문 수행..
		//INSERT
//		Board board = new Board("Encore","TEST","Test");
//		System.out.println(":: 1. insert(INSERT)  ? "
//													+ session.insert("BoardMapper.insert", board)); //1
//													  session.commit();
		//SELECT
		System.out.println(":: 2. selectAll(SELECT)  ? ");
		System.out.println(":: "+session.selectList("BoardMapper.selectAll") );
		
		System.out.println(":: 3. selectOne(SELECT)  ? ");
		System.out.println(":: "+session.selectOne("BoardMapper.selectOne",1) );
	}
}
