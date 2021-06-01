package MoGong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ProductDB {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@118.217.168.174:1521:xe";

	private static final String USER = "comet";
	private static final String PASS = "1234";

	/*
	 * static ArrayList<Integer> ITEMID = new ArrayList<Integer>(); static
	 * ArrayList<String> ITEMNAME = new ArrayList<String>(); static
	 * ArrayList<String> ITEMPRICE = new ArrayList<String>(); static
	 * ArrayList<String> ITEMBRAND = new ArrayList<String>(); static
	 * ArrayList<String> ITEMCLASS = new ArrayList<String>();
	 */
	static int i = 0;
	
	public ProductDB() {
		
	}

	/*
	 * public ProductDB() {
	 * 
	 * }
	 */
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
	public productdto getproduct(int id) {
		productdto pro = new productdto();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = getConnection();
			String sql = "select * from ITEM where ITEMID =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				pro.setItemid(rs.getInt("ITEMID"));
				pro.setItemname(rs.getString("ITEMNAME"));
				pro.setItemprice(rs.getString("PRICE"));
				pro.setItembrand(rs.getString("BRAND"));
				pro.setItemclass(rs.getString("CLASS"));
				pro.setItemimage(rs.getString("ITEMIMAGE"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	
	// 추출한 상품 모든정보 DB에넣기
	public int insertitem(ArrayList<productdto> pl) {

		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			for(int p = 0 ; p<pl.size() ; p++) {
				String insertSQL = "INSERT INTO ITEM (ITEMID,ITEMNAME,PRICE,BRAND,CLASS,ITEMIMAGE)"
						+ "VALUES(?,?,?,?,?,?)";
				ps = conn.prepareStatement(insertSQL);	
			ps.setInt(1, pl.get(p).getItemid());
			ps.setString(2, pl.get(p).getItemname());
			ps.setString(3, pl.get(p).getItemprice());
			ps.setString(4, pl.get(p).getItembrand());
			ps.setString(5, pl.get(p).getItemclass());
			ps.setString(6, pl.get(p).getItemimage());
			
				
			ps.executeUpdate();
				
			}
				
				return 1;
			
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return -1;
		
		
		
		
	} 
	public static void main(String[] args) {
		ProductDB pdb = new ProductDB();
		
		pdb.getConnection();
		
	}
	public List<productdto> getProductList() {
		List<productdto> list = new ArrayList<productdto>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String sql = "select * from item order by itemid asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				productdto pro = new productdto();
				pro.setItemid(rs.getInt("itemid"));
				pro.setItemname(rs.getString("itemname"));
				pro.setItemprice(rs.getString("price"));
				pro.setItembrand(rs.getString("brand"));
				pro.setItemclass(rs.getString("class"));
				pro.setItemimage(rs.getString("itemimage"));

				list.add(pro);

			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}



