package stream.object.step2.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserInfoObjectOutputTest2 {

	public static void main(String[] args) throws Exception{
		String fileName = "src\\userInfo.ser";
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		UserInfo user1 = new UserInfo("강호동", 48, "java123");
		UserInfo user2 = new UserInfo();
		UserInfo user3 = new UserInfo("이수근", 45, "lee444");
		
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		list.add(user1); list.add(user2); list.add(user3);
		
		//직렬화
		oos.writeObject(user1);
		oos.writeObject(user2);
		oos.writeObject(user3);
		oos.writeObject(list);
		
		oos.close();
		System.out.println("직렬화 작업을 끝냈습니다...");
	}
}
