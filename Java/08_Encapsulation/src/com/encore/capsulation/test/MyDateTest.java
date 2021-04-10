package com.encore.capsulation.test;

import java.util.Scanner;

import com.encore.capsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		
		//1. Scanner를 통해서 month, day값을 받는다.
		/*
		 * md.month = 13;//not visible -> 있는데 접근할 수 없다. 
		 * md.day = 33;
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("월과 일을 입력하세요>>>");
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		MyDate md = new MyDate();//setter&getter를 쓸수 있도록 함
		System.out.println(md);
		
		md.setMonth(month);//calling...
		md.setDay(day);//calling...
		
		//if(md.getMonth()!= 0 && md.getDay()!= 0) {// 굳이 이렇게 할 필요없고 MyDate의 setMonth에서 System.exit(0)으로 끝내면 된다.
		System.out.println("오늘은 "+md.getMonth()+"월 "+md.getDay()+"일 입니다");
		//}
		
		
	}
}
