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
		// 저장경로(상대(WriterBoard)경로), 파일의 최대크기, 파일이름 인코딩
//		System.out.println(request.getServletContext().getRealPath("img")); //이미지 저장경로 알아오는 방법. 서버에 저장을 해야하니까
		String savePath = request.getServletContext().getRealPath("img");
		int maxSize = 5 * 1024 * 1024; // 5Mb;(1024mb == 1MB)
		String encoding = "UTF-8";

		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encoding,
				new DefaultFileRenamePolicy());
		// 마지막 객체는 동일한 이름의 파일이 있을때 막아주는 객체놈.

		String id = multi.getParameter("id");
		String title = multi.getParameter("title");
		String text = multi.getParameter("text");
		String img = URLEncoder.encode(multi.getFilesystemName("img"), "utf-8"); // 파일 이름은 URL ENCODE로 안꺠지게 한글인코딩

		// 해당애들 변수로 생성자 매개변수다르게 오버로딩해주고 dto 객체생성
		boardDTO dto = new boardDTO(id, title, text, img);
		// dao객체생성 후 , int cnt에 dao가 가진 기능중 write()안에 위에 만들어준 dto라는 생성자를 넣어줌.
		BoardDAO dao = new BoardDAO();
		int cnt = dao.write(dto);

		if (cnt > 0) {
			System.out.println("파일 업로드 성공");
			response.sendRedirect("templatemo_559_zay_shop/board.jsp");
		} else {
			System.out.println("파일 업로드 실패");
		}

		
	}

}
