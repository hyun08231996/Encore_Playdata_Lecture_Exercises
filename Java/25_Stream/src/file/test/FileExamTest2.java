package file.test;

import java.io.File;
import java.io.IOException;

public class FileExamTest2 {

	public static void main(String[] args) throws IOException{
		String dirName = "c:"+File.separator+"dir2"+File.separator+"mydir";
		File file1 = new File(dirName);
		
		file1.mkdirs();
		File file2 = new File(dirName, "fileTest.dat");
		
		if(file2.createNewFile()) System.out.println("fileTest Creating OK!!");
		
		System.out.println("1. file2 파일이름을 출력 :: "+file2.getName());
		System.out.println("2. file2 파일경로를 출력 :: "+file2.getAbsolutePath());//file name까지 다나옴
		System.out.println("3. file2 파일 getParent() 결과 :: "+file2.getParent());
		//4. 해당 프로그램이 종료될때 디렉토리 안에 있는 파일이 삭제되는 기능을 찾아서 적용!!!api
		file2.deleteOnExit();
	}

}
