package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.boardDTO;

public class GameDAO {

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
	
	public int gamelist() {
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

	
	
}
