package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

/*
 * �θ� Ŭ���� Employee�κ��� ������ �����ް�
 * �ڱ��ڽŸ��� ����� �߰��ϴ� �ڽ�Ŭ����...
 * 
 * ������ ȣ�� ---> ��ü ����
 */
public class Manager extends Employee{//Employee���� �⺻�����ڸ� �� ������ �Ѵ�.
	//�ڽĸ��� ����� �߰�
	private String dept;
	
	/*
	 * �ڽĻ�����... ��ü �����˰���
	 * �ڽ� ������ { ù���ο��� ������ �θ� �⺻������ ȣ���� �Ͼ��}
	 */
	public Manager(String name, MyDate birthDay, double salary, String dept) {//�ڽ��� �����Ƿ��Ҷ�...
		//������ �θ� �⺻������ ȣ��...super();
		super(name, birthDay, salary);
		this.dept = dept;
	}
	//Method Overriding
	/*
	 * ��Ӱ��迡���� �Ͼ��.
	 * Step 1 : �θ� ���� ����� �����޴´�...ȣ���Ѵ�
	 * Step 2 : �װ� �ڽſ� �°� ���ľ���.
	 * 
	 * Overriding�� Rule
	 * 0. ��Ӱ����� �� Ŭ���� ���̿��� �Ͼ��
	 * 1. �޼ҵ� ����δ� ��� ��ġ
	 * 2. �����δ� �ݵ�� �޶�� �Ѵ�
	 * --> �̸��� ������ �ϴ����� �޶������Ƿ� ���ο� �޼ҵ尡 ���������.
	 * 
	 */

	@Override
	public String toString() {
		return super.toString()+","+dept;
	}
	
}
