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
		
		try {
		URL	url = new URL("https://search.shopping.naver.com/search/all?query=%EA%B5%AC%EC%B0%8C&cat_id=&frm=NVSHATC");
			Document doc = Jsoup.connect("https://search.shopping.naver.com/search/all?query=%EA%B5%AC%EC%B0%8C&cat_id=&frm=NVSHATC")
					.get();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer sourceCode = new StringBuffer();
		
		
		String sourceLine = "";
		while ((sourceLine = br.readLine()) != null) {
			sourceCode.append(sourceLine + "\n");
		}

		// 상품이름및 아이디 변수저장
		Elements elem = doc.select("div[class=\"style_inner__18zZX\"]");

		// 상품이름및 아이디 변수저장
		for (Element e : elem.select("a")) {
			if (e.className().equals("basicList_link__1MaTN")) {

				ITEMID.add(i);
				ITEMNAME.add(e.text());
				i++;

			}

			else
				continue;
		}

		int i = 0;

		for (Element e : elem.select("span")) {
			if (e.className().equals("price_num__2WUXn")) {

				ITEMPRICE.add(e.text());
				i++;
			}

			else
				continue;
		}
		
		}
		
		
		
		catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		
		return 1;
	}
	

	// 추출한 상품 모든정보 DB에넣기
	public int insertitem(productdto dto) {
		
		String insertSQL = "INSERT INTO ITEMTEST (ITEMID, ITEMNAME, PRICE)" + "VALUES(?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			for (int p = 0; p < 5; p++) {
				ps = conn.prepareStatement(insertSQL);
				
				/*
				 * ps.setInt(1, ITEMID.get(p+1)); ps.setString(2, ITEMNAME.get(p));
				 * ps.setString(3, ITEMPRICE.get(p));
				 */
				ps.setInt(1,dto.getItemid());
				ps.setString(2, dto.getItemname());
				ps.setString(3, dto.getItemprice());
				
				
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


