package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GameDAO;
import DAO.MemberDAO;
import DTO.gameDTO;
import DTO.memberDTO;

@WebServlet("/select")
public class select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		String game_name  = request.getParameter("search");
		System.out.println(request.getParameter("search"));
		
		
		
		
		
		GameDAO dao = new GameDAO();
		ArrayList<gameDTO> cnt = dao.gamelist(game_name);
		
		if(cnt!=null) {
			System.out.println("게임검색 성공!");
			response.sendRedirect("templatemo_559_zay_shop/searchResult.jsp?game_name="+game_name);
			
		}else {
			System.out.println("게임검색 실패");
		}
}}



	
	
	


