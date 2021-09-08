package com.encore.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.MyProduct;

public class MyProductUnitTest1 {

	@Test
	public void unit() throws Exception{
		
		//1. 설정문서 읽어들여서
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. SqlSession
		SqlSession session = factory.openSession();
		
		//4. 쿼리문 수행..
		//INSERT
//		MyProduct product = new MyProduct("드럼 세탁기","LG",350000);
//		System.out.println(":: 1. addProduct(INSERT)  ? "
//													+ session.insert("ProductMapper.addProduct", product)); //1
//													  session.commit();
		//SELECT
		System.out.println(":: 2. getProductsByName(SELECT)  ? ");
		System.out.println(":: "+session.selectList("ProductMapper.getProductsByName","세탁기") );
		
		System.out.println(":: 3. getProductsByMaker(SELECT)  ? ");
		System.out.println(":: "+session.selectList("ProductMapper.getProductsByMaker","삼성") );
		
		System.out.println(":: 4. getProductList(SELECT)  ? ");
		System.out.println(":: "+session.selectList("ProductMapper.getProductList") );
	}
}
