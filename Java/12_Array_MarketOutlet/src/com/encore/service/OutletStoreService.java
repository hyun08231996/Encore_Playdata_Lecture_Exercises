package com.encore.service;
/*
 * 상품을 구입하는 고객,
 * 상점에 입정된 상품정보를 다루는 기능을
 * 모아놓은 서비스 클래스..
 */

import com.encore.vo.Customer;
import com.encore.vo.Product;

public class OutletStoreService {
	//1. 특정 고객이 구입한 상품정보를 리턴하는 기능
	public Product[] getProductDetails(Customer cust) {
		return cust.getProducts();
	}
	
	//2. 특정 고객이 구입한 상품의 maker들만 리턴하는 기능
	public String[] getMakerDetails(Customer cust) {
		String[] temp = new String[cust.getProducts().length];
		Product[] pros = cust.getProducts();
		int cnt = 0;
		for(Product p : pros) temp[cnt++]  = p.getMaker();
		return temp;
	}
	
	//3. Outlet에 있는 모든 고객을 리턴하는 기능
	public Customer[] getAllCustomer(Customer[] cust) {
		Customer[] temp = new Customer[cust.length];
		int idx = 0;
		for(Customer c : cust) {
			temp[idx++] = c;
		}
		return temp;
	}
	
	//4. 모든 고객중에 특정 고객을 검색(찾아내는)하는 기능
	public Customer searchCustomer(Customer[] cust, int ssn) {
		Customer customer = null;
		for(Customer c : cust) {
			if(c.getSsn()==ssn) customer = c;
		}
		return customer;
	}
	
	//5. 특정 고객이 구입한 물건중 최고가에 해당하는 물건의 가격을 리턴하는 기능
	public int getMostExpensive(Customer cust) {
		Product[] pros = cust.getProducts();
		int max = 0;
		for(Product p : pros) {
			if(p.getPrice()>max) max = p.getPrice();
		}
		return max;
	}
	
	//6. 모든 고객이 구입한 물건중 특정가격 이상되는 제품을 리턴하는 기능
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
	
	//7. 동일한 동네에 살고있는 고객들만 리턴하는 기능
	public Customer[] SameAddressCustomer(Customer[] cust, String address) {
		Customer[] temp = new Customer[cust.length];
		int idx = 0;
		for(Customer c : cust) {
			if(c.getAddress().equals(address)) temp[idx++] = c;
		}
		return temp;
	}
}
