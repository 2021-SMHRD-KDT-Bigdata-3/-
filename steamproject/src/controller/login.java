package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		memberDTO dto = dao.login(id, pw);

		HttpSession session = request.getSession(); //servlet�ȿ� session�� �ҷ����� �޼ҵ�
		session.setAttribute("member", dto);
		//dto�� ����������Ƿ� �������� �̵��ص� ���� ������ �ȴ�.
		
		if(dto != null) {
			response.sendRedirect("templatemo_559_zay_shop/mainPage.jsp");
		}else {
			response.sendRedirect("templatemo_559_zay_shop/login.jsp");
			
		}
		
	}

}
