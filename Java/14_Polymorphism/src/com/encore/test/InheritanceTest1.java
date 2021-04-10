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
		
		//Robert가 부서를 바꾼다...IT --> Marketing
		m.changeDept("Marketing");
		System.out.println(emp);
		System.out.println(m);
		System.out.println(eg);
		System.out.println(ss);
		//문제점:
		//1.생년월일이 주소값으로 출력된다...해결...MyDate에다가 getDate()를 추가
		//2.Manager의 dept가 출력되지 않는다...해결...Method Overriding
		
		///////////////////Polymorphism//////////////////////////////////////////
		// 부모타입으로 자식을 생성한다. 위와 결과는 같다.
		System.out.println("\n=============Polymorphism===================\n");
		Employee e1 = new Manager("Robert1", new MyDate(1981,4,2), 33000.0, "IT1");
		Employee e2 = new Engineer("Gosling1", new MyDate(1978,1,2), 33000.0, "Java1", 200);
		Employee e3 = new Secretary("Peter1", new MyDate(1988,1,2), 34000.0, "Robert1");
		
		
		System.out.println(e1);//1. virtual method
		System.out.println(e2);
		System.out.println(e3);
		
		
		//Manager m1 = (Manager)e1;//2. object casting
		//m1.changeDept("Marketing");
		
		((Manager) e1).changeDept("Marketing");//2. object casting, 한줄로
		System.out.println(e1);
				
		//Super로 호출했는데, Employee에는 name, birthDay, salary까지밖에 없는데 왜 sub에 있는 필드까지 출력됬을까?
		/* 1. 
		 * Virtual Method(생성된 자식의 메소드)  Invocation 원리
		 * 상속관계의 2개의 클래스에서
		 * 메소드 오버라이딩을 했을떄 발생하는 원리
		 * 
		 * Compile Time Type 메소드 - 부모의 메소드가 호출
		 * Runtime Type 메소드 - 자식의 메소드 호출
		 * 
		 * 2.
		 * Object Casting 기법 필요...
		 * 부모로 찾으면 안되고 자식변수로 찾아야 한다... 자식만의 기능이기 때문에
		 */
	}

}
