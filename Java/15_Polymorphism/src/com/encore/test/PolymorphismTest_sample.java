package com.encore.test;

import com.encore.child.Engineer;
import com.encore.child.Manager;
import com.encore.child.Secretary;
import com.encore.parent.Employee;
import com.encore.service.EmployeeService;
import com.encore.util.MyDate;

/*
 * Collection 
 * 1. Homogeneous Collection (동종간의 집합체)
 * 2. Heterogeneous Collection (이기종간의 집합체)
 */
public class PolymorphismTest_sample {

	public static void main(String[] args) {
		//1. 부모타입으로 자식생성..
		Employee e1 = new Manager("Robert", new MyDate(1981,4,2), 33000.0, "IT");
		Employee e2 = new Engineer("Gosling", new MyDate(1978,1,2), 33000.0, "Java", 200);
		Employee e3 = new Secretary("Peter", new MyDate(1988,1,2), 34000.0, "Robert");
		Employee e4 = new Manager("강호동", new MyDate(1981,4,2), 33000.0, "연예부");
		
		//2. 부모타입의 배열에 초기화
		Employee[] emps = {e1, e2, e3, e4};
		
		//3. 서비스 클래스 생성
		EmployeeService service = new EmployeeService();
		
		service.manageEmployee(e4);
		service.manageEmployee(e2);
		
		service.printAllEMployee(emps);
		
	}

}
/*
 * 
 * Polymorphism
 * 
 * 1. Heterogeneous Collection
 * 2. Virtual Method Invocation
 * 3. Object Casting
 * 4. 부모타입으로 동일하게 묶여져 있지만... 각각 실질적으로 생성된 객체타입을 알아내기 위한 키워드
 * 	  if(e instanceof 자식클래스명)
 * 
 */