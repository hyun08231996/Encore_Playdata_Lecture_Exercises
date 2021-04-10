package chatting.step2.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/*
 * 클라이언트가 보낸 메세지 받아서
 * 다시 그 메세지를 클라이언트에게 보낸다.
 * ::
 * 입력 - - - br(s)
 * 출력 - - - pw(s)
 */

public class ChatServer {
	//필드 선언
	ServerSocket server;
	Socket s;
	//Stream..
	BufferedReader br;
	PrintWriter pw;
	
	public void net() {
		try {
			server = new ServerSocket(5500);
			System.out.println("Server Ready...");
			
			s = server.accept();//Client의 Socket이 반환된다.
			System.out.println(s.getInetAddress()+"님이 접속하셨습니다..");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			System.out.println("Stream Creating...");
			
			String line = "";
			while((line = br.readLine())!=null) pw.println(line);
			
		} catch (Exception e) {
			System.out.println("Client와의 연결이 끊어졌습니다.");
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
