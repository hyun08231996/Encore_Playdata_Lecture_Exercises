package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.command 값 받아서
		//2. 공장한테 command값 준다....Controller타입을 반환
		//3. Controller의 메소드를 호출...Component의 메소드가 가동...path를 리턴
		//4. path를 가지고 페이지 이동
		
//		String command = request.getParameter("command");
		//hidden값으로 들어온 요청을 받지 않고...들어온 요청의 전체 주소를 직접 받아온다...앞부분만 자른다.
		String requestURI = request.getRequestURI(); //web22_FactoryPattern/find.do
		System.out.println("RequestURI :: "+requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("ContextPath :: "+contextPath);//web22_FactoryPattern
		
		String command = requestURI.substring(contextPath.length()+1);
		System.out.println("Command :: "+command);
		
		String path = "index.jsp";
		ModelAndView mv = null;
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			mv = controller.execute(request, response);
			path = mv.getPath();//추가..
		}catch(Exception e) {
			
		}
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(path);
			else request.getRequestDispatcher(path).forward(request, response);
		}
	}

}
