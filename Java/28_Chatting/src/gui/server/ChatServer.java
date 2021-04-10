package gui.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * �������� Ŭ���̾�Ʈ�� ������ �޾Ƽ�
 * ���ڱ���� �޼����� �ְ� ���� �� �ִ�
 * ������ ������ �ۼ�
 * ::
 * ChatServer - - - Process
 * 		|-----> ServerSocket, ArrayList, Socket
 * 				broadcast()
 * ChatThread - - - Thread
 * 		|-----> Socket, BufferedReader, PrintWriter
 */

public class ChatServer {
	//Process�� �ʵ带 ����
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
				ct.start();//..�۾��� ���������� ����Ǵ� focus!!
			}
		}catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		ChatServer process = new ChatServer();
		process.net();

	}
}
//������ ����� Ŭ���̾�Ʈ�� �޼����� �ְ� �޴� �ϸ� �����ϴ� ������.. �۾�������
class ChatThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ChatServer chatServer;
	
	ChatThread(Socket s, ChatServer chatServer) {
		this.s = s;
		this.chatServer = chatServer;
		
		System.out.println(s.getInetAddress()+"���� �����ϼ̽��ϴ�.");
		chatServer.broadcast(s.getInetAddress()+"���� ä�ù濡 �����̽��ϴ�.");
	}
	
	public void sendMessage(String str) {
		pw.println(str);
	}
	
	public void run() {
		//������ �����尡 �۾��ϴ� ����..
		try{
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			while(true) {
				String line = br.readLine();
				chatServer.broadcast(line);
			}
		} catch(IOException e) {
			//������ �������� ������ �̰����� ...
			System.out.println(s.getInetAddress()+"���� ������ �����̽��ϴ�.");
			chatServer.broadcast(s.getInetAddress()+"���� ä�ù��� �����̽��ϴ�.");
			
			chatServer.list.remove(this);
		} 
	}
}
