package com.encore.test1;

import java.util.Scanner;

/*
 * kim's  ---- 4를 입력 받는다
 * 1-2-3-4
 * 
 * lim's --- 8을 입력
 * 1-2-3-4-5-6-7-8
 * 
 */
public class HalfDistanceTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		System.out.println("kim's거리 입력>>>"); 
		int kims = sc.nextInt(); 
		System.out.println("lim's거리 입력>>>"); 
		int lims = sc.nextInt();
		  
		int result = halfDistance(kims, lims); 
		
		System.out.println(result);
		 
		

	}

	private static int halfDistance(int kims, int lims) {
		//직접 구현해보기
		int i = 0;
		while(kims!=lims) {
			kims /= 2;
			lims /= 2;
			i++;
		}
		return i;
	}

}
