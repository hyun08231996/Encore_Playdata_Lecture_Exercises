package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		try {
			boolean flag = MemberDAOImpl.getInstance().isExist(id);
			out.print(flag);//true|false
		} catch(SQLException e) {
			
		}
		
		
		return null;
	}

}
