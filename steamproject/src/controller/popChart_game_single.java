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
import DTO.gameDTO;

@WebServlet("/popChart_game_single")
public class popChart_game_single extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String game_name = request.getParameter("game_name");
		System.out.println(game_name);
		GameDAO dao = new GameDAO();
		ArrayList<gameDTO> dto = dao.gamelist(game_name);
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		response.sendRedirect("templatemo_559_zay_shop/game-single.jsp");
	}

}
