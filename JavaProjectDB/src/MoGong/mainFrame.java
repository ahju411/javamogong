package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class mainFrame extends JFrame implements ActionListener {

	private JScrollPane scrollpane;

	private JMenu menuUser;
	private JMenuItem MyInfo,Reservation,Logout;
	loginPage loginPage;

	private JMenuBar menubar;
	private ImageIcon img;
	private JLabel lblimg;
	String id;
	private JButton gucciwatch,gucciwallet,guccibag,guccinecklace;
	private JButton chanelwatch,chanelwallet,chanelbag,chanelnecklace;
	private JButton hermeswatch,hermeswallet,hermesbag,hermesnecklace;
	private JButton diorwatch,diorwallet,diorbag,diornecklace;

	private EtchedBorder eborder;
	
	public mainFrame(String title , int width , int height, loginPage loginPage,String id) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.loginPage =loginPage;
		this.id = id;
		
		//메뉴 설정
		menubar = new JMenuBar();
		menubar.setBackground(Color.black);
	
		menuUser = new JMenu("My");
		menuUser.setBackground(Color.black);
		menuUser.setForeground(Color.white);
		MyInfo = new JMenuItem("나의 정보");
		MyInfo.setBackground(Color.black);
		MyInfo.setForeground(Color.white);
		MyInfo.addActionListener(this);
		
		Reservation = new JMenuItem("예약현황");
		Reservation.setBackground(Color.black);
		Reservation.setForeground(Color.white);
		Reservation.addActionListener(this);
		
		Logout = new JMenuItem("로그아웃");
		Logout.setBackground(Color.black);
		Logout.setForeground(Color.white);
		Logout.addActionListener(this);
	
		menuUser.add(MyInfo);
		menuUser.add(Reservation);
		menuUser.add(Logout);
	
		menubar.add(menuUser);
		setJMenuBar(menubar);	
		
		// 배경패널 설정
		JPanel backpan = new JPanel();
		
		backpan.setLayout(new GridLayout(4,1));
		backpan.setBackground(Color.white);;
		
		// 구찌브랜드
		JPanel pan1 = new JPanel();
		pan1.setBackground(Color.white);
		JPanel pan1_1 = new JPanel();
		pan1_1.setBackground(Color.white);
		JPanel pan1_2 = new JPanel();
		pan1_2.setBackground(Color.white);
		pan1_2.setLayout(new GridLayout(4,1));
		eborder = new EtchedBorder(EtchedBorder.LOWERED);
		
		img = new ImageIcon("image/brandgucci.png");
		img = imageSetSize(img, 450, 200);
		lblimg = new JLabel(img);
		lblimg.setBorder(eborder);
		pan1_1.add(lblimg);
		
		
		img  = new ImageIcon("image/watch.png");
		img = imageSetSize(img, 140, 47);
		gucciwatch = new JButton(img);
		gucciwatch.addActionListener(this);
		gucciwatch.setPreferredSize(new Dimension(100, 45));
		gucciwatch.setOpaque(true);
		gucciwatch.setBackground(null);
		gucciwatch.setBorderPainted(false);
		gucciwatch.setBorder(eborder);
		pan1_2.add(gucciwatch);
		
		img = new ImageIcon("image/wallet.png");
		img = imageSetSize(img, 140, 47);
		gucciwallet = new JButton(img);
		gucciwallet.addActionListener(this);
		gucciwallet.setBorder(eborder);
		pan1_2.add(gucciwallet);
		
		img = new ImageIcon("image/bag.png");
		img = imageSetSize(img, 140, 47);
		guccibag = new JButton(img);
		guccibag.addActionListener(this);
		 guccibag.setBorder(eborder);
		pan1_2.add(guccibag);
		
		
		img = new ImageIcon("image/necklace.png");
		img = imageSetSize(img, 140, 47);
		guccinecklace =new JButton(img);
		guccinecklace.addActionListener(this);
		 guccinecklace.setBorder(eborder);
		pan1_2.add(guccinecklace);
		
		pan1.add(pan1_1);
		pan1.add(pan1_2);
		backpan.add(pan1);
		
		
		
		// 샤넬파트
		pan1 = new JPanel();
		pan1.setBackground(Color.white);
		pan1_1 = new JPanel();
		pan1_1.setBackground(Color.white);
		pan1_2 = new JPanel();
		pan1_2.setBackground(Color.white);
		pan1_2.setLayout(new GridLayout(4,1));
		eborder=new EtchedBorder(EtchedBorder.LOWERED);
		
		img = new ImageIcon("image/brandchanel.png");
		img = imageSetSize(img, 450, 200);
		lblimg = new JLabel(img);
		lblimg.setBorder(eborder);
		pan1_1.add(lblimg);
		
		
		
		img  = new ImageIcon("image/watch.png");
		img = imageSetSize(img, 140, 47);
		chanelwatch = new JButton(img);
		chanelwatch.addActionListener(this);
		chanelwatch.setBorder(eborder);
		pan1_2.add(chanelwatch);
		
		img = new ImageIcon("image/wallet.png");
		img = imageSetSize(img, 140, 47);
		chanelwallet = new JButton(img);
		chanelwallet.addActionListener(this);
		chanelwallet.setBorder(eborder);
		pan1_2.add(chanelwallet);
		
		img = new ImageIcon("image/bag.png");
		img = imageSetSize(img, 140, 47);
		chanelbag = new JButton(img);
		chanelbag.addActionListener(this);
		chanelbag.setBorder(eborder);
		pan1_2.add(chanelbag);
		
		
		img = new ImageIcon("image/necklace.png");
		img = imageSetSize(img, 140, 47);
		chanelnecklace =new JButton(img);
		chanelnecklace.addActionListener(this);
		chanelnecklace.setBorder(eborder);
		pan1_2.add(chanelnecklace);
		
		pan1.add(pan1_1);
		pan1.add(pan1_2);
		backpan.add(pan1);
		
		
		
		
		// 에르메스파트
		 pan1 = new JPanel();
		pan1.setBackground(Color.white);
		 pan1_1 = new JPanel();
		pan1_1.setBackground(Color.white);
		 pan1_2 = new JPanel();
		pan1_2.setBackground(Color.white);
		pan1_2.setLayout(new GridLayout(4,1));
		eborder=new EtchedBorder(EtchedBorder.LOWERED);
		
		img = new ImageIcon("image/hermes1.png");
		img = imageSetSize(img, 450, 200);
		lblimg = new JLabel(img);
		lblimg.setBorder(eborder);
		pan1_1.add(lblimg);
		
		
		
		img  = new ImageIcon("image/watch.png");
		img = imageSetSize(img, 140, 47);
		hermeswatch = new JButton(img);
		hermeswatch.addActionListener(this);
		hermeswatch.setBorder(eborder);
		pan1_2.add(hermeswatch);
		
		img = new ImageIcon("image/wallet.png");
		img = imageSetSize(img, 140, 47);
		hermeswallet = new JButton(img);
		hermeswallet.addActionListener(this);
		hermeswallet.setBorder(eborder);
		pan1_2.add(hermeswallet);
		
		img = new ImageIcon("image/bag.png");
		img = imageSetSize(img, 140, 47);
		hermesbag = new JButton(img);
		hermesbag.addActionListener(this);
		hermesbag.setBorder(eborder);
		pan1_2.add(hermesbag);
		
		
		img = new ImageIcon("image/necklace.png");
		img = imageSetSize(img, 140, 47);
		hermesnecklace = new JButton(img);
		hermesnecklace.addActionListener(this);
		 hermesnecklace.setBorder(eborder);
		pan1_2.add(hermesnecklace);
		
		pan1.add(pan1_1);
		pan1.add(pan1_2);
		backpan.add(pan1);
		
		
		
		// 디올파트
		
		 pan1 = new JPanel();
		pan1.setBackground(Color.white);
		 pan1_1 = new JPanel();
		pan1_1.setBackground(Color.white);
		 pan1_2 = new JPanel();
		pan1_2.setBackground(Color.white);
		pan1_2.setLayout(new GridLayout(4,1));
		eborder=new EtchedBorder(EtchedBorder.LOWERED);
		
		img = new ImageIcon("image/dior.png");
		img = imageSetSize(img, 450, 200);
		lblimg = new JLabel(img);
		lblimg.setBorder(eborder);
		pan1_1.add(lblimg);
		
		
		img  = new ImageIcon("image/watch.png");
		img = imageSetSize(img, 140, 47);
		diorwatch = new JButton(img);
		diorwatch.addActionListener(this);
		 diorwatch.setBorder(eborder);
		pan1_2.add(diorwatch);
		
		img = new ImageIcon("image/wallet.png");
		img = imageSetSize(img, 140, 47);
		diorwallet = new JButton(img);
		diorwallet.addActionListener(this);
		diorwallet.setBorder(eborder);
		pan1_2.add(diorwallet);
		
		img = new ImageIcon("image/bag.png");
		img = imageSetSize(img, 140, 47);
		diorbag = new JButton(img);
		diorbag.addActionListener(this);
		diorbag.setBorder(eborder);
		pan1_2.add(diorbag);
		
		
		img = new ImageIcon("image/necklace.png");
		img = imageSetSize(img, 140, 47);
		diornecklace =new JButton(img);
		diornecklace.addActionListener(this);
		diornecklace.setBorder(eborder);
		pan1_2.add(diornecklace);
		
		pan1.add(pan1_1);
		pan1.add(pan1_2);
		backpan.add(pan1);
		
		
		scrollpane = new JScrollPane(backpan);
		scrollpane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollpane);
		
	
		setVisible(true);
	}


	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == MyInfo){
			signUp su = new signUp();
			su.signUp(id, this);
			su.setTitle("회원정보");
			
		}else if(obj == Logout) {
			loginPage lg = new loginPage();
			dispose();
			
		}else if(obj == Reservation) {
			//예약현황 출력
			reservation reserv = new reservation("예약현황", id);
		}
		
		//구찌파트
		
		if(obj == gucciwatch) {
			 // 0일때 구찌 시계출력
	         int n = 0;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj == guccibag) {
			 // 5일때 구찌 가방출력
	         int n = 5;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj == gucciwallet) {
			 // 10일때 구찌 지갑출력
	         int n = 10;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj == guccinecklace) {
			 // 15일때 구찌 목걸이출력
	         int n = 15;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		
		
		//샤넬파트
		
		if(obj == chanelwatch) {
			 // 20일때 샤넬 시계출력
	         int n = 20;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj == chanelbag) {
			 // 25일때 샤넬 가방출력
	         int n = 25;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj == chanelwallet) {
			 // 30일때 샤넬 지갑출력
	         int n = 30;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj == chanelnecklace) {
			 // 35일때 샤넬 목걸이출력
	         int n = 35;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		
		
		//헤르메스파트
		
		if(obj == hermeswatch) {
			 // 40일때 헤르메스 시계출력
	         int n = 40;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj == hermesbag) {
			 // 45일때 헤르메스 가방출력
	         int n = 45;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj == hermeswallet) {
			 // 50일때  헤르메스  지갑출력
	         int n = 50;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj == hermesnecklace) {
			 // 55일때  헤르메스  목걸이출력
	         int n = 55;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		
		
		//디올파트
		
		if(obj == diorwatch) {
			 // 60일때 디올 시계출력
	         int n = 60;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj ==  diorbag) {
			 // 65일때 디올 가방출력
	         int n = 65;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj ==  diorwallet) {
			 // 70일때 디올 지갑출력
	         int n = 70;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		else if(obj ==  diornecklace) {
			 // 75일때 디올 목걸이출력
	         int n = 75;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		
	}
	
}
