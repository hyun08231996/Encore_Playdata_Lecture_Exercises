package exception.compile.test;
//1. try~catch 
//2. throws
//3. main...
import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading3{
	public void readFile(String fileName) throws FileNotFoundException{//throws 하면 readFile을 호출한 곳으로 날라감
		FileReader fr = new FileReader(fileName);
		System.out.println("1....new FileReader()..fileName...");
		
		System.out.println("2. FileReader Creating....");
	}
}
public class CompileExceptionTest3 {

	public static void main(String[] args) throws FileNotFoundException{//throws 하면 main을 호출한 곳으로 날라감 -> JVM, 이것은 compile계열(원래부터 예외가 있는)에서만 가능
		FileReading3 f = new FileReading3();
		String path = "C:\\encore_nsh\\util\\poem.txt";
		
		f.readFile(path);

		System.out.println("3. 파일을 잘 읽어들였습니다..");

	}

}
