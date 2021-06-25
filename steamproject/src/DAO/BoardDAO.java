package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.boardDTO;
import DTO.gameDTO;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	boardDTO dto = null;
	ArrayList<boardDTO> bl = new ArrayList<boardDTO>();
	ArrayList<boardDTO> al2 = new ArrayList<boardDTO>();
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

	// �Խñ� �ۼ�
	public int write(boardDTO dto) {

		// ��Ÿ�ӿ��� : �������� �� �߻��ϴ� ���� -> ����ó��
		try {
			conn();

			String sql = "insert into game_board values(number_board.nextval,?,?,?,?,sysdate,0,0)";
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

	// �ۼ��� �Խñ� Ȯ��
	public ArrayList<boardDTO> select() {

		try {
			conn();

			String sql = "select * from game_board order by board_date desc";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				int num = rs.getInt("board_num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String text = rs.getString("text");
				String img = rs.getString("img");
				String date = rs.getString("board_date");
				int count_num = rs.getInt("count_num");
				int board_recom = rs.getInt("board_recom");
				


				
				boardDTO dto = new boardDTO(num, id, title, text, img, date, count_num, board_recom);
				bl.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bl;

	}
	public ArrayList<boardDTO> boardlist(String title) {
		try {
			
			conn();
			String sql = "select * from game_board where title like ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, title+"%");

			rs = pst.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("board_num");
				String id = rs.getString("id");
				String get_title = rs.getString("title");
				String text = rs.getString("text");
				String img = rs.getString("img");
				String date = rs.getString("board_date");
				int count_num = rs.getInt("count_num");
				int board_recom = rs.getInt("board_recom");
				
				dto = new boardDTO(num,id,get_title,text,img,date,count_num,board_recom);
				al2.add(dto);
				System.out.println("�Խñ� �˻� ����!dao����");
				
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�Խñ� �˻� ����!dao����");
		} finally {
			close();
		}return al2;
		}

	// �Խñ� �������. -(�Խñ� ��ȣ�� �����)
	public int delete1(int num) {
		try {
			conn();

			String sql = "delete from game_board where board_num = ? ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, num);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
public boardDTO one_select(int num) {
		
		
		try {
		
		conn();

		String sql = "select * from game_board where Board_num = ?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, num);

		rs = pst.executeQuery();

		if (rs.next()) {
			int get_num = rs.getInt("board_num"); //�� num�� ���� ���̺��� num�� ���� �޾��ִ� ���̱⶧���� �Ű������� �ٸ��� ���ش�.
			String id = rs.getString("id");
			String title = rs.getString("title");
			String text = rs.getString("text");
			String img = rs.getString("img");
			String date = rs.getString("board_date");
			int count_num = rs.getInt("count_num");
			int board_recom = rs.getInt("board_recom");
			count_num++;
			dto = new boardDTO(get_num, id, title,text,img,date, count_num, board_recom);
			System.out.println("�Խù� ���� ����!");
			bl.add(dto);
			
		} else {
			System.out.println("�Խù� ���� ����!");
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}return dto;
	}	
	

	// ����ڰ� ������ �Է��ؼ� Ư�� �Խñ۸� Ȯ���غ���..ex) test�ļ� �������, �������� asd������ �־ �Ȱ��������� Ȯ��.
	public boardDTO title_select(String title) {
		try {

			conn();

			String sql = "select * from game_board where title like '?%'";
			pst = conn.prepareStatement(sql);
			pst.setString(1, title);

			rs = pst.executeQuery();

			if (rs.next()) {
				int num = rs.getInt("board_num");
				String id = rs.getString("id");
				String text = rs.getString("text");
				String img = rs.getString("img");
				String date = rs.getString("board_date");
				int count_num = rs.getInt("count_num");
				int board_recom = rs.getInt("board_recom");
				dto = new boardDTO(num, id, title,text,img,date, count_num, board_recom);
				System.out.println("�Խù� ���� ����!");

			} else {
				System.out.println("�Խù� ���� ����!");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}

	
	/// �Խñ� �������� �˻�.
	public boardDTO text_select(String text) {
		try {

			conn();

			String sql = "select * from game_board where text like '%?%'";
			pst = conn.prepareStatement(sql);
			pst.setString(1, text);

			rs = pst.executeQuery();

			if (rs.next()) {
				int num = rs.getInt("board_num");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String img = rs.getString("img");
				String date = rs.getString("board_date");
				int count_num = rs.getInt("count_num");
				int board_recom = rs.getInt("board_recom");
				dto = new boardDTO(num, id, title,text,img,date, count_num, board_recom);
				System.out.println("�Խù� ���� ����!");

			} else {
				System.out.println("�Խù� ���� ����!");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	// �Խñ� ����� ���̵�� �˻�.
	public ArrayList<boardDTO> id_select(String id) {
		try {
		
		conn();

		String sql = "select * from game_board where id = ?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, id);

		rs = pst.executeQuery();

		while (rs.next()) {
			int num = rs.getInt("board_num");
			String title = rs.getString("title");
			String text = rs.getString("text");
			String img = rs.getString("img");
			String date = rs.getString("board_date");
			int count_num = rs.getInt("count_num");
			int board_recom = rs.getInt("board_recom");
			dto = new boardDTO(num, id, title,text,img,date, count_num, board_recom);
			System.out.println("�Խù� ���� ����!");
			bl.add(dto);
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}return bl;
	}
	
	public int count(int board_num) {
		int num = 0;
		try {
		conn();
		
		String sql = "UPDATE game_board set count_num = count_num+1 where board_num = ?";
		pst =conn.prepareStatement(sql);
		pst.setInt(1, board_num);
		
		cnt = pst.executeUpdate();
		
		if(cnt != 0) {
			System.out.println("��ȸ�� ��� ���� dao");
			num = 1;
			System.out.println(num);
		}
		
		
		
		}catch(Exception e) {
			System.out.println("��ȸ�� ��� ���� dao");
			e.printStackTrace();
		}finally {
			close();
		}return num;
	}
	public int like(int board_num) {
		int num = 0;
		try {
		conn();
		
		String sql = "UPDATE game_board set board_recom = board_recom+1 where board_num = ?";
		pst =conn.prepareStatement(sql);
		pst.setInt(1, board_num);
		
		cnt = pst.executeUpdate();
		
		if(cnt != 0) {
			System.out.println("��ȸ�� ��� ���� dao");
			num = 1;
			System.out.println(num);
		}
		
		
		
		}catch(Exception e) {
			System.out.println("��ȸ�� ��� ���� dao");
			e.printStackTrace();
		}finally {
			close();
		}return num;
	}
	public int bad(int board_num) {
		int num = 0;
		try {
			conn();
			
			String sql = "UPDATE game_board set board_recom = board_recom-1 where board_num = ?";
			pst =conn.prepareStatement(sql);
			pst.setInt(1, board_num);
			
			cnt = pst.executeUpdate();
			
			if(cnt != 0) {
				System.out.println("��ȸ�� ��� ���� dao");
				num = 1;
				System.out.println(num);
			}
			
			
			
		}catch(Exception e) {
			System.out.println("��ȸ�� ��� ���� dao");
			e.printStackTrace();
		}finally {
			close();
		}return num;
	}
	
	//���� �����ϱ�
	public void copyFilename(String beforePath, String afterPath) {
        
        File oriFile = new File(beforePath);
        File copyfile = new File(afterPath);
        
        try {
           FileInputStream fis = new FileInputStream(oriFile);
           FileOutputStream fos = new FileOutputStream(copyfile);
           
           int fileByte = 0;
           while((fileByte = fis.read()) != -1) {
              fos.write(fileByte);
           }
           fis.close();
           fos.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
     }
	

}
