package com.encore.test;

import com.encore.vo.Product;
//기능을 추가해 보기..
public class ProductArrayTest2 {

	public static void main(String[] args) {
		
		Product[] pros = {
			new Product("안마의자", 80000, 2, "LG"),
			new Product("노트북", 50000, 3, "HP"),
			new Product("스마트폰", 40000, 5, "SAMSUNG"),
			new Product("테블릿", 200000, 1, "LG")
		};
		//1. 상품들의 메이커를 출력합니다..
		System.out.println("====상품들의 메이커를 출력합니다====");
		for(Product p : pros) System.out.println(p.getMaker());
		
		//2. 특정가격 이상의 제품만 출력
		System.out.println("====10만원 이상하는 제품들을 출력합니다====");
		for(Product p : pros) {
			if(p.getPrice() >= 100000) System.out.println(p.getDetail());
		}
		
		//3. 구매한 물건들의 총가격
		System.out.println("====총구입 가격을 출력합니다====");
		int total = 0;
		for(Product p : pros) total += p.getPrice() * p.getQuantity();
		System.out.println(total);
	}
}
