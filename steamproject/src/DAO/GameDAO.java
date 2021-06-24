package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.gameDTO;
import DTO.memberDTO;

public class GameDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	gameDTO dto = null;
	ArrayList<gameDTO> cl = new ArrayList<gameDTO>();
	ArrayList<gameDTO> dl = new ArrayList<gameDTO>();
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
	public ArrayList<gameDTO> gamelist(String game_name) {
		try {
			conn();
			String sql = "select * from game where game_name like ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, game_name+"%");

			rs = pst.executeQuery();

			while (rs.next()) {
				int game_num =rs.getInt("game_num");
				String get_name = rs.getString("game_name");
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
				
				dto = new gameDTO(game_num, get_name, genre, graphic, thema, atmos, multi, price, lv, playtime, score, image);
				cl.add(dto);
				System.out.println("게임 검색 성공!dao성공");
				
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게임 검색 실패!dao실패");
		} finally {
			close();
		}return cl;
		}
	//카테고리(genre),검색
	public ArrayList<gameDTO> gamegenre(String genre) {
		try {
			conn();
			String sql = "select * from game where genre=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, genre);

			rs = pst.executeQuery();

			while(rs.next()) {
				
				int game_num =rs.getInt("game_num");
				String game_name = rs.getString("game_name");
				String game_genre = rs.getString("genre");
				int graphic = rs.getInt("graphic");
				String thema = rs.getString("thema");
				int atmos = rs.getInt("atmos");
				int multi = rs.getInt("multi");
				int price = rs.getInt("price");
				int lv = rs.getInt("lv");
				int playtime = rs.getInt("playtime");
				int score = rs.getInt("score");
				String image = rs.getString("image");
				
				dto = new gameDTO(game_num,game_name,game_genre,graphic,thema,atmos,multi,price,lv,playtime,score,image);
				dl.add(dto);
				System.out.println("게임 검색 성공!");
				
			} 
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("게임 검색 실패!");
		} finally {
			close();
		}return dl;
		}
	
	
	
}
