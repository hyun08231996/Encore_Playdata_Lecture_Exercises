package com.encore.test1;

import java.util.Scanner;

/*
 * ����� ����� �˰����� �����ϰ� �ٷﺸ��..
 */
public class CatchAMouseTest {

	private static String algoSolv(int catA, int catB, int mouseC) {
		//if, else if, else ������ Math.abs()�� �̿��ؼ� �˰����� �����ϼ���
		if(Math.abs(mouseC-catA)<Math.abs(mouseC-catB)) return "CatA Catch!!";
		else if(Math.abs(mouseC-catA)>Math.abs(mouseC-catB)) return "CatB Catch!!";
		else return "Mouse Escapes!!";
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//������� 3���� ���� �Է¹޴´�.
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouseC = sc.nextInt();
		
		String result = algoSolv(catA, catB, mouseC);
		System.out.println("Result :: "+result);
	}


}
