package com.encore.test;

import com.encore.service.OutletStoreService;
import com.encore.service.ProductStoreService;
import com.encore.vo.Customer;
import com.encore.vo.Product;
//OutletStoreService와 Hasing되는 Test Class....
public class ProductArrayTest4 {

	public static void main(String[] args) {
		//service객체 생성...service 클래스 기능들을 메모리에 올린다.
		OutletStoreService service = new OutletStoreService();

		
		Product[] pros1 = {
			new Product("안마의자", 200000, 1, "LG"),
			new Product("노트북", 80000, 3, "HP"),
			new Product("스마트폰", 60000, 5, "SAMSUNG"),
			new Product("테블릿", 90000, 2, "LG")
		};
		
		Product[] pros2 = {
			new Product("죽염치약", 5600, 2, "CJ"),
			new Product("새우깡", 2000, 3, "농심"),
			new Product("신라면", 2300, 5, "농심")
		};
		
		Customer[] customers = new Customer[2];
		customers[0] = new Customer(111, "이나영", "방배동");
		customers[1] = new Customer(222, "원빈", "방배동");
		
		customers[0].buyProducts(pros1);
		customers[1].buyProducts(pros2);
		
		////// 아래서부터는 Service의 기능을 호출할 것입니다. //////
		System.out.println("====원빈 고객님이 구입한 상품정보 입니다.====");
		Product[] returnPros = service.getProductDetails(customers[1]);
		for(Product p : returnPros) {
			if(p==null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("====원빈 고객님이 구입한 상품의 Maker 입니다.====");
		String[] returnMaker = service.getMakerDetails(customers[1]);
		for(String s : returnMaker) {
			if(s==null) continue;
			System.out.println(s);
		}
		
		System.out.println("====모든 고객님의 정보 입니다.====");
		Customer[] returnCust = service.getAllCustomer(customers);
		for(Customer c : returnCust) {
			if(c==null) continue;
			System.out.println(c.getDetails());
		}
		
		System.out.println("====찾으시는 고객님의 ssn을 입력하세요.====");
		System.out.println(service.searchCustomer(customers, 222).getDetails());
		
		System.out.println("====이나영 고객님이 구매하신 최고가 물건의 가격입니다.====");
		System.out.println(service.getMostExpensive(customers[0]));
		
		System.out.println("====5천원 이상의 제품들 입니다.====");
		Product[] returnPros2 = service.getMorePrice(customers, 5000);
		for(Product p : returnPros2) {
			if(p==null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("====방배동에 살고계신 고객님 입니다.====");
		Customer[] returnCust2 = service.SameAddressCustomer(customers, "방배동");
		for(Customer c : returnCust2) {
			if(c==null) continue;
			System.out.println(c.getName());
		}
	}
}
