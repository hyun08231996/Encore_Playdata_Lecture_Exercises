package com.encore.array.test;

import com.encore.array.Account;

public class AccountArrayTest1 {

	public static void main(String[] args) {
		//1. Account Type�� �迭�� ����...������� 3
		
		//2. ������ ĭ�� ����, ����, �츮���� ������ ����
		
		//3. For���� ����ؼ� ������ Account������ �ַܼ� ����Ѵ�.
		
		Account[] acc = new Account[3];
		
		acc[0] = new Account(10000.0, "��������");
		acc[1] = new Account(30000.0, "��������");
		acc[2] = new Account(50000.0, "�츮����");
		
		for(int i=0; i<acc.length; i++) {
			System.out.println(acc[i]);//�ּҰ�
			System.out.println(acc[i].getDetail());
		}
		

	}

}
