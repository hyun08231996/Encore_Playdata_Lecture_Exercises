package com.encore.test1;

import java.util.Scanner;

/*
 * Scanner객체를 통해서
 * 10~99 사이의 정수를 하나 입력받는다. (2자리수의 숫자)
 * 
 * 3,6,9... 즉 3의 배수값이 포함되어져 있는지를 패턴으로 적용하는 알고리즘
 * 하나 있으면 --> @
 * 두개 있으면 --> @@
 * 없으면 --> 숫자
 * 예를 들어서
 * 31 --> @ 
 * 11 --> 11
 * 98 --> @
 * 29 --> @
 * 96 --> @@
 * 
 * 힌트
 * 2자리수...
 * 앞자리 ---> /
 * 끝자리 ---> %
 * 
 * 제어문 연습하기
 */
public class Pattern369Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
	
		while(true) {
			System.out.println("Enter a number 10~99>>>");
			int num = sc.nextInt();
			int d1 = num / 10;
			int d2 = num % 10;
			
			if(num >= 10 && num <= 99) {
				if((d1==3 || d1==6 || d1==9)&&(d2==3 || d2==6 || d2==9)) System.out.println("@@");
				else if((d1==3 || d1==6 || d1==9)||(d2==3 || d2==6 || d2==9)) System.out.println("@");
				else System.out.println(num);
			}
			else System.out.println("Error...");
			
			System.out.println("Play again? 1=Yes/0=No");
			int again = sc.nextInt();
			if(again!=1) break;
		}
		System.out.println("Thank you for playing...");
	}
}
