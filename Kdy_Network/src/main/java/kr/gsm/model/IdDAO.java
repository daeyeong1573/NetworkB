package kr.gsm.model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class IdDAO<MemberDTO> {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	//sql 연동
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String pw = "1234";
		String user = "system";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	//아이디 추가 함수
	public int idInsert(IdDTO dto) {
		int cnt = -1;
		System.out.println("아이디");
		conn = getConnection();
		//초기 아이디값 = null, 아이디를 입력했으면 null이 아니므로 null아닌 아이디에 맞는 sql문 실행
		if (dto.getWebid() != null) {
			System.out.println(dto.getWebid());
			String sql = "insert into web_id_tbl values(?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getWebid());
				ps.setString(2, dto.getPwd());
				ps.setString(3, dto.getPlatform());
				ps.setString(4, dto.getJoindate());
				cnt = ps.executeUpdate(); //SQL 업데이트
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dto.getGameid() != null) {
			String sql = "insert into game_id_tbl values(?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getGameid());
				ps.setString(2, dto.getPwd());
				ps.setString(3, dto.getPlatform());
				ps.setString(4, dto.getJoindate());
				cnt = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dto.getSnsid() != null) {
			String sql = "insert into sns_id_tbl values(?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getSnsid());
				ps.setString(2, dto.getPwd());
				ps.setString(3, dto.getPlatform());
				ps.setString(4, dto.getJoindate());
				cnt = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	//LIST 코드
	public List<IdDTO> idList(String type) {
		List<IdDTO> list = new ArrayList<IdDTO>();
		conn = getConnection();
		//type 변수를 받아와서 웹,game,sns 구별후 리스트 호출
		if (type.equals("Web")) {
			String SQL = "select webid, pwd, platform,joindate from web_id_tbl";
			try {
				ps = conn.prepareStatement(SQL);
				rs = ps.executeQuery();
				while (rs.next()) {
					String webid = rs.getString("webid");
					String pwd = rs.getString("pwd");
					String platform = rs.getString("platform");
					String joindate = rs.getString("joindate"); // 날짜
					// 묶고(DTO)->담고(ArrayList)
					IdDTO dto = new IdDTO(webid, "", "", pwd, platform, joindate);
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (type.equals("Game")) {
			String SQL = "select gameid, pwd, platform,joindate from game_id_tbl";
			try {
				ps = conn.prepareStatement(SQL);
				rs = ps.executeQuery();
				while (rs.next()) {
					String gameid = rs.getString("gameid");
					String pwd = rs.getString("pwd");
					String platform = rs.getString("platform");
					String joindate = rs.getString("joindate"); // 날짜
					// 묶고(DTO)->담고(ArrayList)
					IdDTO dto = new IdDTO("", "", gameid, pwd, platform, joindate);
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String SQL = "select snsid, pwd, platform,joindate from sns_id_tbl";
			try {
				ps = conn.prepareStatement(SQL);
				rs = ps.executeQuery();
				while (rs.next()) {
					String snsid = rs.getString("snsid");
					String pwd = rs.getString("pwd");
					String platform = rs.getString("platform");
					String joindate = rs.getString("joindate"); // 날짜
					// 묶고(DTO)->담고(ArrayList)
					IdDTO dto = new IdDTO("", snsid, "", pwd, platform, joindate);
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list; // 전체리스트 리턴
	}
	
	
	//ID 수정 홈 List 불러오기
	public IdDTO idContent(String id,String type) {
		conn = getConnection();
		IdDTO dto = null;
		System.out.println("컨텐트"+id);
		if (type == "web") {
			String sql = "select webid, pwd, platform, joindate from web_id_tbl where webid=?";
			try {
				System.out.println(id);
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("2성공");
					id = rs.getString("webid");
					String pwd = rs.getString("pwd");
					String platform = rs.getString("platform");
					String joindate = rs.getString("joindate"); // 날짜
					// 묶고(DTO)->담고(ArrayList)
					dto = new IdDTO(id, "", "", pwd, platform, joindate);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("실패");
			}
		}else if (type == "game") {
			String sql = "select gameid, pwd, platform, joindate from game_id_tbl where gameid=?";
			try {
				System.out.println(id);
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("2성공");
					id = rs.getString("gameid");
					String pwd = rs.getString("pwd");
					String platform = rs.getString("platform");
					String joindate = rs.getString("joindate"); // 날짜
					// 묶고(DTO)->담고(ArrayList)
					dto = new IdDTO("", "", id, pwd, platform, joindate);
					System.out.println("2" + dto.getWebid());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("실패");
			}
		}else if (type == "sns") {
			String sql = "select snsid, pwd, platform, joindate from sns_id_tbl where snsid=?";
			try {
				System.out.println(id);
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("SNS CONTENT 성공");
					id = rs.getString("snsid");
					String pwd = rs.getString("pwd");
					String platform = rs.getString("platform");
					String joindate = rs.getString("joindate"); // 날짜
					// 묶고(DTO)->담고(ArrayList)
					dto = new IdDTO("", id, "", pwd, platform, joindate);
					System.out.println("2" + dto.getWebid());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("실패");
			}
		}

		return dto;
	}

	//수정후 업데이트를 실질적으로 담당하는 함수
	public int idUpdate(IdDTO dto) {
		conn = getConnection();
		int cnt = -1;
		System.out.println("업데이트");
		if (dto.getWebid() != null) {
			System.out.println("웹 업데이트");
			String sql = "UPDATE web_id_tbl SET webid=?,pwd=?,platform=?,joindate=? WHERE webid=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getWebid());
				ps.setString(2, dto.getPwd());
				ps.setString(3, dto.getPlatform());
				ps.setString(4, dto.getJoindate());
				ps.setString(5, dto.getWebid());
				cnt = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dto.getSnsid() != null) {
			System.out.println("업데이트"+dto.getSnsid());
			String sql = "UPDATE sns_id_tbl SET snsid=?,pwd=?,platform=?,joindate=? WHERE snsid=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getSnsid());
				ps.setString(2, dto.getPwd());
				ps.setString(3, dto.getPlatform());
				ps.setString(4, dto.getJoindate());
				ps.setString(5, dto.getSnsid());
				cnt = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dto.getGameid() != null) {
			String sql = "UPDATE game_id_tbl SET gameid=?,pwd=?,platform=?,joindate=? WHERE gameid=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getGameid());
				ps.setString(2, dto.getPwd());
				ps.setString(3, dto.getPlatform());
				ps.setString(4, dto.getJoindate());
				ps.setString(5, dto.getGameid());
				cnt = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	//아이디 삭제 함수
	public int idDelete(IdDTO dto) {
		int cnt = -1;
		String sql = "";
		conn = getConnection();
		System.out.println("삭제");
		if (dto.getWebid() != null) {
			sql = "DELETE FROM web_id_tbl where webid=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getWebid());
				cnt = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		} else if (dto.getGameid() != null) {
			sql = "DELETE FROM game_id_tbl where gameid=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getGameid());
				cnt = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		} else if (dto.getSnsid() != null) {
			sql = "DELETE FROM sns_id_tbl where snsid=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getSnsid());
				cnt = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}

		return cnt;
	}

}
