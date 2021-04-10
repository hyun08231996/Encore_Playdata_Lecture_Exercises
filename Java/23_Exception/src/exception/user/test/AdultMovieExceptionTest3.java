package exception.user.test;

import java.util.Scanner;

/*
 * 사용자정의 Exception
 * 1. 예외 클래스를 내가 직접 작성해서 사용
 * 	  class A extends Exception {  }
 * 2. 강력한 제어문으로 사용됨
 * 	  특정한 조건이 형성되면 예외를 고의적으로 생성시켜서 프로그램을 핸들링한다.
 * 
 * -------------------------------------
 * 	  성인영화를 관람하는데
 * 	  나이가 19세가 안되는 사람이 극장에 입장하는 경우
 * 	  입장을 허용하지 않고 / 19세 이상되는 사람만 영화관람을
 * 	  허용할수 있는 로직을 작성..
 * 	  -->
 * 	  UnderAgeException을 정의해서 사용하겠다.
 */
class UnderAgeException extends Exception {
	
	UnderAgeException(){
		this("19세 나이가 안되면  영화 관람 안됩니다.");
	}
	
	UnderAgeException(String message){
		super(message);
	}
}

class AdultMovieService {
	public void entrance(int age) throws UnderAgeException{
		if(age<19) throw new UnderAgeException();
		else System.out.println("Ticketing... Entrance OK!!!");
	}
}

public class AdultMovieExceptionTest3 {

	public static void main(String[] args) {
		System.out.println("나이를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		AdultMovieService service = new AdultMovieService();
		try {
			service.entrance(age);
		}
		catch(UnderAgeException e) {
			System.out.println(e.getMessage());
		}
		
		
		

	}

}
