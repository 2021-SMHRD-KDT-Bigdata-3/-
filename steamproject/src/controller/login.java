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

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("EUC-kr");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		memberDTO dto = dao.login(id, pw);
		
		HttpSession session = request.getSession(); //servlet안에 session을 불러오는 메소드
		session.setAttribute("member", dto);
		//vo에 담겨져있으므로 페이지를 이동해도 값이 전달이 된다.
		response.sendRedirect("mainpage.jsp");
	}

}
