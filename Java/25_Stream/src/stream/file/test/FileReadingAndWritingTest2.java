package stream.file.test;
/*
 * 파일에 입력된 내용을 읽어서
 * 또 다른 으로 출력하는 로직을 작성
 * ::
 * 스트림
 * 입력 2개 -- FileReader (node), BufferedReader (filter)
 * 출력 2개 -- FileWriter (node), BufferedWriter (filter)
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadingAndWritingTest2 {

	public static void main(String[] args) throws IOException {
		//1. 스트림생성 -- 4개 생성
		//2. while문에서 file의 내용을 읽고 
		//3. 또다른 파일로 출력하기 (Sink)...
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src\\hope2.txt"));
		try{
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		//bw.flush();//auto flushing 기능... 데이터를 모아두지 말고 입력될 떄마다 바로 출력한다.
		}finally {
			br.close();
			bw.close();
		}
	}
}
