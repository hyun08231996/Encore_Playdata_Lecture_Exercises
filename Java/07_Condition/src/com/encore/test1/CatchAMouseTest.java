package com.encore.test1;

import java.util.Scanner;

/*
 * 제어문을 사용한 알고리즘을 간단하게 다뤄보자..
 */
public class CatchAMouseTest {

	private static String algoSolv(int catA, int catB, int mouseC) {
		//if, else if, else 구문과 Math.abs()를 이용해서 알고리즘을 구현하세요
		if(Math.abs(mouseC-catA)<Math.abs(mouseC-catB)) return "CatA Catch!!";
		else if(Math.abs(mouseC-catA)>Math.abs(mouseC-catB)) return "CatB Catch!!";
		else return "Mouse Escapes!!";
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//순서대로 3개의 값을 입력받는다.
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouseC = sc.nextInt();
		
		String result = algoSolv(catA, catB, mouseC);
		System.out.println("Result :: "+result);
	}


}
