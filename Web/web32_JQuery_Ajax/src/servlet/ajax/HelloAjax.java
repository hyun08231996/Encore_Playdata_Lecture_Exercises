package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloAjax")
public class HelloAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		
		//System.out.println(name); //encore.. 일단 요청이 잘 들어갔는지를 확인
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		
		out.print(name);//이때 응답이 들어간다..Ajax에서 응답을 받는 부분의 코드는 아직 작성 안되어 있다...
	}

}
