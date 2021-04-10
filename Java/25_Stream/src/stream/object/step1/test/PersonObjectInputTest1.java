package stream.object.step1.test;
import java.io.File;
import java.io.FileInputStream;
/*
 * ������ȭ �ڵ�
 * ������ person.obj������ ������ �о�ͼ�
 * �ַܼ� ������ ���
 */
import java.io.IOException;
import java.io.ObjectInputStream;

public class PersonObjectInputTest1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File f = new File("c:"+File.separator+"objfile"+File.separator+"person.obj");
		//1.
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		System.out.println("ObjectInputStream...Creating...");
		
		//2.
		Person p = (Person)ois.readObject();
		System.out.println(p);
	}
}
	
