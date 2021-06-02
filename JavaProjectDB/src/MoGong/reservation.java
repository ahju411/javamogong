package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class reservation extends JFrame {

	loginPage login;
	
	public reservation(String title, int width, int height, loginPage log) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//맨 뒤에 붙는 흰색 팬
		JPanel panBack = new JPanel();
		panBack.setBackground(Color.pink);
		panBack.setLayout(new BorderLayout());
		add(panBack);

		JLabel lblreser = new JLabel("예약현황", JLabel.CENTER);
		lblreser.setFont(new Font(title, 0, 40));
		panBack.add(lblreser, BorderLayout.NORTH);
		
		
		JPanel panTable = new JPanel();
		panBack.add(panTable);
		
		String header[] = {"상품 이름", "가격"};
		
		String contents[][] = {
			{"구찌 시계", "7500000" + "원"},
			{"22", "22"}
		};
		
		
		JTable jtable = new JTable(contents, header);
		jtable.setSize(100, 100);
		panTable.add(jtable);
		
		
		
		JScrollPane jp = new JScrollPane(jtable);
		panBack.add(jp);
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@118.217.168.174:1521:xe", "comet", "1234");
			
			Statement stmt = conn.createStatement();
			
			//String logid = loginPage.getid();
			
			
			//ResultSet rs = stmt.executeQuery("SELECT itemname FROM order WHERE id = '" + logid + "'");
			//ResultSet rs = stmt.executeQuery("SELECT itemname FROM order WHERE id = 'xogus'");
			ResultSet rs = stmt.executeQuery("SELECT * FROM order");
			
			/*if(rs.next()) {
				
				String id = rs.getString("itmeid");
				System.out.println(id);
				//ResultSet rs = stmt.executeQuery("INSERT into table itemname FROM order WHERE id = 'xogus'");
			}*/
			
			
			conn.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC드라이버 로드 에러");
			e1.printStackTrace();
		} catch (SQLException e1) {
			System.err.println("DB연결 오류 또는 쿼리 오류 입니다.");
			e1.printStackTrace();
		}
		
		
		
		
		setVisible(true);
	}
	
	/*public static void main(String[] args) {
		new reservation("예약현황", 500, 600);
		
	}*/

	

}
