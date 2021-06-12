package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class reservation extends JFrame implements ActionListener, MouseListener {

	JButton btnBack;
	private JTable table;
    private	int itemid;
	private String id;
	private JScrollPane jp;
	public reservation(String title, String Id) {
		
		resUI(Id);
	}
	private void resUI(String Id) {
		setTitle("예약현황");
		setSize(700, 500);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.id =Id;
		

		//맨 뒤에 붙는 분홍 팬
		JPanel panBack = new JPanel();
		panBack.setBackground(Color.BLACK);
		panBack.setLayout(new BorderLayout());
		add(panBack);
		
		//맨위에 붙는 분홍 예약현황 레이블
		JLabel lblreser = new JLabel("예약현황", JLabel.CENTER);
		lblreser.setForeground(Color.WHITE);
		lblreser.setFont(new Font("맑은 고딕",Font.BOLD,40));
		panBack.add(lblreser, BorderLayout.NORTH);
		
		//그 밑에 붙는 테이블
		JPanel panTable = new JPanel();
		panTable.setLayout(new BorderLayout());
		panTable.setBackground(Color.white);
		panBack.add(panTable);
		
		//맨 밑 뒤로가기 버튼
		btnBack = new JButton("뒤로가기");
		btnBack.setForeground(Color.WHITE);
		btnBack.setOpaque(false);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.addActionListener(this);
		btnBack.addActionListener(this);
		panBack.add(btnBack, BorderLayout.SOUTH);
		
		//테이블 첫행
		String header[] = {"수취인", "상품 이름", "가격","주소", "핸드폰 번호", "구매 여부","상품아이디"};
		
		String contents[][] = {};
		
		//테이블 생성
		DefaultTableModel jtable = new DefaultTableModel(contents, header) { // 내용수정금지
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		
		table = new JTable(jtable);
		table.addMouseListener(this);
		JTableHeader Jheader = table.getTableHeader(); // 헤더부분 배경 설정
		Jheader.setBackground(Color.white); // 헤더부분 배경설정
		panTable.add(table);
		
		jp = new JScrollPane(table);
		jp.addMouseListener(this);
		
		panBack.add(jp);
		
		//DB연동
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@118.217.168.174:1521:xe", "comet", "1234");
			
			Statement stmt = conn.createStatement();
			String id = Id;
			//쿼리문 이름, 가격, 구매상태가 표시됨
			ResultSet rs = stmt.executeQuery("SELECT orders.name, item.ITEMNAME, item.PRICE, orders.address, orders.phone, orders.state,item.itemid from item, ORDERS WHERE ORDERS.ITEMID = ITEM.ITEMID and id = '" + id + "'");
			
			//테이블에 행 삽입
			while(rs.next()) {
				String name1 = rs.getString("name");
				String id1 = rs.getString("itemname");
				String price = rs.getString("price");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String state = "예약완료";
			 itemid = rs.getInt("itemid");
				
				if(rs.getInt("state") == 1) {
					state = "예약완료";
				}else if(rs.getInt("state") == 2) {
					state = "구매완료/배송중";
				}
					
				
				Object[] col = {name1, id1, price, address, phone, state,itemid};
				
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
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int row = table.getSelectedRow();
			
			String tmp =  String.valueOf(table.getValueAt(row, 6));
           int tmp2 = Integer.parseInt(tmp)-1;
			System.out.println(itemid);
			try {
				productInfo pby = new productInfo("상품정보화면/" + id, 650, 800, tmp2, id);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
