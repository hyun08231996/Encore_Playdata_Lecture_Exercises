package stream.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1. 스트림 객체를 생성... 입력, 출력
 * 2. while문 안에서 계속 읽어들이고 
 * 3. 읽은 데이터를 출력
 * ::
 * 키보드로 입력한 데이터를
 * 콘솔로 출력하는 로직을 작성
 * ::
 * 입력 -- 2개 - InputStreamReader, BufferedReader
 * 출력 -- X - System.out.println()
 */
public class KeyboardInputTest2 {

	public static void main(String[] args) throws IOException{
		//1.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("InputStream Creating...키보드로 데이터 입력..\n");
		
		String line = null;
		try {
			while((line = br.readLine())!=null) {//2.
				if(line.equals("exit")) {
					System.out.println("시스템을 종료합니다...입력금지");
					break;
				}
				System.out.println("Reading Data :: "+line);//3.
			}
		}finally {
			br.close();
		}
	}

}
