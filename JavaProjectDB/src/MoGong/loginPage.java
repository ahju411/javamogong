package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class loginPage extends JFrame implements ActionListener {
	
	JButton btnlogin, btnSignUp, btnSearchID, btnSearchPW;
	JTextField tfID, tfPassword;
	JMenuItem jmiteam;

	public loginPage(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar jb = new JMenuBar();
		setJMenuBar(jb);
		
		JMenu infor = new JMenu("개발자 정보");
		jb.add(infor);
		
		jmiteam = new JMenuItem("팀원소개");
		jmiteam.addActionListener(this);
		infor.add(jmiteam);
		

		JPanel plMain = new JPanel();
		plMain.setBackground(Color.white);
		plMain.setLayout(new BorderLayout());
		add(plMain);
		
		JPanel northpan = new JPanel();
		northpan.setBackground(Color.white);
		add(northpan, BorderLayout.NORTH);
		
		ImageIcon imglogo = new ImageIcon("image\\logo.png");
		JLabel logo = new JLabel(imglogo);
		northpan.add(logo);
		
		//JPanel panLogInfo = new JPanel();
		
		
		JLabel lbllogin = new JLabel("Log in", JLabel.CENTER);
		lbllogin.setFont(new Font("", Font.ITALIC, 30));
		plMain.add(lbllogin, BorderLayout.NORTH);
		
		
		JPanel panInput = new JPanel();
		panInput.setBackground(Color.white);
		panInput.setBorder(new EmptyBorder(20, 0, 0, 80));
		panInput.setLayout(new GridLayout(2, 2, 20, 30));
		plMain.add(panInput);
		
		JLabel lblID = new JLabel("ID : ", JLabel.RIGHT);
		panInput.add(lblID, BorderLayout.WEST);
		
		tfID = new JTextField(20);
		panInput.add(tfID);
		
		JLabel lblPassword = new JLabel("Password : ", JLabel.RIGHT);
		panInput.add(lblPassword);
		
		tfPassword = new JPasswordField(20);

		panInput.add(tfPassword);
		
		
		JPanel plPassword = new JPanel();
		plPassword.setLayout(new BorderLayout());
		plMain.add(plPassword, BorderLayout.SOUTH);
		
		JPanel plPasswordWest = new JPanel();
		plPasswordWest.setBackground(Color.white);
		plPasswordWest.setBorder(new EmptyBorder(0, 10, 0, 0));
		plPassword.add(plPasswordWest, BorderLayout.WEST);
		
		JPanel plPasswordCenter = new JPanel();
		plPasswordCenter.setBackground(Color.white);
		plPassword.add(plPasswordCenter);
		
		
		JPanel pansouth = new JPanel();
		pansouth.setLayout(new GridLayout(3,1));
		pansouth.setBackground(Color.white);
		add(pansouth, BorderLayout.SOUTH);
		
		JPanel plLog = new JPanel();
		plLog.setBackground(Color.white);
		pansouth.add(plLog);
		
		ImageIcon iconLogin = new ImageIcon("image\\loginButton.png");
		
		btnlogin = new JButton(iconLogin);
		btnlogin.setPreferredSize(new Dimension(100, 45));
		btnlogin.setOpaque(true);
		btnlogin.setBackground(null);
		btnlogin.setBorderPainted(false);
		btnlogin.addActionListener(this);
		plLog.add(btnlogin);
		
		btnlogin.addActionListener(this);
		
		
		JPanel plSignUP = new JPanel();
		plSignUP.setBackground(Color.white);
		pansouth.add(plSignUP);
		
		
		ImageIcon iconSignUp = new ImageIcon("image\\signUpIcon.png");
		
		
		btnSignUp = new JButton("회원가입", iconSignUp);
		btnSignUp.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnSignUp.setForeground(Color.white);
		btnSignUp.setBackground(Color.gray);
		btnSignUp.setPreferredSize(new Dimension(150, 35));
		plSignUP.add(btnSignUp);
		
		btnSignUp.addActionListener(this);
		
		
		JPanel panSearch = new JPanel();
		panSearch.setBackground(Color.white);
		pansouth.add(panSearch);
		
		btnSearchID = new JButton("ID 찾기");
		btnSearchID.setFont(new Font("맑은 고딕", 0,10));
		btnSearchID.setForeground(Color.LIGHT_GRAY);
		btnSearchID.setBackground(null);
		btnSearchID.setPreferredSize(new Dimension(75, 22));
		panSearch.add(btnSearchID);
		btnSearchID.addActionListener(this);
		
		btnSearchPW = new JButton("PW 찾기");
		btnSearchPW.setFont(new Font("맑은 고딕", 0,10));
		btnSearchPW.setForeground(Color.LIGHT_GRAY);
		btnSearchPW.setBackground(null);
		btnSearchPW.setPreferredSize(new Dimension(75, 22));
		panSearch.add(btnSearchPW);
		btnSearchPW.addActionListener(this);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new loginPage("로그인 화면", 450, 500);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		

		
		if(obj == btnSignUp) {
			signUp su = new signUp("회원가입 창", 400, 600);
		}
		
		else if(obj == btnSearchID) {
			searchFrameID sfID = new searchFrameID("ID 찾기", 350, 400);
		}
		else if(obj == btnSearchPW) {
			searchFramePW sfPW = new searchFramePW("패스워드 찾기", 350, 400);
		}
		else if(obj == btnlogin) {
			loginMember();
		}
		
		
		//if(obj == jmiteam) {
		//	JOptionPane.showMessageDialog(null, "!", "2", ABORT);
		//}
		
		/*if(obj == jmiteam) {
			JOptionPane.showMessageDialog(null, "e", "getTitle()", JOptionPane.INFORMATION_MESSAGE);
		}*/
		
	}
	private void loginMember(){
		String id = tfID.getText();
		String pw = tfPassword.getText();
		MemberDB db = new MemberDB();
		int ok = db.loginMemeber(id, pw);
		
		if(ok == 1) {
			ProductList0527 pd = new ProductList0527("상품목록", 600, 825);
			dispose();
		}else {
			JOptionPane.showMessageDialog(this, "아이디나 비밀번호를 확인해보세요");
		}
	}

}
