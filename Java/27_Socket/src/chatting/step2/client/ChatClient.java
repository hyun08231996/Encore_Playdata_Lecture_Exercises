package chatting.step2.client;
/*
 * Ű����� �����͸� �о�鿩��
 * ������ ������.
 * ---------------------------
 * �ٽ� ������ ���� �޼����� �о
 * Ŭ���̾�Ʈ �ڽ��� �ܼ�â�� �޼����� ���
 * ::
 * �Է� - - - 
 * ��� - - -
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	//�ʵ� ����
	Socket s;
	
	//Stream..
	BufferedReader br,br2;
	PrintWriter pw;

	
	
	public void net() {
		try {
			s = new Socket("127.0.0.1", 5500);
			System.out.println("Socket Creating...");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(), true);
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			System.out.println("Client Stream Creating...");
			while(true) {
				String line = br.readLine();//Ű����� �Է¹��� ������ �о
				pw.println(line);//������ ������
				
				/////Blocking//////////////
				
				String serverMsg = br2.readLine();
				System.out.println("������ ���� �޼��� "+serverMsg);
			}
		} catch (Exception e) {
			System.out.println("�������� ������ ���������ϴ�..");
		} finally {
			try {
				br.close();
				pw.close();
				br2.close();
			}catch(IOException e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		ChatClient cc = new ChatClient();
		cc.net();

	}

}
