package stream.file.test;
/*
 * 파일에 입력된 내용을 읽어서
 * 콘솔창으로 출력하는 로직을 작성
 * ::
 * 스트림
 * 입력 2개 -- FileReader (node), BufferedReader (filter)
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingTest1 {

	public static void main(String[] args) throws IOException {
		//1. 스트림생성 -- 입력 2개(FileReader, BufferedReader)
		//2. while문에서 file의 내용을 읽고 
		//3. 콘솔로 출력하기...
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		try{
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}finally {
			br.close();
		}
	}
}
