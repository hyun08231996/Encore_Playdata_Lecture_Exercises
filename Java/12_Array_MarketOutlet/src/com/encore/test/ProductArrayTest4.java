package com.encore.test;

import com.encore.service.OutletStoreService;
import com.encore.service.ProductStoreService;
import com.encore.vo.Customer;
import com.encore.vo.Product;
//OutletStoreService�� Hasing�Ǵ� Test Class....
public class ProductArrayTest4 {

	public static void main(String[] args) {
		//service��ü ����...service Ŭ���� ��ɵ��� �޸𸮿� �ø���.
		OutletStoreService service = new OutletStoreService();

		
		Product[] pros1 = {
			new Product("�ȸ�����", 200000, 1, "LG"),
			new Product("��Ʈ��", 80000, 3, "HP"),
			new Product("����Ʈ��", 60000, 5, "SAMSUNG"),
			new Product("�׺�", 90000, 2, "LG")
		};
		
		Product[] pros2 = {
			new Product("�׿�ġ��", 5600, 2, "CJ"),
			new Product("�����", 2000, 3, "���"),
			new Product("�Ŷ��", 2300, 5, "���")
		};
		
		Customer[] customers = new Customer[2];
		customers[0] = new Customer(111, "�̳���", "��赿");
		customers[1] = new Customer(222, "����", "��赿");
		
		customers[0].buyProducts(pros1);
		customers[1].buyProducts(pros2);
		
		////// �Ʒ������ʹ� Service�� ����� ȣ���� ���Դϴ�. //////
		System.out.println("====���� ������ ������ ��ǰ���� �Դϴ�.====");
		Product[] returnPros = service.getProductDetails(customers[1]);
		for(Product p : returnPros) {
			if(p==null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("====���� ������ ������ ��ǰ�� Maker �Դϴ�.====");
		String[] returnMaker = service.getMakerDetails(customers[1]);
		for(String s : returnMaker) {
			if(s==null) continue;
			System.out.println(s);
		}
		
		System.out.println("====��� ������ ���� �Դϴ�.====");
		Customer[] returnCust = service.getAllCustomer(customers);
		for(Customer c : returnCust) {
			if(c==null) continue;
			System.out.println(c.getDetails());
		}
		
		System.out.println("====ã���ô� ������ ssn�� �Է��ϼ���.====");
		System.out.println(service.searchCustomer(customers, 222).getDetails());
		
		System.out.println("====�̳��� ������ �����Ͻ� �ְ� ������ �����Դϴ�.====");
		System.out.println(service.getMostExpensive(customers[0]));
		
		System.out.println("====5õ�� �̻��� ��ǰ�� �Դϴ�.====");
		Product[] returnPros2 = service.getMorePrice(customers, 5000);
		for(Product p : returnPros2) {
			if(p==null) continue;
			System.out.println(p.getDetail());
		}
		
		System.out.println("====��赿�� ����� ���� �Դϴ�.====");
		Customer[] returnCust2 = service.SameAddressCustomer(customers, "��赿");
		for(Customer c : returnCust2) {
			if(c==null) continue;
			System.out.println(c.getName());
		}
	}
}
