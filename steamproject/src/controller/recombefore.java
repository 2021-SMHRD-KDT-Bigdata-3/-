package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.RecomDAO;
import DTO.gameDTO;
import DTO.memberDTO;

@WebServlet("/recombefore")
public class recombefore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RecomDAO dao = new RecomDAO();
		HttpSession session = request.getSession();
		memberDTO member = (memberDTO)session.getAttribute("member");
		String game_list = dao.recomGame(member.getId());
		System.out.println(game_list);
		String[] array = game_list.split(",");
		for (int i = 0; i < array.length; i++) {
			System.out.println(i+"¹øÂ°"+array[i]);
		}
		ArrayList<gameDTO> al = new ArrayList<gameDTO>();
		
		for(int i=0; i<array.length; i++) {
			gameDTO dto = dao.game(Integer.parseInt(array[i]));
			al.add(dto);
		}
		
		session.setAttribute("new_dto", al);
		response.sendRedirect("http://localhost:8087/steamproject/templatemo_559_zay_shop/recomResult.jsp");
	
	}

}
