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
	
	//군집 불러오는 기능
	public ArrayList<gameDTO> group(int num) {
		try {
			conn();

			String sql = "select * from game where group_num=?";
			// 3. sql문 실행객체 (PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 4. 바인드변수채우기.
			pst.setInt(1, num);

			// 5. cnt만들고 변동이 있어야만 가게끔 만들자.
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
			System.out.println("불러오기 실패");
		} finally {
			close();
		}
		return al;

	}
	
	//추천 테이블업데이트
	public void update(String id, String num) {

		// 런타임오류 : 실행했을 때 발생하는 오류 -> 예외처리
		try {
			conn();
			
			//사람 찾기
			String sql = "select * from game_recom where id=?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, id);
			
			rs = pst.executeQuery();
			
			if(!rs.next()) {
				sql = "insert into game_recom values(?,?)";
				// 3. sql문 실행객체 (PreparedStatement) 생성
				pst = conn.prepareStatement(sql);

				// 4. 바인드변수채우기.
				pst.setString(1, id);
				pst.setString(2, num);

				// 5. cnt만들고 변동이 있어야만 가게끔 만들자.
				pst.executeUpdate();
			}else {
				sql = "update game_recom set game_list=? where id=?";
				// 3. sql문 실행객체 (PreparedStatement) 생성
				pst = conn.prepareStatement(sql);

				// 4. 바인드변수채우기.
				pst.setString(1, num);
				pst.setString(2, id);

				// 5. cnt만들고 변동이 있어야만 가게끔 만들자.(cnt없앰)
				pst.executeUpdate();
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("db넣기 실패");
		} finally {
			close();
		}
	}
	
	//게임 불러오기
	public ArrayList<gameDTO> game(int num) {
		try {
			conn();

			String sql = "select * from game where game_num=?";
			// 3. sql문 실행객체 (PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 4. 바인드변수채우기.
			pst.setInt(1, num);

			// 5. cnt만들고 변동이 있어야만 가게끔 만들자.
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
			System.out.println("불러오기 실패");
		} finally {
			close();
		}
		return al;
	}
	
	//추천게임 목록 가져오기
	public String recomGame(String id) {
		String result = "";
		try {
			conn();

			String sql = "select * from game_recom where game_list=?";
			// 3. sql문 실행객체 (PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 4. 바인드변수채우기.
			pst.setString(1, id);

			// 5. cnt만들고 변동이 있어야만 가게끔 만들자.
			rs = pst.executeQuery();

			while (rs.next()) {
				result = rs.getString("game_list");
			} 
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("불러오기 실패");
		} finally {
			close();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
