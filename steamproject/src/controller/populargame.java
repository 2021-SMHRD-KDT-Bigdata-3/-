package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.RecomDAO;
import DTO.gameDTO;

@WebServlet("/populargame")
public class populargame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RecomDAO dao = new RecomDAO();
		Random ran = new Random();
		HttpSession session = request.getSession();
		String[] genre = {"액션","전략","시뮬레이션","rpg","어드벤쳐","스포츠 및 레이싱"};
		int num = ran.nextInt(6);
		ArrayList<gameDTO> al1 = dao.popular(genre[num]);
		ArrayList<gameDTO> al2 = new ArrayList<gameDTO>();
		
		for(int i=0; i<15; i++) {
			al2.add(al1.get(i));
		}
		
		session.setAttribute("dto", al2);
		response.sendRedirect("templatemo_559_zay_shop/popChart.jsp");
	}

}
