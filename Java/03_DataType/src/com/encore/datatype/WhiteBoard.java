package com.encore.datatype;

/*
 * 1. �ʵ�
 * 	  int ������, char �÷�, float ����, String ����ȸ��, String ����
 * 	  ��ũ��ġ ���θ� �˼� �ִ� �ʵ带 �߰�
 * 
 * 2. �޼ҵ�
 * 	  2�� ����
 * 	  - ���� Test Ŭ�������� �޾Ƽ� �ʵ忡 �Է��ϴ� ���
 * 	  - �ʵ忡 �Էµ�, ����� ���� �ܼ�â���� ����ϴ� ���
 * 	  -----------------------------------------
 * 	  1.
 * 	  ����(Variable)�� ���Ǵ� ��ġ�� ���� Field�� Local variable�� ���еȴ�
 * 	  �ʵ� --> Ŭ���� ���� �ٷ� ��, �޼ҵ� ��� �ٱ�
 * 	  Local variable(��������) --> �޼ҵ� �ȿ��� ����
 * 
 * 	  2.
 * 	  ���ú����� �̸��� �ʵ�� �����ϰ� ���������� �ۼ��Ѵ�.
 * 	  �̸��� �����Ҷ��� �ʵ� �տ� this�� ���̸� �ȴ�.
 */
public class WhiteBoard {
	//field
	public int size;
	public char color;
	public float price;
	public String company;
	public String material;
	public boolean scratch;
	
	public void setField(int size, char color, float price, String company, String material, boolean scratch){//local variable
		//�ʵ�� ���ú����� �̸��� ������, �����ϱ� ���ؼ� �ʵ�տ� this�� ���δ�.
		//this�� �ش� Ŭ���� �ڱ��ڽ�...������ �ϴ� �ؼ�...
		this.size = size;
		this.color = color;
		this.price = price;
		this.company = company;
		this.material = material;
		this.scratch = scratch;
	}
	
	public void printInfo() {
		System.out.println(size+"\t"+color+"\t"+price+"\t"+company+"\t"+material+"\t"+scratch);//backward slash�ϸ� ������ �������� �����̽�
	}
	
	
}
