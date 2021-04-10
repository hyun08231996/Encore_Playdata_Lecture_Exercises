package chatting.step2.client;
/*
 * 키보드로 데이터를 읽어들여서
 * 서버로 보낸다.
 * ---------------------------
 * 다시 서버가 보낸 메세지를 읽어서
 * 클라이언트 자신의 콘솔창에 메세지를 출력
 * ::
 * 입력 - - - 
 * 출력 - - -
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	//필드 선언
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
				String line = br.readLine();//키보드로 입력받은 데이터 읽어서
				pw.println(line);//서버로 보낸다
				
				/////Blocking//////////////
				
				String serverMsg = br2.readLine();
				System.out.println("서버가 보낸 메세지 "+serverMsg);
			}
		} catch (Exception e) {
			System.out.println("서버와의 연결이 끊어졌습니다..");
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
