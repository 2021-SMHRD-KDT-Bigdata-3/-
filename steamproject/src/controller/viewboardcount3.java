package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;

@WebServlet("/viewboardcount3")
public class viewboardcount3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int board_num  = Integer.parseInt(request.getParameter("num"));
		System.out.println(request.getParameter("num"));
		
		
		BoardDAO dao = new BoardDAO();
		int num = dao.count(board_num);
		System.out.println(num);
		
		if(num!=0) {
			System.out.println("추천수 증가 성공!");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.sendRedirect("templatemo_559_zay_shop/viewboard.jsp?num="+board_num);
			
		}else {
			System.out.println("추천수 증가 실패");
		}
	}
	
	

}
