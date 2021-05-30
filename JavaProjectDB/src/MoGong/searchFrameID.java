package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
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
		
		ImageIcon imglogo = new ImageIcon("image\\logo.png");
		JLabel logo = new JLabel(imglogo);
		panNorth.add(logo);
		
		
		JPanel panMid = new JPanel();
		panMid.setBackground(Color.white);
		panMid.setBorder(new EmptyBorder(70, 0, 40, 10));
		panMid.setLayout(new GridLayout(2, 2, 10, 30));
		add(panMid);
		
		JLabel lblName = new JLabel("이름 : ", JLabel.RIGHT);
		panMid.add(lblName);
		
		tfName = new JTextField("유은철");//15로 수정할것
		panMid.add(tfName);
		
		JLabel lblPhone = new JLabel("핸드폰 번호 : ", JLabel.RIGHT);
		panMid.add(lblPhone);
		
		tfPhone1 = new JTextField("010");//3
		tfPhone2 = new JTextField("1234");//4
		tfPhone3 = new JTextField("5678");//4
		
		JPanel panPhone = new JPanel();
		panPhone.setBackground(Color.white);
		
		JLabel lblPhone1 = new JLabel("-");
		JLabel lblPhone2 = new JLabel("-");
		
		
		panPhone.add(tfPhone1);
		panPhone.add(lblPhone1);
		panPhone.add(tfPhone2);
		panPhone.add(lblPhone2);
		panPhone.add(tfPhone3);
		
		panMid.add(panPhone);
		
		
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
		
		try {
			//오라클 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//오라클 드라이버 매니저 연결
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@118.217.168.174:1521:xe", "comet", "1234");
			
			Statement stmt = conn.createStatement();
			
			
			//데이터 검색
			String findName = tfName.getText();
			String findPhone = tfPhone1.getText() + "-" + tfPhone2.getText() + "-" + tfPhone3.getText();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer where name = '" + findName + "'");
			
			System.out.println("밑줄이 오류");
			
			if(rs.next()) {
				id = rs.getString("id");
			}
			
			
			System.out.println("OK");
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
