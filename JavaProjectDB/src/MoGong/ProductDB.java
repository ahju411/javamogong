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
	
	
	
	// 추출한 상품 모든정보 DB에넣기
	public int insertitem(ArrayList<productdto> pl) {

		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			for(int p = 0 ; p<pl.size() ; p++) {
				String insertSQL = "INSERT INTO ITEM (ITEMID,ITEMNAME,PRICE,BRAND,CLASS)"
						+ "VALUES(?,?,?,?,?)";
				ps = conn.prepareStatement(insertSQL);	
			ps.setInt(1, pl.get(p).getItemid());
			ps.setString(2, pl.get(p).getItemname());
			ps.setString(3, pl.get(p).getItemprice());
			ps.setString(4, pl.get(p).getItembrand());
			ps.setString(5, pl.get(p).getItemclass());
			
				
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

}


