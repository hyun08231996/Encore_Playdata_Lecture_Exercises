package exception.compile.test;
//1. try~catch 
//2. throws
//3. main...
import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading3{
	public void readFile(String fileName) throws FileNotFoundException{//throws �ϸ� readFile�� ȣ���� ������ ����
		FileReader fr = new FileReader(fileName);
		System.out.println("1....new FileReader()..fileName...");
		
		System.out.println("2. FileReader Creating....");
	}
}
public class CompileExceptionTest3 {

	public static void main(String[] args) throws FileNotFoundException{//throws �ϸ� main�� ȣ���� ������ ���� -> JVM, �̰��� compile�迭(�������� ���ܰ� �ִ�)������ ����
		FileReading3 f = new FileReading3();
		String path = "C:\\encore_nsh\\util\\poem.txt";
		
		f.readFile(path);

		System.out.println("3. ������ �� �о�鿴���ϴ�..");

	}

}
