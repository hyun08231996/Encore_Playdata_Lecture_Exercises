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
		Engineer eg = new Engineer("Gosling", new MyDate(1978,1,2), 33000.0, "Java");
		Secretary ss = new Secretary("Peter", new MyDate(1988,1,2), 34000.0, "Robert");
		
		System.out.println(emp);
		System.out.println(m);
		System.out.println(eg);
		System.out.println(ss);
		//문제점:
		//1.생년월일이 주소값으로 출력된다...해결...MyDate에다가 getDate()를 추가
		//2.Manager의 dept가 출력되지 않는다...해결...Method Overriding
	}

}
