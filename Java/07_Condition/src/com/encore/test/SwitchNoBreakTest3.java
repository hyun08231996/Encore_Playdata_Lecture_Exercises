package com.encore.test;

public class SwitchNoBreakTest3 {

	public static void main(String[] args) {//����...
		/*
		 * 1. ��ü����...�ı��� �޸𸮿� �ø���.
		 * 2. �׸��� �ı��� ȣ���Ѵ� / �޼ҵ� ȣ��...
		 * ��������� �޸𸮿� �ȿö� ���� ����� �� ����.
		 * ����Ϸ��� �޸𸮿� �÷��� �Ѵ�. == ��ü����
		 * 
		 * ���� ��ü �������� �ʰ� �ٷ� ����Ҽ� �ִ� �͵��� �ִ�.
		 * �̹� �޸𸮿� �ö� �ִ�...static�� ������ �͵��� �̸� �ö� �ִ�.
		 */
		int time = (int)(Math.random()*4)+8;//8~11
		System.out.println("[����ð� : "+time+" ��]");
		
		switch(time) {
			case 8:
				System.out.println("����� �غ��մϴ�..");
			case 9:
				System.out.println("ȸ�� ����, ����ȸ��..");
			case 10:
				System.out.println("���� ����..");
			case 11:
				System.out.println("�ܱ�..");
		}

	}

}
