package stream.data.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 간단한 성적들을 파일로 출력하는 코드를 작성
 * 만약에 score.dat 파일 형식이 지원되지 않아서 출력되는 에러메세지는 무시...
 * 바이트 계열 스트림은 출력되는 데이터 형식이 문자기반이 아닌, Binary Data(이진 데이터)이기에
 * 문서편집기로 보아도 알수 없는 형식으로 열린다.
 * 그래서 결국 이를 확인하기위해서는
 * score.dat파일에 출력된 Binary Data를 다시 DataInputStream을 통해서 
 * 자바 기본형(int)으로 자동변환시켜서 읽어들여야 한다.
 */
public class DataOutputStreamTest3 {

	public static void main(String[] args) throws IOException{
		DataInputStream dis = null; 
		
		try {
			dis = new DataInputStream(new FileInputStream("src\\scores.dat"));
			int data = 0;
			while((data = dis.readInt())!=-1) {//파일의 끝이 -1
				System.out.println(data);
			}
		}catch(EOFException e){
			
		}finally {
			dis.close();
		}
		
	}

}
