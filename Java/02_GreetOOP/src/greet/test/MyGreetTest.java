package greet.test;

import greet.MyGreet;

/*
 * MyGreet 클래스의 메소드를 동작시키는 실행 클래스...Test 클래스
 */
public class MyGreetTest {

	public static void main(String[] args) {
		//객체를 생성
		/*
		 * 메모리에 mg라는 이름으로 객체가 올라간다
		 * 클래스의 식구들이 올라간다
		 * 2개 올라간다 필드 하나 메소드 하나
		 * 메모리 올리는 이유(객체 생성하는 이유)??
		 * 메모리 올라간 애들만 접근해서 사용할 수 있다.
		 */
		MyGreet mg = new MyGreet();
		mg.sayHello("남승현");//method calling

	}

}
