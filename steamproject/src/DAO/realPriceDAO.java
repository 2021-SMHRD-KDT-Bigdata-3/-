package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.realPriceDTO;

public class realPriceDAO {
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	realPriceDTO rpdto = null;
	ArrayList<realPriceDTO> pl = new ArrayList<realPriceDTO>();
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
	
	
	public ArrayList<realPriceDTO> real(String genre) {
		try {
			conn();
			String sql = "select d.game_num,d.real_price from game e ,game_price d where e.game_num = d.game_num and genre = ? order by d.game_num";
			pst = conn.prepareStatement(sql);
			pst.setString(1, genre);

			rs = pst.executeQuery();

			while(rs.next()) {
				
				int game_num =rs.getInt("game_num");
				int real_price = rs.getInt("real_price");
				
				
				rpdto = new realPriceDTO(game_num,real_price);
				pl.add(rpdto);
				System.out.println("���� �˻� ����!");
				
			} 
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���� �˻� ����!");
		} finally {
			close();
		}return pl;
		}
	public ArrayList<realPriceDTO> realname(String game_name) {
		try {
			conn();
			String sql = "select e.game_num, d.real_price from game e ,game_price d where game_name like ? and e.game_num = d.game_num";
			pst = conn.prepareStatement(sql);
			pst.setString(1, game_name+"%");
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				int game_num =rs.getInt("game_num");
				int real_price = rs.getInt("real_price");
				
				
				rpdto = new realPriceDTO(game_num,real_price);
				pl.add(rpdto);
				System.out.println("���� �˻� ����!");
				
			} 
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���� �˻� ����!");
		} finally {
			close();
		}return pl;
	}
	
	
}
