package sample.test;

import sample.MyStudent;

/*
 */
public class MyStudentTest {

	public static void main(String[] args) {
		MyStudent ms = new MyStudent();
		
		ms.name = "남승현";//ms는 mystudent 클래스에 있는 name 에 남승현이라는 값을 할당한다
		ms.age = 26;
		ms.address = "금호동";
	
		ms.printInfo();//ms는 myStudent에 있는 printInfo를 콜링한다

	}

}
