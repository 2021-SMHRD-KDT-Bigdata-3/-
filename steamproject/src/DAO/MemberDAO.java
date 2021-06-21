package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.boardDTO;
import DTO.gameDTO;
import DTO.memberDTO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	memberDTO dto = null;
	int cnt = 0;
	ArrayList<memberDTO> al = null;
	// DB����
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

	// DB�ݱ�
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

	// ȸ������
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
	
	
	// �α���
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

			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String tel = rs.getString("tel");
				dto = new memberDTO(id, pw, name, age, gender, tel);
			} else {
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
	//ȸ������ ���� - > ��������. where�� ����ؼ� id�� pw�� �Ȱ��� �ָ� �ٲ�Բ�.
	public int update(String id1, String pw1, String name, int age,
			String gender, String tel,String id,String pw) {
		try {
			conn();

			String sql = "update game_member set id = ?, pw = ?, name = ?, age= ?,"
					+ "gender = ? , tel = ?, where id = ?, pw = ?";
			// 3. sql�� ���ఴü (PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. ���ε庯��ä���.
			pst.setString(1, id1);
			pst.setString(2, pw1);
			pst.setString(3, name);
			pst.setInt(4, age);
			pst.setString(5, gender);
			pst.setString(6, tel);
			pst.setString(7, id);
			pst.setString(8, pw);

			// 5. cnt����� ������ �־�߸� ���Բ� ������.
			cnt = pst.executeUpdate();
			if(cnt != 0) {
				System.out.println("ȸ������ ���� ����!");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ȸ������ ���� ����!");
		} finally {
			close();
		}

		return cnt;
	}
	// ȸ�� Ż��.- �������������� Ż���Ҷ�, id�� pw��ġ���� �˾ƺ���, ���� �ǰԲ�. ���������ʿ�.
	public int delete(String id , String pw) {
		try {
			conn();

			String sql = "delete game_member where id = ? and pw = ?";
			// 3. sql�� ���ఴü (PreparedStatement) ����
			pst = conn.prepareStatement(sql);

			// 4. ���ε庯��ä���.
			pst.setString(1, id);
			pst.setString(1, pw);

			// 5. cnt����� ������ �־�߸� ���Բ� ������.
			cnt = pst.executeUpdate();

			if (cnt != 0) {
				System.out.println("ȸ��Ż�� ����");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ȸ��Ż�� ����!");
		} finally {
			close();
		}

		return cnt;
	}
	public ArrayList<memberDTO> member(){
		try {
			conn();

			String sql = "select * from game_board where id = order by board_date";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				String id = rs.getNString("id");
				String pw = rs.getNString("pw");
				String name = rs.getNString("name");
				int age = rs.getInt("age");
				String gender = rs.getNString("gender");
				String	tel = rs.getNString("tel");
				


				
				memberDTO ato = new memberDTO(id,pw,name,age,gender,tel);
				al.add(ato);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return al;
		
	}
}
