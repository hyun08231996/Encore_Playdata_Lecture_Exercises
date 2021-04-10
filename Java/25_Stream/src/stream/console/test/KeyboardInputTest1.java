package stream.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 키보드로 읽어들인 데이터를 콘솔로 출력(System.out.println())하는 로직을 작성
 * ::
 * 소스코드 패턴
 * 1. Stream 객체 생성
 * 2. 읽어들인다.
 * 3. 콘솔로 출력한다.
 */
public class KeyboardInputTest1 {

	public static void main(String[] args) {
		//1. 입력 스트림만 필요..2개(기본(node), 보조(filter))
		System.out.println("1. 스트림 생성...");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		//2. 생성한 스트림의 기능을 사용...읽어들인다.
		System.out.println("2. 데이터를 읽어들인다...");
		try {
			String line = br.readLine();
			while(line!=null) {
				//3. 읽어들인 데이터를 콘솔로 출력한다.
				System.out.println("Reading Data :: "+line);
				line = br.readLine();//이 부분이 더 추가되어야 계속 읽어서 출력한다.
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			}catch(IOException e) {
				
			}
		}
		
		
		
	}

}
