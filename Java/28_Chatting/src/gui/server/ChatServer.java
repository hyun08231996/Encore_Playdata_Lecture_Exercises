package gui.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * 여러명의 클라이언트의 접속을 받아서
 * 문자기반의 메세지를 주고 받을 수 있는
 * 서버측 로직을 작성
 * ::
 * ChatServer - - - Process
 * 		|-----> ServerSocket, ArrayList, Socket
 * 				broadcast()
 * ChatThread - - - Thread
 * 		|-----> Socket, BufferedReader, PrintWriter
 */

public class ChatServer {
	//Process의 필드를 지정
	ServerSocket server;
	Socket s;
	ArrayList<ChatThread> list;
	
	public ChatServer() {
		list  = new ArrayList<ChatThread>();
	}
	
	public void broadcast(String message) {
		for(ChatThread t : list) {
			t.sendMessage(message);
		}
	}
	
	public void net() {
		try {
			server = new ServerSocket(60000);
			System.out.println("Server Ready.....");
			
			while(true) {//waiting for...
				s = server.accept();
				ChatThread ct = new ChatThread(s, this);
				list.add(ct);
				ct.start();//..작업이 병렬적으로 진행되는 focus!!
			}
		}catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		ChatServer process = new ChatServer();
		process.net();

	}
}
//서버와 연결된 클라이언트와 메세지를 주고 받는 일만 전담하는 쓰레드.. 작업쓰레드
class ChatThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ChatServer chatServer;
	
	ChatThread(Socket s, ChatServer chatServer) {
		this.s = s;
		this.chatServer = chatServer;
		
		System.out.println(s.getInetAddress()+"님이 접속하셨습니다.");
		chatServer.broadcast(s.getInetAddress()+"님이 채팅방에 들어오셨습니다.");
	}
	
	public void sendMessage(String str) {
		pw.println(str);
	}
	
	public void run() {
		//실제로 쓰레드가 작업하는 내용..
		try{
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			while(true) {
				String line = br.readLine();
				chatServer.broadcast(line);
			}
		} catch(IOException e) {
			//연결이 끊어지면 로직이 이곳으로 ...
			System.out.println(s.getInetAddress()+"님이 접속을 끊으셨습니다.");
			chatServer.broadcast(s.getInetAddress()+"님이 채팅방을 나가셨습니다.");
			
			chatServer.list.remove(this);
		} 
	}
}
