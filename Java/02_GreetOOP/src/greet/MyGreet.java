package greet;

//
/*
 * MyGreet클래스는 
 * 인삿말을 콘솔창으로 출력하는 기능을 가지고 있는 클래스
 */
public class MyGreet {
	public String message = "안녕하세요";//필드 선언 및 초기화
	
	public void sayHello(String name) {//method worker
		System.out.println(message+", "+name);//메소드 정의 = 선언부 + 구현부
	}
}
