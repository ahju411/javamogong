package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.border.EmptyBorder;


public class loginPage extends JFrame implements ActionListener, KeyListener {
	
	JButton btnlogin, btnSignUp, btnSearchID, btnSearchPW;
	JTextField tfID, tfPassword;
	
	public String logid ="";
	
	public loginPage() {
		setTitle("로그인 화면");
		setSize(450, 500);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//메뉴 부분
		
		
		
		//맨 뒤 중앙에 붙는 패널
		JPanel plMain = new JPanel();
		plMain.setBackground(Color.white);
		plMain.setLayout(new BorderLayout());
		add(plMain);
		
		//맨위에 로고와 함께 붙는 패널
		JPanel northpan = new JPanel();
		northpan.setBackground(Color.white);
		add(northpan, BorderLayout.NORTH);
		
		//모공 로고 표시
		ImageIcon imglogo = new ImageIcon("image\\logo2.png");
		JLabel logo = new JLabel(imglogo);
		northpan.add(logo);
		
		//로고 밑login 표시
		
		JLabel emptylbl = new JLabel(" ", JLabel.CENTER);
		emptylbl.setFont(new Font("Bradley Hand ITC", Font.ITALIC, 30));
		plMain.add(emptylbl, BorderLayout.NORTH);
		
		//아이디 비밀번호 입력받을 패널
		JPanel panInput = new JPanel();
		panInput.setBackground(Color.white);
		panInput.setBorder(new EmptyBorder(20, 0, 0, 80));
		panInput.setLayout(new GridLayout(2, 2, 20, 30));
		plMain.add(panInput);
		
		//아이디 비밀번호 입력
		JLabel lblID = new JLabel("ID : ", JLabel.RIGHT);
		panInput.add(lblID, BorderLayout.WEST);
		
		tfID = new JTextField(20);
		panInput.add(tfID);
		
		JLabel lblPassword = new JLabel("Password : ", JLabel.RIGHT);
		panInput.add(lblPassword);
		
		tfPassword = new JPasswordField(20);
		tfPassword.addKeyListener(this);

		panInput.add(tfPassword);
		
		//맨 밑에서 로그인 회원가입 ID/PW찾기 버튼이 존재하는 패널
		JPanel pansouth = new JPanel();
		pansouth.setLayout(new GridLayout(3,1));
		pansouth.setBackground(Color.white);
		add(pansouth, BorderLayout.SOUTH);
		
		//로그인 버튼이 있는 패널
		JPanel plLog = new JPanel();
		plLog.setBackground(Color.white);
		pansouth.add(plLog);
		
		ImageIcon iconLogin = new ImageIcon("image\\loginButton1.png");
		
		btnlogin = new JButton(iconLogin);
		btnlogin.setPreferredSize(new Dimension(200, 45));
		btnlogin.setOpaque(true);
		btnlogin.setBackground(null);
		btnlogin.setBorderPainted(false);
		btnlogin.setFocusPainted(false);
		plLog.add(btnlogin);
		
		btnlogin.addActionListener(this);
		btnlogin.addKeyListener(this);
		
		//회원가입 패널
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
		
		//ID/PW찾는 패널
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
		new loginPage();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		

		
		if(obj == btnSignUp) {
			signUp su = new signUp();
			su.signUp();
		}
		
		else if(obj == btnSearchID) {
			searchFrameID sfID = new searchFrameID("ID 찾기", 380, 420);
		}
		else if(obj == btnSearchPW) {
			searchFramePW sfPW = new searchFramePW("패스워드 찾기", 380, 420);
		}
		else if(obj == btnlogin) {
			loginMember();
			
		}

	}
	private void loginMember(){
		String id = tfID.getText();
		String pw = tfPassword.getText();
		MemberDB db = new MemberDB();
		int ok = db.loginMemeber(id, pw);
		
		if(ok == 1) {
			mainFrame pd = new mainFrame("상품목록", 700, 825,this,id);
			pd.setTitle("상품목록"+"/"+id);
			dispose();
		}else if(ok == 2){
			Member_List mem = new Member_List("회원관리창", 700, 500);
			dispose();
		}
		
		else {
			JOptionPane.showMessageDialog(this, "아이디나 비밀번호를 확인해보세요");
		}
	}
	
	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key==KeyEvent.VK_ENTER) {
			btnlogin.doClick();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
