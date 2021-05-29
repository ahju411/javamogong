package MoGong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class ProductDB_0529 {

	  static ArrayList<Integer> ITEMID = new ArrayList<Integer>();
	    static ArrayList<String> ITEMNAME = new ArrayList<String>();
	    static ArrayList<String> ITEMPRICE = new ArrayList<String>();
	    static  ArrayList<String> ITEMCLASS = new ArrayList<String>();
	    static int  i = 0;

	public static void main(String[] args) throws SQLException, IOException {
		
		
		String name;
		
		try {
			//1.  오라클 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 드라이버 매니저 연결
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@118.217.168.174:1521:xe",
					"comet", "1234");
			
			Statement stmt = conn.createStatement();
			
			PreparedStatement ps = null;
			
	// 크롤링 해보즈아아
		URL url = new URL("https://search.shopping.naver.com/search/all?query=%EA%B5%AC%EC%B0%8C&cat_id=&frm=NVSHATC");

		Document doc = Jsoup.connect("https://search.shopping.naver.com/search/all?query=%EA%B5%AC%EC%B0%8C&cat_id=&frm=NVSHATC").get();
		
		
	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	StringBuffer sourceCode = new StringBuffer();
	
	String sourceLine = "";
	while((sourceLine=br.readLine()) != null) {
		 sourceCode.append(sourceLine+"\n");
	}
		
	// 상품이름및 아이디 변수저장
	Elements elem = doc.select("div[class=\"style_inner__18zZX\"]");
	
		
	// 상품이름및 아이디 변수저장
	for(Element e: elem.select("a") ) {
		if(e.className().equals("basicList_link__1MaTN") ) {
               
		  ITEMID.add(i);
			ITEMNAME.add(e.text());
			i++;
			
		}

		else
			continue;
	}
	
	int i =0;
	
	for(Element e: elem.select("span") ) {
		if(e.className().equals("price_num__2WUXn") ) {
               
		  ITEMPRICE.add(e.text());
			i++;
		}

		else
			continue;
	}
		
	
	
	
	// 추출한 상품 모든정보 DB에넣기
	
	String insertSQL = "INSERT INTO PRODUCTTYPE (ITEMID, ITEMNAME, PRICE)"
			+ "VALUES(?,?,?)";

	for(int p = 0 ; p<5 ; p++) {
	ps = conn.prepareStatement(insertSQL);
	ps.setInt(1, ITEMID.get(p));
	ps.setString(2, ITEMNAME.get(p));
	ps.setString(3, ITEMPRICE.get(p));
	ps.executeUpdate();
	}
	
	

					
			
			
		
			
		
		
		
		
		
		// 데이터검색
					//String findId = JOptionPane.showInputDialog("찾고싶은 ID");
					// ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER WHERE id = '" + findId + "'");
					ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCTTYPE");
					System.out.println("-----------------------------------");
					
					while(rs.next()) {

						 name = rs.getString("name");
						
						System.out.println(name);
					}
					
					System.out.println("-----------------------------------");
					
					
					
					System.out.println("OK!");
					conn.close();
					
				} catch (ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 에러");
				e.printStackTrace();
				} catch (SQLException e) {
					System.err.println("DB 연결 오류 또는 쿼리 오류 입니다");
					e.printStackTrace();
				} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}

}

