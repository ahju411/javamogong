package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class signUp extends JFrame implements ActionListener {
	
	JTextField tfID, tfPassword, tfName, tfAge, tfAddress, tfPhone, tfMail;
	JButton btnSignUp;//

	public signUp(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		
	
		setLayout(new BorderLayout());
		
		
		JPanel leftpan = new JPanel();
		leftpan.setBackground(Color.white);
		leftpan.setBorder(new EmptyBorder(0, 30, 0, 30));
		leftpan.setLayout(new GridLayout(7, 1, 0 ,40));//같게 설정
		
		
		JPanel centerpan = new JPanel();
		centerpan.setBackground(Color.white);
		centerpan.setBorder(new EmptyBorder(0, 0, 0, 0));
		centerpan.setLayout(new GridLayout(7, 1, 0, 40));//같게 설정
		
		
		JPanel southpan = new JPanel();
		southpan.setBackground(Color.white);
		southpan.setBorder(new EmptyBorder(0, 0, 30, 0));
		southpan.setLayout(new FlowLayout());
		
		
		
		JPanel eastpan = new JPanel();
		eastpan.setBackground(Color.white);
		add(eastpan, BorderLayout.EAST);
		
		
		JPanel northpan = new JPanel();
		northpan.setBackground(Color.white);
		add(northpan, BorderLayout.NORTH);
		
		
		ImageIcon imglogo = new ImageIcon("image\\logo.png");
		JLabel logo = new JLabel(imglogo);
		northpan.add(logo, BorderLayout.NORTH);
		
		
		JLabel lblID = new JLabel("아이디 : ", JLabel.RIGHT);
		JLabel lblPassword = new JLabel("비밀번호 : ", JLabel.RIGHT);
		JLabel lblName = new JLabel("이름 : ", JLabel.RIGHT);
		JLabel lblAge = new JLabel("나이 : ", JLabel.RIGHT);
		JLabel lblAddress = new JLabel("주소 : ", JLabel.RIGHT);
		JLabel lblPhone = new JLabel("핸드폰 번호 : ", JLabel.RIGHT);
		JLabel lblMail = new JLabel("메일주소 : ", JLabel.RIGHT);
		
		tfID = new JTextField(15);
		tfPassword = new JTextField(15);
		tfName = new JTextField(15);
		tfAge = new JTextField(15);
		tfAddress = new JTextField(15);
		tfPhone = new JTextField(15);
		tfMail = new JTextField(15);
		
		ImageIcon iconSignUp = new ImageIcon("image\\signUpIcon.png");
		
		btnSignUp = new JButton("가입하기", iconSignUp);
		btnSignUp.setBackground(Color.gray);
		btnSignUp.setForeground(Color.white);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setFont(new Font("맑은 고딕", width, 20));
		btnSignUp.addActionListener(this);
		
		add(leftpan, BorderLayout.WEST);
		leftpan.add(lblID);
		leftpan.add(lblPassword);
		leftpan.add(lblName);
		leftpan.add(lblAge);
		leftpan.add(lblAddress);
		leftpan.add(lblPhone);
		leftpan.add(lblMail);
		
		
		add(centerpan);
		centerpan.add(tfID);
		centerpan.add(tfPassword);
		centerpan.add(tfName);
		centerpan.add(tfAge);
		centerpan.add(tfAddress);
		centerpan.add(tfPhone);
		centerpan.add(tfMail);
		
		add(southpan, BorderLayout.SOUTH);
		southpan.add(btnSignUp);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btnSignUp) {
			//DB로 보내고 창 닫기
			dispose();
		}
		
		
	}


}
