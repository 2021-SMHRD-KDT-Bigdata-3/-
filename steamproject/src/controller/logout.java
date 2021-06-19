package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		//"member"Ű�� ���� ������ ����
		session.removeAttribute("member");
		//session.invalidate();
		
		//main.jsp �� �̵�
		response.sendRedirect("templatemo_559_zay_shop/mainPage.jsp");
	
	
	}

}
