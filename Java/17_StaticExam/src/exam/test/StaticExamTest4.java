package exam.test;
/*
 * Static도 Modifier이다
 * Modifier ---> Access modifier | Usage Modifier
 * Usage Modifier :: static, final, abstract
 * static + final 주로 함께 많이 쓰인다.
 * 
 * final :: "내가 마지막이야" 를 의미하는 키워드
 * final + 변수  --> "내가 마지막 변수야" --> 상수지정
 * final + 클래스 --> "내가 마지막 클래스야" --> 상속을 금지시킨다
 * final + 메소드 --> "내가 마지막 메소드야" --> overriding을 금지시킨다
 */

class A{
	public final static int BASE_SALARY = 300;
	public final String test() {
		return "Overriding 금지";
	}
}
final class B{ //상속 금지..
	
}
//final class C extends B{
//	
//}
class D extends A{
//	public final String test() {
//		return "Overriding 금지";
//	}
}

public class StaticExamTest4 {

	public static void main(String[] args) {
		

	}

}
