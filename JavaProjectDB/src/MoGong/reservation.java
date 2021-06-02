package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class reservation extends JFrame {

	public reservation(String title, int width, int height, String Id) {
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
		};
		
		DefaultTableModel jtable = new DefaultTableModel(contents, header);
		
		JTable table = new JTable(jtable);
		panTable.add(table);
		
		JScrollPane jp = new JScrollPane(table);
		panBack.add(jp);
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@118.217.168.174:1521:xe", "comet", "1234");
			
			Statement stmt = conn.createStatement();
			
			String id = Id;
			
			ResultSet rs = stmt.executeQuery("SELECT itemname, price FROM item WHERE itemid in (SELECT itemid FROM orders where id = '" + id + "')");
			
			while(rs.next()) {
				
				String id1 = rs.getString("itemname");
				String price = rs.getString("price");
				
				String[] col = {id1, price};
				
				jtable.addRow(col);
				
			}
			
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
