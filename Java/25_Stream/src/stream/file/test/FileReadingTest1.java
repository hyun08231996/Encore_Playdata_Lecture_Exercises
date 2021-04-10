package stream.file.test;
/*
 * ���Ͽ� �Էµ� ������ �о
 * �ܼ�â���� ����ϴ� ������ �ۼ�
 * ::
 * ��Ʈ��
 * �Է� 2�� -- FileReader (node), BufferedReader (filter)
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingTest1 {

	public static void main(String[] args) throws IOException {
		//1. ��Ʈ������ -- �Է� 2��(FileReader, BufferedReader)
		//2. while������ file�� ������ �а� 
		//3. �ַܼ� ����ϱ�...
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
