package com.encore.service;
/*
 * ��ǰ�� �����ϴ� ��,
 * ������ ������ ��ǰ������ �ٷ�� �����
 * ��Ƴ��� ���� Ŭ����..
 */

import com.encore.vo.Customer;
import com.encore.vo.Product;

public class OutletStoreService {
	//1. Ư�� ���� ������ ��ǰ������ �����ϴ� ���
	public Product[] getProductDetails(Customer cust) {
		return cust.getProducts();
	}
	
	//2. Ư�� ���� ������ ��ǰ�� maker�鸸 �����ϴ� ���
	public String[] getMakerDetails(Customer cust) {
		String[] temp = new String[cust.getProducts().length];
		Product[] pros = cust.getProducts();
		int cnt = 0;
		for(Product p : pros) temp[cnt++]  = p.getMaker();
		return temp;
	}
	
	//3. Outlet�� �ִ� ��� ���� �����ϴ� ���
	public Customer[] getAllCustomer(Customer[] cust) {
		Customer[] temp = new Customer[cust.length];
		int idx = 0;
		for(Customer c : cust) {
			temp[idx++] = c;
		}
		return temp;
	}
	
	//4. ��� ���߿� Ư�� ���� �˻�(ã�Ƴ���)�ϴ� ���
	public Customer searchCustomer(Customer[] cust, int ssn) {
		Customer customer = null;
		for(Customer c : cust) {
			if(c.getSsn()==ssn) customer = c;
		}
		return customer;
	}
	
	//5. Ư�� ���� ������ ������ �ְ��� �ش��ϴ� ������ ������ �����ϴ� ���
	public int getMostExpensive(Customer cust) {
		Product[] pros = cust.getProducts();
		int max = 0;
		for(Product p : pros) {
			if(p.getPrice()>max) max = p.getPrice();
		}
		return max;
	}
	
	//6. ��� ���� ������ ������ Ư������ �̻�Ǵ� ��ǰ�� �����ϴ� ���
	public Product[] getMorePrice(Customer[] cust, int price) {
		int len = 0;
		for(Customer c : cust) len += c.getProducts().length;
		
		Product[] temp = new Product[len];
		int idx = 0;
		for(Customer c : cust) {
			for(Product p : c.getProducts()) {
				if(p.getPrice()>=price) temp[idx++] = p;
			}
		}
		return temp;
	}
	
	//7. ������ ���׿� ����ִ� ���鸸 �����ϴ� ���
	public Customer[] SameAddressCustomer(Customer[] cust, String address) {
		Customer[] temp = new Customer[cust.length];
		int idx = 0;
		for(Customer c : cust) {
			if(c.getAddress().equals(address)) temp[idx++] = c;
		}
		return temp;
	}
}
