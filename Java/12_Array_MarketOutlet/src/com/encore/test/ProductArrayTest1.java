package com.encore.test;

import com.encore.vo.Product;

public class ProductArrayTest1 {

	public static void main(String[] args) {
		//1. Product Type�� �迭�� 3�� ����
		//2. Product�� 3�� ����
		//1,2,�� �ѹ��� �ϱ�
		
		//3. for���� �̿��ؼ� Product ������ ���
		
		Product[] pros = {
				new Product("�ȸ�����", 80000, 2, "LG"),
				new Product("��Ʈ��", 50000, 3, "HP"),
				new Product("����Ʈ��", 40000, 5, "SAMSUNG"),
				new Product("�׺�", 200000, 1, "LG")
		};
		
		for(Product p : pros) System.out.println(p.getDetail());
	}
}
