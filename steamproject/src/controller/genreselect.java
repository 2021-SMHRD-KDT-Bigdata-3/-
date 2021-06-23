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
import DAO.GameDAO;
import DTO.boardDTO;
import DTO.gameDTO;

@WebServlet("/ganreselect")
public class genreselect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String genre  = request.getParameter("genre");
		System.out.println(request.getParameter("genre"));
		
		
		GameDAO dao = new GameDAO();
		ArrayList<gameDTO> dto = dao.gamegenre(genre); 
		HttpSession session = request.getSession();
		session.setAttribute("genre", genre);
		
		
		if(dto!=null) {
			System.out.println("태그검색 성공!");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			response.sendRedirect("templatemo_559_zay_shop/category.jsp");
			
		}else {
			System.out.println("태그검색 실패");
		}
}
	
	
	
	
	

}
