package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.boardDTO;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	boardDTO dto = null;
	ArrayList<boardDTO> bl = new ArrayList<boardDTO>();
	int cnt = 0;

	// 데이터베이스 연결
	public void conn() {
		// 1. JDBC 드라이버 동적로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@211.227.114.161:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			// 2. 데이터 베이스 연결객체(Connection) 생성
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 닫아주기.
	public void close() {
		try {
			if (rs != null) {
				rs.close();

			}
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 게시글 작성
	public int write(boardDTO dto) {

		// 런타임오류 : 실행했을 때 발생하는 오류 -> 예외처리
		try {
			conn();

			String sql = "insert into game_board values(number_board.nextval,?,?,?,?,sysdate)";
			// 3. sql문 실행객체 (PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 4. 바인드변수채우기.
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getText());
			pst.setString(4, dto.getImg());

			// 5. cnt만들고 변동이 있어야만 가게끔 만들자.
			cnt = pst.executeUpdate();
			if (cnt != 0) {
				System.out.println("게시물 등록 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게시물 등록 실패!");
		} finally {
			close();
		}
		return cnt;
	}

	// 작성된 게시글 확인(날짜순으로)
	public ArrayList<boardDTO> select() {

		try {
			conn();

			String sql = "select * from game_board order by board_date";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				int num = rs.getInt("board_num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String text = rs.getString("text");
				String img = rs.getString("img");
				String date = rs.getString("board_date");
				boardDTO dto = new boardDTO(num, id, title, text, img, date);
				bl.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bl;

	}

	// 게시글 삭제기능. -(게시글 번호로 지우기)
	public int delete1(int num) {
		try {
			conn();

			String sql = "delete from game_board where board_num = ? ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, num);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
public boardDTO one_select(int num) {
		
		
		try {
		
		conn();

		String sql = "select * from game_board where num = ?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, num);

		rs = pst.executeQuery();

		if (rs.next()) {
			int get_num = rs.getInt("board_num"); //이 num은 현재 테이블의 num의 수를 받아주는 애이기때문에 매개변수랑 다르게 해준다.
			String id = rs.getString("id");
			String title = rs.getString("title");
			String text = rs.getString("text");
			String img = rs.getString("img");
			String date = rs.getString("board_date");
			dto = new boardDTO(get_num, id, title,text,img,date);
			System.out.println("게시물 보기 성공!");
			
		} else {
			System.out.println("게시물 보기 실패!");
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}return dto;
	}	
	

	// 사용자가 제목을 입력해서 특정 게시글만 확인해보기..ex) test쳐서 갖고오고, 가데이터 asd같은거 넣어서 안가져오는지 확인.
	public boardDTO title_select(String title) {
		try {

			conn();

			String sql = "select * from game_board where title like '?%'";
			pst = conn.prepareStatement(sql);
			pst.setString(1, title);

			rs = pst.executeQuery();

			if (rs.next()) {
				int num = rs.getInt("board_num");
				String id = rs.getString("id");
				String text = rs.getString("text");
				String img = rs.getString("img");
				String date = rs.getString("board_date");
				dto = new boardDTO(num, id, title, text, img, date);
				System.out.println("게시물 보기 성공!");

			} else {
				System.out.println("게시물 보기 실패!");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	
	/// 게시글 내용으로 검색.
	public boardDTO text_select(String text) {
		try {

			conn();

			String sql = "select * from game_board where text like '%?%'";
			pst = conn.prepareStatement(sql);
			pst.setString(1, text);

			rs = pst.executeQuery();

			if (rs.next()) {
				int num = rs.getInt("board_num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String img = rs.getString("img");
				String date = rs.getString("board_date");
				dto = new boardDTO(num, id, title, text, img, date);
				System.out.println("게시물 보기 성공!");

			} else {
				System.out.println("게시물 보기 실패!");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	// 게시글 사용자 아이디로 검색.
	public boardDTO id_select(String id) {
		try {
		
		conn();

		String sql = "select * from game_board where id like '?%'";
		pst = conn.prepareStatement(sql);
		pst.setString(1, id);

		rs = pst.executeQuery();

		if (rs.next()) {
			int num = rs.getInt("board_num");
			String title = rs.getString("title");
			String text = rs.getString("text");
			String img = rs.getString("img");
			String date = rs.getString("board_date");
			dto = new boardDTO(num, id,title, text, img, date);
			System.out.println("게시물 보기 성공!");
			
		} else {
			System.out.println("게시물 보기 실패!");
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}return dto;
	}

}
