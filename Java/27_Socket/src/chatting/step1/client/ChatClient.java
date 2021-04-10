package chatting.step1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/*
 * Socket 통신에서 클라이언트측 로직을 담고 있는 프로세스
 * 소켓을 생성해서 요청을 하고자하는 서버측으로 연결을 시도
 * 이때 서버측이 가지고 있는 포트와 동일한 포트를 이용해야 연결이 될수있다.
 * ::
 * 스트림 코드
 * 키보드로 읽어들인 데이터를 
 * 서버로 보내는 로직을 작성
 */
public class ChatClient {
	Socket s;
	BufferedReader br;//자체적으로 생성
	PrintWriter pw; //소켓으로 리턴받아서
	
	public void net() {
		try {
			s = new Socket("127.0.0.1", 5500);
			System.out.println("Socket Creating...");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(), true);//true하면 auto flushing 기능
			System.out.println("Stream Creating...");
			
			String line = "";
			while((line = br.readLine())!= null) pw.println(line);
			
		}catch(UnknownHostException e) {
			System.out.println("서버와의 연결에 실패했습니다..");
		}catch(IOException e) {
			
		}
		
	}
	
	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
		chatClient.net();

	}

}
