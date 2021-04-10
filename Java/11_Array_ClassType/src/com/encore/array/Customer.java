package com.encore.array;
/*
 * ���� �������� ������ �ִ� ���� ������ ��� �ִ� Ŭ����
 */
public class Customer {
	//1. �ʵ� ����
	private String name;
	private int ssn;
	
	//�ʵ� �߰�... �������� ������ ������ ���� �ǵ���
	//��� �߰�... �߰��� �ʵ带 setter�� ����...
	//��� �߰�... �߰��� �ʵ带 �޾ƿ��� ���...
	/////////Has a Relation//////////////
	private Account[] accounts;
	
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	/////////////////////////////////////
	
	//2. ������ ���...������ ����
	public Customer(String name, int ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}
	
	//3. �ʵ� ������ �޾ƿ�
	public String getCustomerInfo() {
		return name+","+ssn;
	}
	
	
}
