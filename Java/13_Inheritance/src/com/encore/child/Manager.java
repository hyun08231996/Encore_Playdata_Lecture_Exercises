package com.encore.child;

import com.encore.parent.Employee;
import com.encore.util.MyDate;

/*
 * 부모 클래스 Employee로부터 모든것을 물려받고
 * 자기자신만의 멤버를 추가하는 자식클래스...
 * 
 * 생성자 호출 ---> 객체 생성
 */
public class Manager extends Employee{//Employee에서 기본생성자를 꼭 만들어야 한다.
	//자식만의 멤버를 추가
	private String dept;
	
	/*
	 * 자식생성자... 객체 생성알고리즘
	 * 자식 생성자 { 첫라인에서 무조건 부모 기본생성자 호출이 일어난다}
	 */
	public Manager(String name, MyDate birthDay, double salary, String dept) {//자식이 생성되려할때...
		//무조건 부모 기본생성자 호출...super();
		super(name, birthDay, salary);
		this.dept = dept;
	}
	//Method Overriding
	/*
	 * 상속관계에서만 일어난다.
	 * Step 1 : 부모가 가진 기능을 물려받는다...호출한다
	 * Step 2 : 그걸 자신에 맞게 고쳐쓴다.
	 * 
	 * Overriding의 Rule
	 * 0. 상속관계의 두 클래스 사이에서 일어난다
	 * 1. 메소드 선언부는 모두 일치
	 * 2. 구현부는 반드시 달라야 한다
	 * --> 이름은 같지만 하는일이 달라졌으므로 새로운 메소드가 만들어졌다.
	 * 
	 */

	@Override
	public String toString() {
		return super.toString()+","+dept;
	}
	
}
