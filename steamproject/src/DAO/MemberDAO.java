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
	
	//DB����
	public void conn() {
		//1. JDBC ����̹� �����ε�
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url ="jdbc:oracle:thin:@211.227.114.161:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";
		
		//2. ������ ���̽� ���ᰴü(Connection) ����
		conn = DriverManager.getConnection(url,dbid,dbpw);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//DB�ݱ�
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
	
	//ȸ������
	public int join(String id, String pw, String name, int age, String gender, String tel) {

		// ��Ÿ�ӿ��� : �������� �� �߻��ϴ� ���� -> ����ó��
		try {
			conn();

			String sql = "insert into game_member values(?,?,?,?,?,?)";
			// 3. sql�� ���ఴü (PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. ���ε庯��ä���.
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, name);
			pst.setInt(4, age);
			pst.setString(5, gender);
			pst.setString(6, tel);

			// 5. cnt����� ������ �־�߸� ���Բ� ������.
			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ȸ������ ����!");
		} finally {
			close();
		}
		return cnt;
	}
	
	public memberDTO login(String id, String pw) {
		try {
			conn();

			String sql = "select * from game_member where id=? and pw=?";
			// 3. sql�� ���ఴü (PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. ���ε庯��ä���.
			pst.setString(1, id);
			pst.setString(2, pw);
			
			// 5. cnt����� ������ �־�߸� ���Բ� ������.
			rs = pst.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String tel = rs.getString("tel");
				dto = memberDTO(id,pw,name,age,gender,tel);
			}else {
				System.out.println("�α��� ����");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ȸ������ ����!");
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
