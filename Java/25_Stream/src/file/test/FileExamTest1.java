package file.test;

import java.io.File;

/*
 * ����= ���丮���� + �����̸�
 * �ش� Ŭ����������
 * ������ �پ��� ������� ����
 * getParentFile() : File, getParent() : String
 * mkdir(), mkdirs() �Լ��� ����� �ڼ��� �˾ƺ��� ������ �ۼ�.
 */
public class FileExamTest1 {

	public static void main(String[] args) {
		File dir = new File("c:\\filetest");
		File dir2 = new File("c:\\filetest1\\step1\\code");
		File dir3 = new File("c:\\filetest1\\exam\\data.dat");
		System.out.println("������ �����Ǿ�����??");
		
		//dir.mkdir();//directory����� function
		dir.mkdirs();
		dir2.mkdirs();
		dir3.getParentFile().mkdirs();
		//�ӽ��� file name�� directory ������ �ȵǱ� ������, file name�� �����ϰ� directory�� �����.
		
	}

}
