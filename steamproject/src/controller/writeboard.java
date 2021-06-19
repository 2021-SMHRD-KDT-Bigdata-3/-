package controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.BoardDAO;
import DTO.boardDTO;

@WebServlet("/writeboard")
public class writeboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ������(���(WriterBoard)���), ������ �ִ�ũ��, �����̸� ���ڵ�
//		System.out.println(request.getServletContext().getRealPath("img")); //�̹��� ������ �˾ƿ��� ���. ������ ������ �ؾ��ϴϱ�
		String savePath = request.getServletContext().getRealPath("img");
		int maxSize = 5 * 1024 * 1024; // 5Mb;(1024mb == 1MB)
		String encoding = "UTF-8";

		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encoding,
				new DefaultFileRenamePolicy());
		// ������ ��ü�� ������ �̸��� ������ ������ �����ִ� ��ü��.

		String id = multi.getParameter("id");
		String title = multi.getParameter("title");
		String text = multi.getParameter("text");
		String img = URLEncoder.encode(multi.getFilesystemName("img"), "utf-8"); // ���� �̸��� URL ENCODE�� �ȃ����� �ѱ����ڵ�

		// �ش�ֵ� ������ ������ �Ű������ٸ��� �����ε����ְ� dto ��ü����
		boardDTO dto = new boardDTO(id, title, text, img);
		// dao��ü���� �� , int cnt�� dao�� ���� ����� write()�ȿ� ���� ������� dto��� �����ڸ� �־���.
		BoardDAO dao = new BoardDAO();
		int cnt = dao.write(dto);

		if (cnt > 0) {
			System.out.println("���� ���ε� ����");
			response.sendRedirect("templatemo_559_zay_shop/board.jsp");
		} else {
			System.out.println("���� ���ε� ����");
		}

		
	}

}
