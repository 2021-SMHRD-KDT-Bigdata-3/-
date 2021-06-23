package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import DTO.boardDTO;

@WebServlet("/boardselect")
public class boardselect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String title  = request.getParameter("title_name");
		System.out.println(request.getParameter("title_name"));
		
		
		BoardDAO dao = new BoardDAO();
		ArrayList<boardDTO> dto = dao.boardlist(title);
		HttpSession session = request.getSession();
		session.setAttribute("title", title);
		
		
		if(dto!=null) {
			System.out.println("게시글검색 성공!");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.sendRedirect("templatemo_559_zay_shop/board3.jsp");
			
		}else {
			System.out.println("게시글검색 실패");
		}
}
	
	

}
