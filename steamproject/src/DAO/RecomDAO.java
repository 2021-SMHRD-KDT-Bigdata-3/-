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
			System.out.println("�ҷ����� ����");
		} finally {
			close();
		}
		return al;

	}
	
	//��õ ���̺������Ʈ
	public void update(String id, String num) {

		// ��Ÿ�ӿ��� : �������� �� �߻��ϴ� ���� -> ����ó��
		try {
			conn();
			
			//��� ã��
			String sql = "select * from game_recom where id=?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, id);
			
			rs = pst.executeQuery();
			
			if(!rs.next()) {
				sql = "insert into game_recom values(?,?)";
				// 3. sql�� ���ఴü (PreparedStatement) ����
				pst = conn.prepareStatement(sql);

				// 4. ���ε庯��ä���.
				pst.setString(1, id);
				pst.setString(2, num);

				// 5. cnt����� ������ �־�߸� ���Բ� ������.
				pst.executeUpdate();
			}else {
				sql = "update game_recom set game_list=? where id=?";
				// 3. sql�� ���ఴü (PreparedStatement) ����
				pst = conn.prepareStatement(sql);

				// 4. ���ε庯��ä���.
				pst.setString(1, num);
				pst.setString(2, id);

				// 5. cnt����� ������ �־�߸� ���Բ� ������.(cnt����)
				pst.executeUpdate();
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db�ֱ� ����");
		} finally {
			close();
		}
	}
	
	//���� �ҷ�����
	public ArrayList<gameDTO> game(int num) {
		try {
			conn();

			String sql = "select * from game where game_num=?";
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
				
				game_dto = new gameDTO(game_num, game_name, genre, graphic, thema, atmos, multi, price, lv, playtime, score, image);
				al.add(game_dto);
			} 
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ҷ����� ����");
		} finally {
			close();
		}
		return al;
	}
	
	//��õ���� ��� ��������
	public String recomGame(String id) {
		String result = "";
		try {
			conn();

			String sql = "select * from game_recom where game_list=?";
			// 3. sql�� ���ఴü (PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. ���ε庯��ä���.
			pst.setString(1, id);

			// 5. cnt����� ������ �־�߸� ���Բ� ������.
			rs = pst.executeQuery();

			while (rs.next()) {
				result = rs.getString("game_list");
			} 
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ҷ����� ����");
		} finally {
			close();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
