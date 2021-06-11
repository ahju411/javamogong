package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class searchFrameID extends JFrame implements ActionListener {

	JTextField tfName, tfPhone1, tfPhone2, tfPhone3;
	JButton btn;
	
	String id;
	
	public searchFrameID(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		
		JPanel panNorth = new JPanel();
		panNorth.setBackground(Color.white);
		add(panNorth, BorderLayout.NORTH);
		
		//맨위 로고
		ImageIcon imglogo = new ImageIcon("image\\logo.png");
		JLabel logo = new JLabel(imglogo);
		panNorth.add(logo);
		
		//이름과 핸드폰 번호 입력받는 부분
		JPanel panMid = new JPanel();
		panMid.setBackground(Color.white);
		panMid.setBorder(new EmptyBorder(70, 0, 40, 10));
		panMid.setLayout(new GridLayout(2, 2, 10, 30));
		add(panMid);
		
		JLabel lblName = new JLabel("이름 : ", JLabel.RIGHT);
		panMid.add(lblName);
		
		tfName = new JTextField(15);
		panMid.add(tfName);
		
		JLabel lblPhone = new JLabel("핸드폰 번호 : ", JLabel.RIGHT);
		panMid.add(lblPhone);
		
		tfPhone1 = new JTextField(3);
		tfPhone2 = new JTextField(4);
		tfPhone3 = new JTextField(4);
		
		JPanel panPhone = new JPanel();
		panPhone.setBackground(Color.white);
		panPhone.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel lblPhone1 = new JLabel("-");
		JLabel lblPhone2 = new JLabel("-");

		panPhone.add(tfPhone1);
		panPhone.add(lblPhone1);
		panPhone.add(tfPhone2);
		panPhone.add(lblPhone2);
		panPhone.add(tfPhone3);
		
		panMid.add(panPhone);
		
		//버튼 붙는 패널
		JPanel panSouth = new JPanel();
		panSouth.setBackground(Color.white);
		add(panSouth, BorderLayout.SOUTH);
		
		btn = new JButton("완료");
		btn.addActionListener(this);
		panSouth.add(btn);
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		//DB파트
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@118.217.168.174:1521:xe", "comet", "1234");
			
			Statement stmt = conn.createStatement();
			
			String findName = tfName.getText();
			String findPhone = tfPhone1.getText() + "-" + tfPhone2.getText() + "-" + tfPhone3.getText();

			//이름과 전화번호로 customer 테이블에서 id를 가져오는 쿼리 
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer where name = '" + findName + "' and tel = '" + findPhone + "'");
			
			if(rs.next()) {
				id = rs.getString("id");
			}
			
			conn.close();
		} catch (ClassNotFoundException e1) {
			System.out.println("JDBC드라이버 로드 에러");
			e1.printStackTrace();
		} catch (SQLException e1) {
			System.err.println("DB연결 오류 또는 쿼리 오류 입니다.");
			e1.printStackTrace();
		}
		
		if(obj == btn) {
			JOptionPane.showInternalMessageDialog(null, id, "아이디 입니다", 1);
			dispose();
		}
		
		
	}

}
