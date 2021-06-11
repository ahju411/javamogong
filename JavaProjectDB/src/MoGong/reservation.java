package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class reservation extends JFrame implements ActionListener {

	JButton btnBack;
	
	public reservation(String title, String Id) {
		setTitle(title);
		setSize(700, 500);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//맨 뒤에 붙는 분홍 팬
		JPanel panBack = new JPanel();
		panBack.setBackground(Color.pink);
		panBack.setLayout(new BorderLayout());
		add(panBack);
		
		//맨위에 붙는 분홍 예약현황 레이블
		JLabel lblreser = new JLabel("예약현황", JLabel.CENTER);
		lblreser.setFont(new Font(title, 0, 40));
		panBack.add(lblreser, BorderLayout.NORTH);
		
		//그 밑에 붙는 테이블
		JPanel panTable = new JPanel();
		panTable.setLayout(new BorderLayout());
		panTable.setBackground(Color.white);
		panBack.add(panTable);
		
		//맨 밑 뒤로가기 버튼
		btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(this);
		panBack.add(btnBack, BorderLayout.SOUTH);
		
		//테이블 첫행
		String header[] = {"수취인", "상품 이름", "가격","주소", "핸드폰 번호", "구매 여부"};
		
		String contents[][] = {};
		
		//테이블 생성
		DefaultTableModel jtable = new DefaultTableModel(contents, header);
		
		JTable table = new JTable(jtable);
		panTable.add(table);
		
		JScrollPane jp = new JScrollPane(table);
		panBack.add(jp);
		
		//DB연동
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@118.217.168.174:1521:xe", "comet", "1234");
			
			Statement stmt = conn.createStatement();
			String id = Id;
			//쿼리문 이름, 가격, 구매상태가 표시됨
			ResultSet rs = stmt.executeQuery("SELECT orders.name, item.ITEMNAME, item.PRICE, orders.address, orders.phone, orders.state from item, ORDERS WHERE ORDERS.ITEMID = ITEM.ITEMID and id = '" + id + "'");
			//SELECT orders.NAME, item.ITEMNAME, item.PRICE, orders.ADDRESS, orders.PHONE, orders.STATE from item, ORDERS WHERE ORDERS.ITEMID = ITEM.ITEMID;
			
			//테이블에 행 삽입
			while(rs.next()) {
				String name1 = rs.getString("name");
				String id1 = rs.getString("itemname");
				String price = rs.getString("price");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String state = "예약완료";
				
				if(rs.getInt("state") == 0) {
					state = "예약완료";
				}else if(rs.getInt("state") == 1) {
					state = "구매완료/배송중";
				}else if(rs.getInt("state") == 2) {
					state = "구매취소";
				}
					
				
				String[] col = {name1, id1, price, address, phone, state};
				
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

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		
		if(obj == btnBack) {
			dispose();
		}
		
	}

}
