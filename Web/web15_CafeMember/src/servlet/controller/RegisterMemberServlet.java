package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/RGS")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성..
		/*
		 * 1. 폼값을 받아온다
		 * 2. pvo 객체 생성
		 * 3. dao 리턴받는다
		 * 4. 비지니스 로직 호출
		 * 5. 결과값...바인딩(Attribute 잘 선택)
		 * 6. 네비게이션
		 */
		//1.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//2.
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		//3. 4. (5.생략) 6.
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			
			//request.getRequestDispatcher("AllMember").forward(request, response);
			response.sendRedirect("AllMember?name="+name);//redirect방식으로 페이지 이동...이때 방금 가입한 사람의 이름을 get방식으로 전달
		}catch(SQLException e) {
			
		}
	}

}
