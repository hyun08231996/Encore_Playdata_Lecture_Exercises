package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;
import com.encore.util.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		Employee emp = new Employee("James", new MyDate(1982,3,2), 23000.0);
		Manager m = new Manager("Robert", new MyDate(1981,4,2), 33000.0, "IT");
		Engineer eg = new Engineer("Gosling", new MyDate(1978,1,2), 33000.0, "Java", 200);
		Secretary ss = new Secretary("Peter", new MyDate(1988,1,2), 34000.0, "Robert");
		
		//Robert�� �μ��� �ٲ۴�...IT --> Marketing
		m.changeDept("Marketing");
		System.out.println(emp);
		System.out.println(m);
		System.out.println(eg);
		System.out.println(ss);
		//������:
		//1.��������� �ּҰ����� ��µȴ�...�ذ�...MyDate���ٰ� getDate()�� �߰�
		//2.Manager�� dept�� ��µ��� �ʴ´�...�ذ�...Method Overriding
		
		///////////////////Polymorphism//////////////////////////////////////////
		// �θ�Ÿ������ �ڽ��� �����Ѵ�. ���� ����� ����.
		System.out.println("\n=============Polymorphism===================\n");
		Employee e1 = new Manager("Robert1", new MyDate(1981,4,2), 33000.0, "IT1");
		Employee e2 = new Engineer("Gosling1", new MyDate(1978,1,2), 33000.0, "Java1", 200);
		Employee e3 = new Secretary("Peter1", new MyDate(1988,1,2), 34000.0, "Robert1");
		
		
		System.out.println(e1);//1. virtual method
		System.out.println(e2);
		System.out.println(e3);
		
		
		//Manager m1 = (Manager)e1;//2. object casting
		//m1.changeDept("Marketing");
		
		((Manager) e1).changeDept("Marketing");//2. object casting, ���ٷ�
		System.out.println(e1);
				
		//Super�� ȣ���ߴµ�, Employee���� name, birthDay, salary�����ۿ� ���µ� �� sub�� �ִ� �ʵ���� �������?
		/* 1. 
		 * Virtual Method(������ �ڽ��� �޼ҵ�)  Invocation ����
		 * ��Ӱ����� 2���� Ŭ��������
		 * �޼ҵ� �������̵��� ������ �߻��ϴ� ����
		 * 
		 * Compile Time Type �޼ҵ� - �θ��� �޼ҵ尡 ȣ��
		 * Runtime Type �޼ҵ� - �ڽ��� �޼ҵ� ȣ��
		 * 
		 * 2.
		 * Object Casting ��� �ʿ�...
		 * �θ�� ã���� �ȵǰ� �ڽĺ����� ã�ƾ� �Ѵ�... �ڽĸ��� ����̱� ������
		 */
	}

}
