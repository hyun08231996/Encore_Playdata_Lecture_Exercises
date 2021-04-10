package com.encore.test1;

import java.util.Scanner;

/*
 * Scanner��ü�� ���ؼ�
 * 10~99 ������ ������ �ϳ� �Է¹޴´�. (2�ڸ����� ����)
 * 
 * 3,6,9... �� 3�� ������� ���ԵǾ��� �ִ����� �������� �����ϴ� �˰���
 * �ϳ� ������ --> @
 * �ΰ� ������ --> @@
 * ������ --> ����
 * ���� ��
 * 31 --> @ 
 * 11 --> 11
 * 98 --> @
 * 29 --> @
 * 96 --> @@
 * 
 * ��Ʈ
 * 2�ڸ���...
 * ���ڸ� ---> /
 * ���ڸ� ---> %
 * 
 * ��� �����ϱ�
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
