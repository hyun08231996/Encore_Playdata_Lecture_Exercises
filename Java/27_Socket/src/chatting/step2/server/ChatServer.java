package chatting.step2.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * Ŭ���̾�Ʈ�� ���� �޼��� �޾Ƽ�
 * �ٽ� �� �޼����� Ŭ���̾�Ʈ���� ������.
 * ::
 * �Է� - - - br(s)
 * ��� - - - pw(s)
 */

public class ChatServer {
	//�ʵ� ����
	ServerSocket server;
	Socket s;
	//Stream..
	BufferedReader br;
	PrintWriter pw;
	
	public void net() {
		try {
			server = new ServerSocket(5500);
			System.out.println("Server Ready...");
			
			s = server.accept();//Client�� Socket�� ��ȯ�ȴ�.
			System.out.println(s.getInetAddress()+"���� �����ϼ̽��ϴ�..");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			System.out.println("Stream Creating...");
			
			String line = "";
			while((line = br.readLine())!=null) pw.println(line);
			
		} catch (Exception e) {
			System.out.println("Client���� ������ ���������ϴ�.");
		} finally {
			try{
				br.close();
				pw.close();
			}catch(IOException e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		ChatServer ccss = new ChatServer();
		ccss.net();

	}

}
