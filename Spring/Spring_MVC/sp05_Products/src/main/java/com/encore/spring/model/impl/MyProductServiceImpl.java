package com.encore.spring.model.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;
import com.encore.spring.model.MyProductService;

@Service
@Transactional
public class MyProductServiceImpl implements MyProductService{
	
	@Autowired
	private MyProductDAO myProductDAO;
	
	@Transactional
	@Override
	public void addProduct(MyProduct product) throws Exception {
		myProductDAO.addProduct(product);
		
	}

	@Override
	public List<MyProduct> getProductsByName(String name) throws Exception {
		return myProductDAO.getProductsByName(name);
	}

	@Override
	public List<MyProduct> getProductsByMaker(String maker) throws Exception {
		return myProductDAO.getProductsByMaker(maker);
	}

	@Override
	public List<MyProduct> getProductList() throws Exception {
		return myProductDAO.getProductList();
	}

	@Override
	public MyProduct getProduct(int id) throws Exception {
		return myProductDAO.getProduct(id);
	}
	
	@Override
	public List<MyProduct> searchProduct(Map map) throws Exception {
		return myProductDAO.searchProduct(map);
	}

	@Override
	public void updateProduct(MyProduct product) throws Exception {
		myProductDAO.updateProduct(product);
		
	}

	@Override
	public void deleteProduct(int id) throws Exception {
		myProductDAO.deleteProduct(id);
		
	}

}
