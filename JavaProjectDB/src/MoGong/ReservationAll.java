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

public class ReservationAll extends JFrame implements ActionListener {

	JButton btnBack;
	
	public ReservationAll(String title) {
		setTitle(title);
		setSize(700, 500);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		//맨 뒤에 붙는 분홍 팬
		JPanel panBack = new JPanel();
		panBack.setBackground(Color.decode("#AAF0D1"));
		panBack.setLayout(new BorderLayout());
		add(panBack);
		
		//맨위에 붙는 분홍 예약현황 레이블
		JLabel lblreser = new JLabel("총예약현황", JLabel.CENTER);
		lblreser.setFont(new Font("맑은 고딕",Font.BOLD,40));
		panBack.add(lblreser, BorderLayout.NORTH);
		
		//그 밑에 붙는 테이블
		JPanel panTable = new JPanel();
		panTable.setLayout(new BorderLayout());
		panTable.setBackground(Color.white);
		panBack.add(panTable);
		
		//맨 밑 뒤로가기 버튼
		btnBack = new JButton("뒤로가기");
		btnBack.setOpaque(false);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
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
			//쿼리문 이름, 가격, 구매상태가 표시됨
			ResultSet rs = stmt.executeQuery("select c.name,i.itemname,i.price,o.address,o.phone,o.state "
					+ "from customer c,orders o,item i "
					+ "where c.id=o.id and i.itemid=o.itemid "
					+ "order by c.id");
					
			
			//테이블에 행 삽입
			while(rs.next()) {
				String name1 = rs.getString("name");
				String id1 = rs.getString("itemname");
				String price = rs.getString("price");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String state = "예약완료";
				
				if(rs.getInt("state") == 1) {
					state = "예약완료";
				}else if(rs.getInt("state") == 2) {
					state = "구매완료/배송중";
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
	public static void main(String[] args) {
		new ReservationAll("총예약현황");
	}
	
		

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		
		if(obj == btnBack) {
			dispose();
		}
		
	}

}
