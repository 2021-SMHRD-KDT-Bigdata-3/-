package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.gameDTO;
import DTO.memberDTO;

public class RecomDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	gameDTO game_dto = null;
	memberDTO member_dto = null;
	int cnt = 0;
	ArrayList<gameDTO> al = new ArrayList<gameDTO>();
	
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
	
	//���� �ҷ����� ���
	public ArrayList<gameDTO> group(int num) {
		try {
			conn();

			String sql = "select * from game where group_num=?";
			// 3. sql�� ���ఴü (PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. ���ε庯��ä���.
			pst.setInt(1, num);

			// 5. cnt����� ������ �־�߸� ���Բ� ������.
			rs = pst.executeQuery();

			while (rs.next()) {
				int game_num = rs.getInt("game_num");
				String game_name = rs.getString("game_name");
				String genre = rs.getString("genre");
				int graphic = rs.getInt("graphic");
				String thema = rs.getString("thema");
				int atmos = rs.getInt("atmos");
				int multi = rs.getInt("multi");
				int price = rs.getInt("price");
				int lv = rs.getInt("lv");
				int playtime = rs.getInt("playtime");
				int score = rs.getInt("score");
				String image = rs.getString("image");
				int group_num = rs.getInt("group_num");
				game_dto = new gameDTO(game_num, game_name, genre, graphic, thema, atmos, multi, price, lv, playtime, score, image, group_num);
				al.add(game_dto);
			} 
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�α��� ����!");
		} finally {
			close();
		}
		return al;

	}
	
}
