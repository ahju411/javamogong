package MoGong;

//dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MemberDB {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@118.217.168.174:1521:xe";

	private static final String USER = "comet";
	private static final String PASS = "1234";
	Member_List mList;

	public MemberDB() {

	}

	public MemberDB(Member_List mList) {
		this.mList = mList;
		System.out.println("ConnectDB " + mList);

	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC에러");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결 에러");
			e.printStackTrace();
		}
		return conn;
	}

//한사람의 회원정보 메소드
	public Member getMember(String id) {
		Member mem = new Member();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = getConnection();
			String sql = "select * from customer where id =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				mem.setId(rs.getString("id"));
				mem.setPw(rs.getString("pw"));
				mem.setAge(rs.getInt("Age"));
				mem.setName(rs.getString("Name"));
				mem.setAddr(rs.getString("Addr"));
				mem.setTel(rs.getString("Tel"));
				mem.setEmail(rs.getString("Email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

//멤버출력
	public List<Member> getMemberList() {
		List<Member> list = new ArrayList<Member>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String sql = "select * from customer";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Member mem = new Member();
				mem.setId(rs.getString("id"));
				mem.setPw(rs.getString("pw"));
				mem.setAge(rs.getInt("Age"));
				mem.setName(rs.getString("Name"));
				mem.setAddr(rs.getString("Addr"));
				mem.setTel(rs.getString("Tel"));
				mem.setEmail(rs.getString("Email"));
				list.add(mem);

			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 회원 등록
	public int insertMem(Member mem) {

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String sql = "insert into comet.customer" + "(id,pw,name,email,addr,tel,age)" + "values(?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, mem.getId());
			ps.setString(2, mem.getPw());
			ps.setString(3, mem.getName());
			ps.setString(4, mem.getEmail());
			ps.setString(5, mem.getAddr());
			ps.setString(6, mem.getTel());
			ps.setInt(7, mem.getAge());

			int r = ps.executeUpdate();

			if (r > 0) {
				System.out.println("가입성공");
			} else {
				System.out.println("가입실패");
			}
			return 1;

		} catch (SQLException e) {
			e.getStackTrace();
		}
		return -1;
	}

	// 로그인 하기
	public int loginMemeber(String id, String pw) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pass = "";
		int x = -1;

		try {
			conn = getConnection();
			String sql = "select pw from comet.customer" + " where id=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, id);

			rs = ps.executeQuery();
			if(id.equals("admin")) {
				if(rs.next()) {
					pass = rs.getString("pw");
					if(pass.equals(pw)) {
						
						x=2;
					}
				}
			}

			else {
				
				if (rs.next()) {
					pass = rs.getString("pw");
					if (pass.equals(pw))
						x = 1;
					else {
						x = 0;
					}
					
				} else {
					x = -1;
				}
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}
		return x;
	}

	// 아이디 중복확인
	public boolean confrimid(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean ok = true;
		try {
			conn = getConnection();
			String sql = "select * from comet.customer" + " where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {

				System.out.println("아이디 존재");
				ok = false;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return ok;
	}

//회원정보 수정하지
	public int updateMember(Member vMem) {
		System.out.println("data" + vMem.toString());
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String sql = "update comet.customer set name=?,email=?,addr=?,tel=?,age=?" + "where id=? and pw=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, vMem.getName());
			ps.setString(2, vMem.getEmail());
			ps.setString(3, vMem.getAddr());
			ps.setString(4, vMem.getTel());
			ps.setInt(5, vMem.getAge());
			ps.setString(6, vMem.getId());
			ps.setString(7, vMem.getPw());

			int r = ps.executeUpdate();

			if (r > 0)
				System.out.println("수정성공");

			return 1;

		} catch (SQLException e) {
			e.getStackTrace();
		}
		return -1;
	}

	public boolean deleteMember(String id, String pw) {
		boolean ok = false;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			String sql = "delete from customer where id=? and pw=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			int r = ps.executeUpdate();

			if (r > 0) {
				ok = true;
			}
		} catch (SQLException e) {
			System.out.println(3 + "오류");
		}
		return ok;
	}

	public static void main(String[] args) {
		MemberDB mb = new MemberDB();
		mb.getConnection();
		mb.getMemberList();
	}

}
