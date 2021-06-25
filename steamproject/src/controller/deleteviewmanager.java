package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;

@WebServlet("/deleteviewmanager")
public class deleteviewmanager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		BoardDAO dao = new BoardDAO();
		int cnt = dao.delete1(num);

		if (cnt > 0) {
			response.sendRedirect("templatemo_559_zay_shop/boardmanage.jsp");
		}
	
	}

}
