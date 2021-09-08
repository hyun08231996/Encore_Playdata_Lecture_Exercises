package com.encore.spring.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.User;

public class UserUnitTest {
	@Test
	public void unit() throws Exception{
		
		//1. 설정문서 읽어들여서
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. SqlSession
		SqlSession session = factory.openSession();
		
		User user = new User("admin","admin","관리자","admin@encore.com");
		
		//SELECT
		System.out.println(":: 1. getUser(SELECT)  ? ");
		System.out.println(":: "+session.selectOne("UserMapper.getUser",user) );
		
		System.out.println(":: 2. getUserList(SELECT)  ? ");
		System.out.println(":: "+session.selectList("UserMapper.getUserList") );
		
	}
}
