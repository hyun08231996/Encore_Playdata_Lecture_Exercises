package exam.test;

class Member{
	//�ʵ� ������ static ������ ����(local level�δ� ����� �� ����)
	static String name = "ȫ�浿";
	static int age = 22;
	
	int count = 1;//�ʵ�
	
	//static block
	public static void getMember() {//static block
		System.out.println("��/��/��/��/ "+ name);//static variable
		//System.out.println("��/��/��/��/ "+ count);
	}
	
	//non-static block
	public void getMember2() {
		System.out.println("��/��/��/��/ "+ name);//static variable
		
	}
}
public class StaticExamTest1 {

	public static void main(String[] args) {
		//static�� ������ ����� �ٷ� �����ؼ� ����Ҽ� �ִ�...class�̸�.static�޼ҵ�
		Member.getMember();
		
		//
		Member m = new Member();
		m.getMember();
		m.getMember2();

	}

}
