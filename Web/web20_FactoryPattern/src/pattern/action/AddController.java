package pattern.action;

public class AddController implements Controller {

	@Override
	public String requestHandle() {
		System.out.println("AddController...register logic...");
		/*
		 * 1. 폼값 받아서
		 * 2. VO 객체 생성
		 * 3. DAO 리터 받아서
		 * 4. 비지니스 로직 호출
		 * 5. 바인딩
		 * 6. Path를 리턴
		 */
		return "add_result.jsp";
	}

}
