package com.encore.spring.model;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.encore.spring.domain.MyProduct;

//Transaction 처리는 1)설정문서 2)인터페이스 3)~Impl 클래스 4) 처리하고자 하는 메소드에다 지정하면 된다.

@Transactional
public interface MyProductService {
	void addProduct(MyProduct product) throws Exception;
	MyProduct getProduct(int id) throws Exception;
	List<MyProduct> getProductsByName(String name) throws Exception;
	List<MyProduct> getProductsByMaker(String maker) throws Exception;
	List<MyProduct> getProductList() throws Exception;
	List<MyProduct> searchProduct(Map map) throws Exception;
	void updateProduct(MyProduct product) throws Exception;
	void deleteProduct(int id) throws Exception;
}
