package com.encore.test;

import com.encore.vo.Product;

public class ProductArrayTest1 {

	public static void main(String[] args) {
		//1. Product Type의 배열을 3개 생성
		//2. Product를 3개 생성
		//1,2,를 한번에 하기
		
		//3. for문을 이용해서 Product 정보를 출력
		
		Product[] pros = {
				new Product("안마의자", 80000, 2, "LG"),
				new Product("노트북", 50000, 3, "HP"),
				new Product("스마트폰", 40000, 5, "SAMSUNG"),
				new Product("테블릿", 200000, 1, "LG")
		};
		
		for(Product p : pros) System.out.println(p.getDetail());
	}
}
