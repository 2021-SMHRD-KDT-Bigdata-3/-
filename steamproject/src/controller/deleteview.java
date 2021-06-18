package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;

@WebServlet("/deleteview")
public class deleteview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("board_num"));
		Connection conn = null;
		PreparedStatement pst = null;
		BoardDAO dao = new BoardDAO();
		int cnt = dao.delete1(num);

		if (cnt > 0) {
			response.sendRedirect("board.jsp");
		}

	}
}
