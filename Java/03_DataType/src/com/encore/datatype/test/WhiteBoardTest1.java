package com.encore.datatype.test;

import com.encore.datatype.WhiteBoard;

/*
 * WhiteBoardTest1...Test,���� Ŭ������ �θ���.
 * 
 * Test,���� Ŭ������ �Ѵ� ��
 * 1) ��ü�� �����Ѵ� == ��ü�� �������(�ı�)�� �޸𸮿� �ø���.
 * 2) �ı��� ����
 *    �ʵ� --- ���Ҵ� --- �������� �ϵ��ڵ��Ǹ� �װ��� ���α׷��� �ƴϴ�... �ϸ� �ȵ�
 *    �޼ҵ� --- Calling
 */
public class WhiteBoardTest1 {

	public static void main(String[] args) {
		/*
		 * WhiteBoard ��ü�� wb��� �̸����� �ϳ� ����
		 * �ʵ忡 ���� �Է�
		 * �Էµ� ���� ���
		 */
		WhiteBoard wb = new WhiteBoard();
		
		
		wb.setField(90, 'W', 15.0f, "Levis", "leather", false);//float(32), double(64)
		
		wb.printInfo();
		

	}

}
