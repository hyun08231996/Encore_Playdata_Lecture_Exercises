package stream.data.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * scores.dat������ ������ readInt()�� �о�鿩��
 * ������ ������ ����ϰ�
 * ��� ������ ������ ���ϴ� ������ �ۼ�...
 * EOFException�� ������ ������ �������� �ʰ�
 * ����������� �������� ������
 * main�޼ҵ� ����ο��� throws�� ������ �� ����.
 * --------------------------------------
 * main�޼ҵ� ����ο��� throws�� ���ܸ� ������
 * main�� ȣ���� ��(JVM)���� ���ܸ� ó���Ҽ� �ִ� ����
 * Compile Exception �迭���� �����ߴ�.
 */
public class DataOutputStreamTest4 {

	public static void main(String[] args) throws IOException{
		int sum = 0;
		int score = 0;
		DataInputStream dis = null;
		//1. ��Ʈ�� ����
		try {
			dis = new DataInputStream(new FileInputStream("src\\scores.dat"));
			System.out.println("Stream Creating...");
			
			while(true) {
				score = dis.readInt();
				System.out.println(score);//������ ������ ���⼭ ��µȴ�..
				sum += score;
			}
		}catch(EOFException e) {
			System.out.println("������: "+sum);
		}finally {
			dis.close();
		}
	}
}
