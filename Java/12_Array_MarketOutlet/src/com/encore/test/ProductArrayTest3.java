package com.encore.test;

import com.encore.service.ProductStoreService;
import com.encore.vo.Product;

public class ProductArrayTest3 {

	public static void main(String[] args) {
		//service객체 생성...service 클래스 기능들을 메모리에 올린다.
		ProductStoreService service = new ProductStoreService();
		
		Product[] pros = {
			new Product("안마의자", 200000, 1, "LG"),
			new Product("노트북", 80000, 3, "HP"),
			new Product("스마트폰", 60000, 5, "SAMSUNG"),
			new Product("테블릿", 90000, 2, "LG")
		};
		
		System.out.println("=====1. 모든 상품의 메이커를 출력합니다.=====");
		service.printAllProductMaker(pros);
		
		System.out.println("=====2. 모든 상품의 총 구입액을 받아옵니다.=====");
		System.out.println(service.getTotalPrice(pros)+"원");
		
		System.out.println("=====3. 10만원이상의 상품을 받아옵니다.=====");
		Product[] returnPros = service.getMorePrice(pros, 100000);
		for(Product p : returnPros) {
			if(p==null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("=====4. 특정회사 제품을 받아옵니다.=====");
		Product[] returnPros1 = service.getSpecificCompany(pros, "LG");
		for(Product p : returnPros1) {
			if(p==null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("=====5. 구입한 제품들의 평균가를 받아옵니다.=====");
		System.out.println(service.getAveragePrice(pros)+"원");
		
	}
}
