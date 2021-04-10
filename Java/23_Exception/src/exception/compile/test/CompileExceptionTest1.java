package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	public void readFile(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			System.out.println("1....new FileReader()..fileName...");
		}catch(FileNotFoundException e) {
			//System.out.println("Nice Catch");//이 부분은 안 만난다...
			//1. 비워두거나
			//2. printStackTrace(), getMessage()
			//e.printStackTrace();
			//System.out.println(e.getMessage());
		}
		System.out.println("2. FileReader Creating....");
	}
}
public class CompileExceptionTest1 {

	public static void main(String[] args) {
		FileReading f = new FileReading();
		String path = "C:\\encore_nsh\\util\\poem.txt";
		f.readFile(path);
		System.out.println("3. 파일을 잘 읽어들였습니다..");

	}

}
