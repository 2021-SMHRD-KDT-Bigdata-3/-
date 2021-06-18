package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.memberDTO;


public class MemberDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt = 0;
	memberDTO dto = null;
	
	//DB연결
	public void conn() {
		//1. JDBC 드라이버 동적로딩
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url ="jdbc:oracle:thin:@211.227.114.161:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";
		
		//2. 데이터 베이스 연결객체(Connection) 생성
		conn = DriverManager.getConnection(url,dbid,dbpw);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//DB닫기
	public void close() {
		try {
			if(rs!=null) {
				rs.close();
				
			}
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//회원가입
	public int join(String id, String pw, String name, int age, String gender, String tel) {

		// 런타임오류 : 실행했을 때 발생하는 오류 -> 예외처리
		try {
			conn();

			String sql = "insert into game_member values(?,?,?,?,?,?)";
			// 3. sql문 실행객체 (PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 4. 바인드변수채우기.
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, name);
			pst.setInt(4, age);
			pst.setString(5, gender);
			pst.setString(6, tel);

			// 5. cnt만들고 변동이 있어야만 가게끔 만들자.
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패!");
		} finally {
			close();
		}
		return cnt;
	}
	
	public memberDTO login(String id, String pw) {
		try {
			conn();

			String sql = "select * from game_member where id=? and pw=?";
			// 3. sql문 실행객체 (PreparedStatement) 생성
			pst = conn.prepareStatement(sql);

			// 4. 바인드변수채우기.
			pst.setString(1, id);
			pst.setString(2, pw);
			
			// 5. cnt만들고 변동이 있어야만 가게끔 만들자.
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String tel = rs.getString("tel");
				dto = memberDTO(id,pw,name,age,gender,tel);
			}else {
				System.out.println("로그인 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패!");
		} finally {
			close();
		}
		
		return dto;
	}

	private memberDTO memberDTO(String id, String pw, String name, int age, String gender, String tel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
