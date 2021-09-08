package com.encore.spring.model.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "ProductMapper.";

	@Override
	public boolean addProduct(MyProduct product) throws Exception {
		return sqlSession.insert(NS+"addProduct",product)==1 ? true:false;
	}

	@Override
	public List<MyProduct> getProductsByName(String name) throws Exception {
		return sqlSession.selectList(NS+"getProductsByName",name);
	}

	@Override
	public List<MyProduct> getProductsByMaker(String maker) throws Exception {
		return sqlSession.selectList(NS+"getProductsByMaker",maker);
	}

	@Override
	public List<MyProduct> getProductList() throws Exception {
		return sqlSession.selectList(NS+"getProductList");
	}

	@Override
	public MyProduct getProduct(int id) throws Exception {
		return sqlSession.selectOne(NS+"getProduct",id);
	}
	
	@Override
	public List<MyProduct> searchProduct(Map map) throws Exception {
		return sqlSession.selectList(NS+"searchProduct", map);
	}

	@Override
	public boolean updateProduct(MyProduct product) throws Exception {
		return sqlSession.update(NS+"updateProduct",product)==1 ? true:false;
		
	}

	@Override
	public boolean deleteProduct(int id) throws Exception {
		return sqlSession.delete(NS+"deleteProduct",id)==1 ? true:false;
		
	}
	
	
}
