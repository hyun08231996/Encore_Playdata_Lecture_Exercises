package com.encore.test;

import com.encore.service.ProductStoreService;
import com.encore.vo.Product;

public class ProductArrayTest3 {

	public static void main(String[] args) {
		//service��ü ����...service Ŭ���� ��ɵ��� �޸𸮿� �ø���.
		ProductStoreService service = new ProductStoreService();
		
		Product[] pros = {
			new Product("�ȸ�����", 200000, 1, "LG"),
			new Product("��Ʈ��", 80000, 3, "HP"),
			new Product("����Ʈ��", 60000, 5, "SAMSUNG"),
			new Product("�׺�", 90000, 2, "LG")
		};
		
		System.out.println("=====1. ��� ��ǰ�� ����Ŀ�� ����մϴ�.=====");
		service.printAllProductMaker(pros);
		
		System.out.println("=====2. ��� ��ǰ�� �� ���Ծ��� �޾ƿɴϴ�.=====");
		System.out.println(service.getTotalPrice(pros)+"��");
		
		System.out.println("=====3. 10�����̻��� ��ǰ�� �޾ƿɴϴ�.=====");
		Product[] returnPros = service.getMorePrice(pros, 100000);
		for(Product p : returnPros) {
			if(p==null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("=====4. Ư��ȸ�� ��ǰ�� �޾ƿɴϴ�.=====");
		Product[] returnPros1 = service.getSpecificCompany(pros, "LG");
		for(Product p : returnPros1) {
			if(p==null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("=====5. ������ ��ǰ���� ��հ��� �޾ƿɴϴ�.=====");
		System.out.println(service.getAveragePrice(pros)+"��");
		
	}
}
