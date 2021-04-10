package stream.data.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ������ �������� ���Ϸ� ����ϴ� �ڵ带 �ۼ�
 * ���࿡ score.dat ���� ������ �������� �ʾƼ� ��µǴ� �����޼����� ����...
 * ����Ʈ �迭 ��Ʈ���� ��µǴ� ������ ������ ���ڱ���� �ƴ�, Binary Data(���� ������)�̱⿡
 * ����������� ���Ƶ� �˼� ���� �������� ������.
 * �׷��� �ᱹ �̸� Ȯ���ϱ����ؼ���
 * score.dat���Ͽ� ��µ� Binary Data�� �ٽ� DataInputStream�� ���ؼ� 
 * �ڹ� �⺻��(int)���� �ڵ���ȯ���Ѽ� �о�鿩�� �Ѵ�.
 */
public class DataOutputStreamTest3 {

	public static void main(String[] args) throws IOException{
		DataInputStream dis = null; 
		
		try {
			dis = new DataInputStream(new FileInputStream("src\\scores.dat"));
			int data = 0;
			while((data = dis.readInt())!=-1) {//������ ���� -1
				System.out.println(data);
			}
		}catch(EOFException e){
			
		}finally {
			dis.close();
		}
		
	}

}
