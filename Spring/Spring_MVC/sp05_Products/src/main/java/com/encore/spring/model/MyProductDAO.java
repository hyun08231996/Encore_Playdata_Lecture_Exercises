package com.encore.spring.model;

import java.util.List;
import java.util.Map;

import com.encore.spring.domain.MyProduct;

public interface MyProductDAO {
	void addProduct(MyProduct product) throws Exception;
	MyProduct getProduct(int id) throws Exception;
	List<MyProduct> getProductsByName(String name) throws Exception;
	List<MyProduct> getProductsByMaker(String maker) throws Exception;
	List<MyProduct> getProductList() throws Exception;
	List<MyProduct> searchProduct(Map map) throws Exception;
	void updateProduct(MyProduct product) throws Exception;
	void deleteProduct(int id) throws Exception;
}
