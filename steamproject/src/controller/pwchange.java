package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;

@WebServlet("/pwchange")
public class pwchange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		request.setCharacterEncoding("UTF-8");	
		
		
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		
		System.out.println("pw");
		System.out.println("pw2");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.pwchange(pw,pw2);
		
		if(cnt> 0) {
			System.out.println("비밀번호 변경 성공!");
			
			response.sendRedirect("templatemo_559_zay_shop/myPage.jsp");
			
		}
}
		
		
		
		
	}
	


