package com.encore.capsulation.test;

import java.util.Scanner;

import com.encore.capsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		
		//1. Scanner�� ���ؼ� month, day���� �޴´�.
		/*
		 * md.month = 13;//not visible -> �ִµ� ������ �� ����. 
		 * md.day = 33;
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���� �Է��ϼ���>>>");
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		MyDate md = new MyDate();//setter&getter�� ���� �ֵ��� ��
		System.out.println(md);
		
		md.setMonth(month);//calling...
		md.setDay(day);//calling...
		
		//if(md.getMonth()!= 0 && md.getDay()!= 0) {// ���� �̷��� �� �ʿ���� MyDate�� setMonth���� System.exit(0)���� ������ �ȴ�.
		System.out.println("������ "+md.getMonth()+"�� "+md.getDay()+"�� �Դϴ�");
		//}
		
		
	}
}
