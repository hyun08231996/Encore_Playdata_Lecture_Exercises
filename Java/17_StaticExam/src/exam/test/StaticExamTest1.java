package exam.test;

class Member{
	//필드 레벨에 static 변수를 선언(local level로는 사용할 수 없다)
	static String name = "홍길동";
	static int age = 22;
	
	int count = 1;//필드
	
	//static block
	public static void getMember() {//static block
		System.out.println("우/유/빛/깔/ "+ name);//static variable
		//System.out.println("우/유/빛/깔/ "+ count);
	}
	
	//non-static block
	public void getMember2() {
		System.out.println("우/유/빛/깔/ "+ name);//static variable
		
	}
}
public class StaticExamTest1 {

	public static void main(String[] args) {
		//static한 성질의 기능은 바로 접근해서 사용할수 있다...class이름.static메소드
		Member.getMember();
		
		//
		Member m = new Member();
		m.getMember();
		m.getMember2();

	}

}
