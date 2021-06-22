package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;

@WebServlet("/join")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//main.jsp���� ���� email, pw, tel, address �� �޾Ƽ� ������ ���
				//post������� ���� ���� �ѱ� ���ڵ�
			request.setCharacterEncoding("UTF-8");	
			
			String idcheck = request.getParameter("idcheck");
			String pwcheck = request.getParameter("pwcheck");
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String tel = request.getParameter("tel");
			MemberDAO dao = new MemberDAO();
			int cnt = dao.join(id,pw,name,age,gender,tel);
			
			if(cnt> 0) {
				System.out.println("ȸ������ ����!");
				//request ������ �� ����
				request.setAttribute("id", id);
				request.setAttribute("pw", pw);
				request.setAttribute("name", name);
				request.setAttribute("age", age);
				request.setAttribute("gender", gender);
				request.setAttribute("tel", tel);
				// response.sendRedirect("joinSuccess.jsp"); �ִ� ���� ��������.
				
				response.sendRedirect("templatemo_559_zay_shop/mainPage.jsp");
				
			}
	}

}
