package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ProductList0527 extends JFrame {

	private JPanel backpan,pan1;
	private JPanel PanelSub1_1,PanelSub1_2;
	private ImageIcon background,img1,buyimg;
	private JLabel lblimg1;
	private JLabel name1,price1,info1;
	private JScrollPane scrollpane;
	private JLabel buy1,buy2,buy3,buy4,buy5;
	
	
	
	private JMenu menuProduct;
	private JMenu  Man,Woman,Child;
	private JMenuItem ManWear,WomanWear,ManShoes,WomanShoes,Accessory;
	
	private JMenu menuUser;
	private JMenuItem BuyList,basket,MyInfo,Reservation;
	
	

	public ProductList0527(String title , int width , int height) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		menubar.setBackground(Color.PINK);
	menuProduct = new JMenu("상품목록");
	
	Man = new JMenu("남성");
	ManWear = new JMenuItem("의류");
	ManShoes = new JMenuItem("신발");


	Man.add(ManWear);
	Man.add(ManShoes);
	
	menuProduct.add(Man);
	

	
	Woman = new JMenu("여성");
	WomanWear = new JMenuItem("의류");
	WomanShoes = new JMenuItem("신발");


	Woman.add(WomanWear);
	Woman.add(WomanShoes);

	menuProduct.add(Woman);

	Accessory = new JMenuItem("악세서리 / 가방");
	menuProduct.add(Accessory);
	menuUser = new JMenu("My");
	MyInfo = new JMenuItem("나의 정보");
	Reservation = new JMenuItem("예약현황");
	basket = new JMenuItem("장바구니");
	BuyList = new JMenuItem("구매목록");
	
	
	menuUser.add(MyInfo);
	menuUser.add(Reservation);
	menuUser.add(basket);
	menuUser.add(BuyList);
	
	
	menubar.add(menuProduct);
	menubar.add(menuUser);
	setJMenuBar(menubar);	
		
		
		
		
		
		backpan = new JPanel();
		backpan.setBackground(Color.white);
		backpan.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		backpan.setLayout(new GridLayout(15,1));
		scrollpane = new JScrollPane(backpan);
		
		
		
		// 첫번째 상품
		
	TitledBorder oneTb= new TitledBorder(new LineBorder(Color.black));
	
		
		JPanel Panel1 = new JPanel();
        Panel1.setBorder(oneTb);
		Panel1.setLayout(new BorderLayout());
	 
	    
		// 사진
		img1 = new ImageIcon("images/gucci.png");
		img1 = imageSetSize(img1, 150, 150);
		lblimg1 = new JLabel(img1);
        
	
		
		// 텍스트
		PanelSub1_1 = new JPanel();
	
		PanelSub1_1.setLayout(new GridLayout(3,1));
		name1 = new JLabel("[GG 마몽] 스몰 마틀라세 숄더백",SwingConstants.CENTER);
		price1 = new JLabel("2,781,000 (10% SALE)",SwingConstants.CENTER);
		price1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info1 = new JLabel("GUCCI",SwingConstants.CENTER);
		
		name1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price1.setFont(new Font("맑은 고딕",Font.BOLD,20));
		price1.setForeground(Color.RED);
		info1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		
		
		PanelSub1_1.add(name1);
		PanelSub1_1.add(price1);
		PanelSub1_1.add(info1);
		
		PanelSub1_1.setOpaque(false);
		
		// 버튼
		PanelSub1_2 = new JPanel();
	
		PanelSub1_2.setLayout(new FlowLayout(0,0,60));

		
		buyimg = new ImageIcon("images/buyicon.png");
		JLabel buy1 = new JLabel(buyimg);
		
		PanelSub1_2.setOpaque(false);
		PanelSub1_2.add(buy1);
		
		
		// 붙이기
		
		Panel1.add(lblimg1,BorderLayout.WEST);
		Panel1.add(PanelSub1_1);
		Panel1.add(PanelSub1_2,BorderLayout.EAST);
		
		Panel1.setOpaque(false);
		
	    backpan.add(Panel1);
		
	    
	    
	    // 두번째
	    
	    Panel1 = new JPanel();
	    Panel1.setBorder(oneTb);
		Panel1.setLayout(new BorderLayout());
	
	    
		// 사진
		img1 = new ImageIcon("images/Tom.png");
		img1 = imageSetSize(img1, 150, 150);
		lblimg1 = new JLabel(img1);
        
	
		
		// 텍스트
		
				PanelSub1_1 = new JPanel();
			
				PanelSub1_1.setLayout(new GridLayout(3,1));
				name1 = new JLabel("다크 그레이 코튼 부클레 수팅 엔지니어 암밴드 클래식 재킷",SwingConstants.CENTER);
				price1 = new JLabel("2,368,000 (20% SALE)",SwingConstants.CENTER);
				price1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				info1 = new JLabel("THOM BROWNE",SwingConstants.CENTER);
				
				name1.setFont(new Font("맑은 고딕",Font.BOLD,12));
				price1.setFont(new Font("맑은 고딕",Font.BOLD,20));
				price1.setForeground(Color.RED);
				info1.setFont(new Font("맑은 고딕",Font.BOLD,15));
				
				
				
				PanelSub1_1.add(name1);
				PanelSub1_1.add(price1);
				PanelSub1_1.add(info1);
		
		PanelSub1_1.setOpaque(false);
		
		// 버튼
		PanelSub1_2 = new JPanel();
	
		PanelSub1_2.setLayout(new FlowLayout(0,0,60));

		
		
		
		JLabel buy2 = new JLabel(buyimg);
		
		PanelSub1_2.setOpaque(false);
		PanelSub1_2.add(buy2);
		
		
		// 붙이기
		
		Panel1.add(lblimg1,BorderLayout.WEST);
		Panel1.add(PanelSub1_1);
		Panel1.add(PanelSub1_2,BorderLayout.EAST);
		
		Panel1.setOpaque(false);
		
	    backpan.add(Panel1);
		
	    
	    
	    
	    
	    
	    // 세번째
	    
	    Panel1 = new JPanel();
	    Panel1.setBorder(oneTb);
		Panel1.setLayout(new BorderLayout());
	
	    
		// 사진
		img1 = new ImageIcon("images/TOm2.png");
		img1 = imageSetSize(img1, 150, 150);
		lblimg1 = new JLabel(img1);
        
	
		
		// 텍스트
		PanelSub1_1 = new JPanel();
		
		PanelSub1_1.setLayout(new GridLayout(3,1));
		name1 = new JLabel("네추럴 코튼 캔버스 소프트 MRS. THOM 백",SwingConstants.CENTER);
		price1 = new JLabel("4,572,400 (12% SALE)",SwingConstants.CENTER);
		price1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info1 = new JLabel("THOM BROWNE",SwingConstants.CENTER);
		
		name1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price1.setFont(new Font("맑은 고딕",Font.BOLD,20));
		price1.setForeground(Color.RED);
		info1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		
		
		PanelSub1_1.add(name1);
		PanelSub1_1.add(price1);
		PanelSub1_1.add(info1);
		
		PanelSub1_1.setOpaque(false);
		
		// 버튼
		PanelSub1_2 = new JPanel();
	
		PanelSub1_2.setLayout(new FlowLayout(0,0,60));

		
		
		 buy3 = new JLabel(buyimg);
		
		PanelSub1_2.setOpaque(false);
		PanelSub1_2.add(buy3);
		
		
		// 붙이기
		
		Panel1.add(lblimg1,BorderLayout.WEST);
		Panel1.add(PanelSub1_1);
		Panel1.add(PanelSub1_2,BorderLayout.EAST);
		
		Panel1.setOpaque(false);
		
	    backpan.add(Panel1);
		
	    // ---------------------------------------------------------------
	    
	    // 네번째
	    
	    Panel1 = new JPanel();
	    Panel1.setBorder(oneTb);
		Panel1.setLayout(new BorderLayout());
	
	    
		// 사진
		img1 = new ImageIcon("images/Sha.jpg");
		img1 = imageSetSize(img1, 150, 150);
		lblimg1 = new JLabel(img1);
        
	
		
		// 텍스트
		PanelSub1_1 = new JPanel();
		
		PanelSub1_1.setLayout(new GridLayout(3,1));
		name1 = new JLabel("AB6125 B05546 NC156 네크리스",SwingConstants.CENTER);
		price1 = new JLabel("1,239,300 (10% SALE)",SwingConstants.CENTER);
		price1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info1 = new JLabel("CHANEL",SwingConstants.CENTER);
		
		name1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price1.setFont(new Font("맑은 고딕",Font.BOLD,20));
		price1.setForeground(Color.RED);
		info1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		
		
		PanelSub1_1.add(name1);
		PanelSub1_1.add(price1);
		PanelSub1_1.add(info1);
		
		PanelSub1_1.setOpaque(false);
		
		// 버튼
		PanelSub1_2 = new JPanel();
	
		PanelSub1_2.setLayout(new FlowLayout(0,0,60));

		
		
		 buy4 = new JLabel(buyimg);
		
		PanelSub1_2.setOpaque(false);
		PanelSub1_2.add(buy4);
		
		
		// 붙이기
		
		Panel1.add(lblimg1,BorderLayout.WEST);
		Panel1.add(PanelSub1_1);
		Panel1.add(PanelSub1_2,BorderLayout.EAST);
		
		Panel1.setOpaque(false);
		
	    backpan.add(Panel1);
	    
		
	    // -------------------------------------------------------
	    
	    // 다섯번째
	    
	    Panel1 = new JPanel();
	    Panel1.setBorder(oneTb);
		Panel1.setLayout(new BorderLayout());
	
	    
		// 사진
		img1 = new ImageIcon("images/gucci2.jpg");
		img1 = imageSetSize(img1, 150, 150);
		lblimg1 = new JLabel(img1);
        
	
		
		// 텍스트
		PanelSub1_1 = new JPanel();
		
		PanelSub1_1.setLayout(new GridLayout(3,1));
		name1 = new JLabel("[GG 마몽] 스몰 마틀라세 숄더백",SwingConstants.CENTER);
		price1 = new JLabel("2,781,000 (10% SALE)",SwingConstants.CENTER);
		price1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		info1 = new JLabel("GUCCI",SwingConstants.CENTER);
		
		name1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price1.setFont(new Font("맑은 고딕",Font.BOLD,20));
		price1.setForeground(Color.RED);
		info1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		
		
		PanelSub1_1.add(name1);
		PanelSub1_1.add(price1);
		PanelSub1_1.add(info1);
		
		PanelSub1_1.setOpaque(false);
		
		// 버튼
		PanelSub1_2 = new JPanel();
	
		PanelSub1_2.setLayout(new FlowLayout(0,0,60));

		
		
		 buy5 = new JLabel(buyimg);
		
		PanelSub1_2.setOpaque(false);
		PanelSub1_2.add(buy5);
		
		
		// 붙이기
		
		Panel1.add(lblimg1,BorderLayout.WEST);
		Panel1.add(PanelSub1_1);
		Panel1.add(PanelSub1_2,BorderLayout.EAST);
		
		Panel1.setOpaque(false);
		
	    backpan.add(Panel1);
		
	   
	    
	    
		add(scrollpane);

		
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new ProductList0527("상품목록",600,825);
	}




ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
	Image ximg = icon.getImage();
	Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
	ImageIcon xyimg = new ImageIcon(yimg);
	return xyimg;
}
}
