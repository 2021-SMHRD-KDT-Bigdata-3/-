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
import DTO.memberDTO;

@WebServlet("/recommand")
public class recommand extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int[] array = new int[12];
		Random ran = new Random();
		request.setCharacterEncoding("utf-8");
		RecomDAO dao = new RecomDAO();
		String num = "";
		HttpSession session = request.getSession();
		memberDTO member = (memberDTO)session.getAttribute("member");

		int group = Integer.parseInt(request.getParameter("group"));

		System.out.println(group);
		System.out.println(member.getId());

		ArrayList<gameDTO> dto = dao.group(group);
		ArrayList<gameDTO> new_dto = new ArrayList<gameDTO>();
		
		
		for (int i = 0; i < array.length; i++) {
			array[i] = ran.nextInt(dto.size());
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					array[i] = ran.nextInt(dto.size());
					j = -1; // j를 다시 0으로 초기화
				}
			}
			System.out.println("행운의 숫자 : "+array[i]);
		}
		
		for (int i = 0; i < 11; i++) {
			num+=dto.get(array[i]).getGame_num()+",";
		}
		num+=dto.get(array[11]).getGame_num();
		
		dao.update(member.getId(), num);
		
		for (int i = 0; i < 12; i++) {
			new_dto.add(dto.get(array[i]));
		}
		
		//String game_list = dao.recomGame(member.getId());
		
		session.setAttribute("new_dto", new_dto);
		//request.setAttribute("game_list", game_list);
		response.sendRedirect("templatemo_559_zay_shop/recomResult.jsp");

		
	}

}
