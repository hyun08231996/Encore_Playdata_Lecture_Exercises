package sample.test;

import sample.MyStudent;

/*
 */
public class MyStudentTest {

	public static void main(String[] args) {
		MyStudent ms = new MyStudent();
		
		ms.name = "������";//ms�� mystudent Ŭ������ �ִ� name �� �������̶�� ���� �Ҵ��Ѵ�
		ms.age = 26;
		ms.address = "��ȣ��";
	
		ms.printInfo();//ms�� myStudent�� �ִ� printInfo�� �ݸ��Ѵ�

	}

}
