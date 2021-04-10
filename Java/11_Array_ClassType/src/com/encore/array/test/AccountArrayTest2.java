package com.encore.array.test;

import com.encore.array.Account;
import com.encore.array.Customer;

public class AccountArrayTest2 {

	public static void main(String[] args) {
		//Account Type의 배열 선언, 생성, 초기화
		Account[] acc = {
				new Account(1000.0, "신한은행"),
				new Account(30000.0, "국민은행"),
				new Account(40000.0, "우리은행")
		};
		
		//1. Customer 객체를 생성
		Customer cust = new Customer("James", 1234567);
		
		//2. James라는 고객이 통장 3개를 Hasing 하도록 한다.
		cust.setAccounts(acc);
		
		//3. James가 개설한 통장들을 받아온다.
		Account[] returnAcc = cust.getAccounts();
		
		//4. James의 통장들 중에서 신한은행 통장에만 50000만원을 입금한다.
		for(Account a : returnAcc) {
			if(a.getBankName().equals("신한은행")) a.deposit(50000.0);
		}
		
		//5. 각 통장들의 잔고를 확인한다.
		System.out.println("=========통장의 잔고를 확인합니다.==========");
		for(Account account : returnAcc) {
			System.out.println(account.getDetail());
		}
		
		//필요한 기능이 있다면 알아서 추가

	}

}
