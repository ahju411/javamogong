package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class mainFrame extends JFrame implements MouseListener, ActionListener {

	private ImageIcon background,img1,buyimg;
	private JLabel lblimg1;
	private JLabel price1;
	private JScrollPane scrollpane;
	private JLabel buy1,buy2,buy3,buy4,buy5;
	private JTable table;
	private DefaultTableModel tModel;
	private JButton btnback;


	private JMenu menuProduct;
	private JMenu  MENUBRAND;
	private JMenuItem WATCH,BAG,WALLET,NECKLACE;
	

	
	private JMenu menuUser;
	private JMenuItem BuyList,basket,MyInfo,Reservation,Logout;
	loginPage loginPage;
	private JPanel pan;
	private JLabel lbl;

	private JMenuBar menubar;
	private ImageIcon img;
	private JLabel lblimg;
	String id;
	private JLabel gucciwallet,guccibag,guccinecklace;
	private JLabel chanelwatch,chanelwallet,chanelbag,chanelnecklace;
	private JLabel hermeswatch,hermeswallet,hermesbag,hermesnecklace;
	private JLabel diorwatch,diorwallet,diorbag,diornecklace;
	private JButton gucciwatch;
	private EtchedBorder eborder;
	
	public mainFrame(String title , int width , int height, loginPage loginPage,String id) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		this.loginPage =loginPage;
		this.id = id;
		
		menubar = new JMenuBar();
		menubar.setBackground(Color.PINK);
	
		JMenu menuProduct = new JMenu("상품목록");
		// 구찌 탭 // 시계 가방 지갑 목걸이
		MENUBRAND = new JMenu("구찌");
		WATCH = new JMenuItem("시계");
		BAG = new JMenuItem("가방");
		WALLET = new JMenuItem("지갑");
		NECKLACE = new JMenuItem("목걸이");
		MENUBRAND.add(WATCH);
		MENUBRAND.add(BAG);
		MENUBRAND.add(WALLET);
		MENUBRAND.add(NECKLACE);
		menuProduct.add(MENUBRAND);
		
		MENUBRAND = new JMenu("샤넬");
		WATCH = new JMenuItem("시계");
		BAG = new JMenuItem("가방");
		WALLET = new JMenuItem("지갑");
		NECKLACE = new JMenuItem("목걸이");
		MENUBRAND.add(WATCH);
		MENUBRAND.add(BAG);
		MENUBRAND.add(WALLET);
		MENUBRAND.add(NECKLACE);
		menuProduct.add(MENUBRAND);
		
		MENUBRAND = new JMenu("에르메스");
		WATCH = new JMenuItem("시계");
		BAG = new JMenuItem("가방");
		WALLET = new JMenuItem("지갑");
		NECKLACE = new JMenuItem("목걸이");
		MENUBRAND.add(WATCH);
		MENUBRAND.add(BAG);
		MENUBRAND.add(WALLET);
		MENUBRAND.add(NECKLACE);
		menuProduct.add(MENUBRAND);
		
		MENUBRAND = new JMenu("디올");
		WATCH = new JMenuItem("시계");
		BAG = new JMenuItem("가방");
		WALLET = new JMenuItem("지갑");
		NECKLACE = new JMenuItem("목걸이");
		MENUBRAND.add(WATCH);
		MENUBRAND.add(BAG);
		MENUBRAND.add(WALLET);
		MENUBRAND.add(NECKLACE);
		menuProduct.add(MENUBRAND);
		


		menuUser = new JMenu("My");
		MyInfo = new JMenuItem("나의 정보");
		MyInfo.addActionListener(this);
		Reservation = new JMenuItem("예약현황");
		Reservation.addActionListener(this);
		basket = new JMenuItem("장바구니");
		BuyList = new JMenuItem("구매목록");
		Logout = new JMenuItem("로그아웃");
		Logout.addActionListener(this);
	
		menuUser.add(MyInfo);
		menuUser.add(Reservation);
		menuUser.add(basket);
		menuUser.add(BuyList);
		menuUser.add(Logout);
	
		menubar.add(menuProduct);
		menubar.add(menuUser);
		setJMenuBar(menubar);	
		
		// 
		//
		
		// 배경패널 설정
		
		JPanel backpan = new JPanel();
		
		backpan.setLayout(new GridLayout(4,1));
		backpan.setBackground(Color.WHITE);;
		scrollpane = new JScrollPane(backpan);
		
		// 구찌브랜드
		
	
		
		JPanel pan1 = new JPanel();
		pan1.setBackground(Color.WHITE);
		JPanel pan1_1 = new JPanel();
		pan1_1.setBackground(Color.WHITE);
		JPanel pan1_2 = new JPanel();
		pan1_2.setBackground(Color.WHITE);
		pan1_2.setLayout(new GridLayout(4,1));
		eborder=new EtchedBorder(EtchedBorder.LOWERED);
		
		img = new ImageIcon("image/brandgucci.png");
		img = imageSetSize(img, 450, 200);
		lblimg = new JLabel(img);
		 lblimg.setBorder(eborder);
		pan1_1.add(lblimg);
		
		
		
		img  = new ImageIcon("image/watch.png");
		img = imageSetSize(img, 140, 47);
		gucciwatch = new JButton(img);
		gucciwatch.setPreferredSize(new Dimension(100, 45));
		gucciwatch.setOpaque(true);
		gucciwatch.setBackground(null);
		gucciwatch.setBorderPainted(false);
		gucciwatch.setBorder(eborder);
		pan1_2.add(gucciwatch);
		
		img = new ImageIcon("image/wallet.png");
		img = imageSetSize(img, 140, 47);
		gucciwallet = new JLabel(img);
		 gucciwallet.setBorder(eborder);
		pan1_2.add(gucciwallet);
		
		img = new ImageIcon("image/bag.png");
		img = imageSetSize(img, 140, 47);
		guccibag = new JLabel(img);
		 guccibag.setBorder(eborder);
		pan1_2.add(guccibag);
		
		
		img = new ImageIcon("image/necklace.png");
		img = imageSetSize(img, 140, 47);
		guccinecklace = new JLabel(img);
		 guccinecklace.setBorder(eborder);
		pan1_2.add(guccinecklace);
		
		pan1.add(pan1_1);
		pan1.add(pan1_2);
		backpan.add(pan1);
		
		
		
		
		
		// 샤넬파트
		 pan1 = new JPanel();
		pan1.setBackground(Color.WHITE);
	 pan1_1 = new JPanel();
		pan1_1.setBackground(Color.WHITE);
	 pan1_2 = new JPanel();
		pan1_2.setBackground(Color.WHITE);
		pan1_2.setLayout(new GridLayout(4,1));
		eborder=new EtchedBorder(EtchedBorder.LOWERED);
		
		img = new ImageIcon("image/brandchanel.png");
		img = imageSetSize(img, 450, 200);
		lblimg = new JLabel(img);
		 lblimg.setBorder(eborder);
		pan1_1.add(lblimg);
		
		
		
		img  = new ImageIcon("image/watch.png");
		img = imageSetSize(img, 140, 47);
		chanelwatch = new JLabel(img);
		chanelwatch.setBorder(eborder);
		pan1_2.add(chanelwatch);
		
		img = new ImageIcon("image/wallet.png");
		img = imageSetSize(img, 140, 47);
		chanelwallet = new JLabel(img);
		chanelwallet.setBorder(eborder);
		pan1_2.add(chanelwallet);
		
		img = new ImageIcon("image/bag.png");
		img = imageSetSize(img, 140, 47);
		chanelbag = new JLabel(img);
		chanelbag.setBorder(eborder);
		pan1_2.add(chanelbag);
		
		
		img = new ImageIcon("image/necklace.png");
		img = imageSetSize(img, 140, 47);
		chanelnecklace = new JLabel(img);
		chanelnecklace.setBorder(eborder);
		pan1_2.add(chanelnecklace);
		
		pan1.add(pan1_1);
		pan1.add(pan1_2);
		backpan.add(pan1);
		
		
		add(backpan);
		
		
		// 에르메스파트
		
		 pan1 = new JPanel();
		pan1.setBackground(Color.WHITE);
		 pan1_1 = new JPanel();
		pan1_1.setBackground(Color.WHITE);
		 pan1_2 = new JPanel();
		pan1_2.setBackground(Color.WHITE);
		pan1_2.setLayout(new GridLayout(4,1));
		eborder=new EtchedBorder(EtchedBorder.LOWERED);
		
		img = new ImageIcon("image/hermes1.png");
		img = imageSetSize(img, 450, 200);
		lblimg = new JLabel(img);
		 lblimg.setBorder(eborder);
		pan1_1.add(lblimg);
		
		
		
		img  = new ImageIcon("image/watch.png");
		img = imageSetSize(img, 140, 47);
		hermeswatch = new JLabel(img);
		hermeswatch.setBorder(eborder);
		pan1_2.add(hermeswatch);
		
		img = new ImageIcon("image/wallet.png");
		img = imageSetSize(img, 140, 47);
		hermeswallet = new JLabel(img);
		hermeswallet.setBorder(eborder);
		pan1_2.add(hermeswallet);
		
		img = new ImageIcon("image/bag.png");
		img = imageSetSize(img, 140, 47);
		hermesbag = new JLabel(img);
		hermesbag.setBorder(eborder);
		pan1_2.add(hermesbag);
		
		
		img = new ImageIcon("image/necklace.png");
		img = imageSetSize(img, 140, 47);
		hermesnecklace = new JLabel(img);
		 hermesnecklace.setBorder(eborder);
		pan1_2.add(hermesnecklace);
		
		pan1.add(pan1_1);
		pan1.add(pan1_2);
		backpan.add(pan1);
		
		
		add(backpan);
		
		
		// 디올파트
		
		 pan1 = new JPanel();
		pan1.setBackground(Color.WHITE);
		 pan1_1 = new JPanel();
		pan1_1.setBackground(Color.WHITE);
		 pan1_2 = new JPanel();
		pan1_2.setBackground(Color.WHITE);
		pan1_2.setLayout(new GridLayout(4,1));
		eborder=new EtchedBorder(EtchedBorder.LOWERED);
		
		img = new ImageIcon("image/dior.png");
		img = imageSetSize(img, 450, 200);
		lblimg = new JLabel(img);
		 lblimg.setBorder(eborder);
		pan1_1.add(lblimg);
		
		
		
		img  = new ImageIcon("image/watch.png");
		img = imageSetSize(img, 140, 47);
		diorwatch = new JLabel(img);
		 diorwatch.setBorder(eborder);
		pan1_2.add(diorwatch);
		
		img = new ImageIcon("image/wallet.png");
		img = imageSetSize(img, 140, 47);
		diorwallet = new JLabel(img);
		diorwallet.setBorder(eborder);
		pan1_2.add(diorwallet);
		
		img = new ImageIcon("image/bag.png");
		img = imageSetSize(img, 140, 47);
		diorbag = new JLabel(img);
		diorbag.setBorder(eborder);
		pan1_2.add(diorbag);
		
		
		img = new ImageIcon("image/necklace.png");
		img = imageSetSize(img, 140, 47);
		diornecklace = new JLabel(img);
		diornecklace.setBorder(eborder);
		pan1_2.add(diornecklace);
		
		pan1.add(pan1_1);
		pan1.add(pan1_2);
		backpan.add(pan1);
		
		
		
		
		//
		
		
	
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
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		
		if(obj == price1) {
			System.out.println("TEst");
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
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
			String iD = getTitle();
			int ss = iD.length();
			iD = iD.substring(5, ss);
			reservation reserv = new reservation("예약현황", iD);
		}
		
		if(obj == gucciwatch) {
			 // 0일때 구찌 시계출력
	         int n = 0;
	         ProductListUI ui = new ProductListUI("목록/" + id, 1300, 600,n,this,id);
	         this.setVisible(false);
		}
		
		
		
	}
	
}
