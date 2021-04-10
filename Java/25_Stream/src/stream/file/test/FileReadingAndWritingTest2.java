package stream.file.test;
/*
 * ���Ͽ� �Էµ� ������ �о
 * �� �ٸ� ���� ����ϴ� ������ �ۼ�
 * ::
 * ��Ʈ��
 * �Է� 2�� -- FileReader (node), BufferedReader (filter)
 * ��� 2�� -- FileWriter (node), BufferedWriter (filter)
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadingAndWritingTest2 {

	public static void main(String[] args) throws IOException {
		//1. ��Ʈ������ -- 4�� ����
		//2. while������ file�� ������ �а� 
		//3. �Ǵٸ� ���Ϸ� ����ϱ� (Sink)...
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src\\hope2.txt"));
		try{
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		//bw.flush();//auto flushing ���... �����͸� ��Ƶ��� ���� �Էµ� ������ �ٷ� ����Ѵ�.
		}finally {
			br.close();
			bw.close();
		}
	}
}
