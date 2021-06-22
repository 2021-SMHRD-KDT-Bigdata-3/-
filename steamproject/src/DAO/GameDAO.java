package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.boardDTO;
import DTO.gameDTO;

public class GameDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	gameDTO dto = null;
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
	//게임이름으로 게임찾기
	public gameDTO gamelist(String game_name) {
		try {
			conn();
			String sql = "select * from game where game_name like '?%'";
			pst = conn.prepareStatement(sql);
			pst.setString(1, game_name );

			rs = pst.executeQuery();

			if (rs.next()) {
				String genre = rs.getString("genre");
				int graphic = rs.getInt("graphic");
				String thema = rs.getString("thema");
				String atmos = rs.getString("atmos");
				int multi = rs.getInt("multi");
				int price = rs.getInt("genre");
				int lv = rs.getInt("lv");
				int playtime = rs.getInt("playtime");
				int score = rs.getInt("score");
				
				gameDTO dto = new gameDTO(game_name,genre,graphic,thema,atmos,multi,price,lv,playtime,score);
				System.out.println("게임 검색 성공!");
				
			} else {
				System.out.println("게임 검색 실패!");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}return dto;
		}

	
	
}
