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

	// �����ͺ��̽� ����
	public void conn() {
		// 1. JDBC ����̹� �����ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@211.227.114.161:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			// 2. ������ ���̽� ���ᰴü(Connection) ����
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �ݾ��ֱ�.
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

	// �Խñ� �ۼ�
	public int write(boardDTO dto) {

		// ��Ÿ�ӿ��� : �������� �� �߻��ϴ� ���� -> ����ó��
		try {
			conn();

			String sql = "insert into game_board values(number_board.nextval,?,?,?,?,sysdate)";
			// 3. sql�� ���ఴü (PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. ���ε庯��ä���.
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getText());
			pst.setString(4, dto.getImg());

			// 5. cnt����� ������ �־�߸� ���Բ� ������.
			cnt = pst.executeUpdate();
			if (cnt != 0) {
				System.out.println("�Խù� ��� ����");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�Խù� ��� ����!");
		} finally {
			close();
		}
		return cnt;
	}

	// �ۼ��� �Խñ� Ȯ��(��¥������)
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

	// �Խñ� �������. -(�Խñ� ��ȣ�� �����)
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
			int get_num = rs.getInt("board_num"); //�� num�� ���� ���̺��� num�� ���� �޾��ִ� ���̱⶧���� �Ű������� �ٸ��� ���ش�.
			String id = rs.getString("id");
			String title = rs.getString("title");
			String text = rs.getString("text");
			String img = rs.getString("img");
			String date = rs.getString("board_date");
			dto = new boardDTO(get_num, id, title,text,img,date);
			System.out.println("�Խù� ���� ����!");
			
		} else {
			System.out.println("�Խù� ���� ����!");
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}return dto;
	}	
	

	// ����ڰ� ������ �Է��ؼ� Ư�� �Խñ۸� Ȯ���غ���..ex) test�ļ� �������, �������� asd������ �־ �Ȱ��������� Ȯ��.
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
				System.out.println("�Խù� ���� ����!");

			} else {
				System.out.println("�Խù� ���� ����!");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	
	/// �Խñ� �������� �˻�.
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
				System.out.println("�Խù� ���� ����!");

			} else {
				System.out.println("�Խù� ���� ����!");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	// �Խñ� ����� ���̵�� �˻�.
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
			System.out.println("�Խù� ���� ����!");
			
		} else {
			System.out.println("�Խù� ���� ����!");
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}return dto;
	}

}
