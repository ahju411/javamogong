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

	static ArrayList<Integer> ITEMID = new ArrayList<Integer>();
	static ArrayList<String> ITEMNAME = new ArrayList<String>();
	static ArrayList<String> ITEMPRICE = new ArrayList<String>();
	static ArrayList<String> ITEMBRAND = new ArrayList<String>();
	static ArrayList<String> ITEMCLASS = new ArrayList<String>();
	
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
	
	public int productcrawling(ArrayList<productdto> pl) throws IOException {
		
		// 1. 구찌시계 크롤링  사이트 : 옥션
					String url = "http://browse.auction.co.kr/search?keyword=%EA%B5%AC%EC%B0%8C%EC%8B%9C%EA%B3%84";
					Document doc = null;
					Elements tmp;
				
					try {
						doc = Jsoup.connect(url).get();
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					//
					// 상위 7개정보 추출하여 DB에 넣기
					
					Elements element = doc.select("div[class=\"section--inner_content_body\"]");
					
					for(int i = 0 ; i <7;i++) {
						ITEMID.add(i);
						tmp = element.select("span.text--title"); // 상품이름
						ITEMNAME.add(tmp.get(i).text());
						
						tmp = element.select("strong.text--price_seller"); //상품가격
						ITEMPRICE.add(tmp.get(i).text());
						
						tmp = element.select("span.text--brand"); //상품브랜드
						ITEMBRAND.add(tmp.get(i).text());
						
						tmp = element.select("span.text--brand"); //상품종류
						ITEMBRAND.add(tmp.get(i).text());
						
						ITEMCLASS.add("시계");
						

					System.out.println(ITEMNAME + " " + ITEMPRICE + " " + ITEMBRAND + " " + ITEMCLASS);
				
					}
					return 0;
	}
	

	// 추출한 상품 모든정보 DB에넣기
	public int insertitem(productdto dto) {
		
		String insertSQL = "INSERT INTO ITEM (ITEMID, ITEMNAME, PRICE,BRAND,CLASS)"
				+ "VALUES(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			for(int p = 0 ; p<7 ; p++) {
				ps = conn.prepareStatement(insertSQL);	
			ps.setInt(1, ITEMID.get(p+1));
			ps.setString(2, ITEMNAME.get(p));
			ps.setString(3, ITEMPRICE.get(p));
			ps.setString(4, ITEMBRAND.get(p));
			ps.setString(5, ITEMCLASS.get(p));
				
				
				int r =ps.executeUpdate();
				if(r>0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
				return 1;
			}
			
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


