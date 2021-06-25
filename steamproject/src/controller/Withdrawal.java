package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import DTO.memberDTO;

@WebServlet("/Withdrawal")
public class Withdrawal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		memberDTO member = (memberDTO)session.getAttribute("member");
		MemberDAO dao = new MemberDAO();
		int cnt = dao.delete(member.getId());
		//"member"키를 가진 세션을 삭제
		session.invalidate();
		//session.invalidate();
		

		if (cnt > 0) {
			response.sendRedirect("templatemo_559_zay_shop/mainPage.jsp");
		}
		
	
	
	
	}

}
