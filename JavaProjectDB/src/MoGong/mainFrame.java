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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class mainFrame extends JFrame implements MouseListener {

	private ImageIcon background,img1,buyimg;
	private JLabel lblimg1;
	private JLabel price1;
	private JScrollPane scrollpane;
	private JLabel buy1,buy2,buy3,buy4,buy5;
	
	private JMenu menuProduct;
	private JMenu  Man,Woman,Child;
	private JMenuItem ManWear,WomanWear,ManShoes,WomanShoes,Accessory;
	
	private JMenu menuUser;
	private JMenuItem BuyList,basket,MyInfo,Reservation;
	
	public mainFrame(String title , int width , int height) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menubar = new JMenuBar();
		menubar.setBackground(Color.PINK);
	
		JMenu menuProduct = new JMenu("상품목록");
	
		JMenu Man = new JMenu("남성");
		ManWear = new JMenuItem("의류");
		ManShoes = new JMenuItem("신발");


		Man.add(ManWear);
		Man.add(ManShoes);
	
		menuProduct.add(Man);
	
	
		JMenu Woman = new JMenu("여성");
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
		
		
		JPanel backpan = new JPanel();
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
		JPanel PanelSub1_1 = new JPanel();
	
		PanelSub1_1.setLayout(new GridLayout(3,1));
		JLabel name1 = new JLabel("[GG 마몽] 스몰 마틀라세 숄더백",SwingConstants.CENTER);
		price1 = new JLabel("2,781,000 (10% SALE)",SwingConstants.CENTER);
		price1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		price1.addMouseListener(this);
		JLabel info1 = new JLabel("GUCCI",SwingConstants.CENTER);
		
		name1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price1.setFont(new Font("맑은 고딕",Font.BOLD,20));
		price1.setForeground(Color.RED);
		info1.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		PanelSub1_1.add(name1);
		PanelSub1_1.add(price1);
		PanelSub1_1.add(info1);
		
		PanelSub1_1.setOpaque(false);
		
		
		// 버튼
		JPanel PanelSub1_2 = new JPanel();
	
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
	    JPanel Panel2 = new JPanel();
	    Panel2.setBorder(oneTb);
		Panel2.setLayout(new BorderLayout());
	    
		// 사진
		img1 = new ImageIcon("images/Tom.png");
		img1 = imageSetSize(img1, 150, 150);
		lblimg1 = new JLabel(img1);
	
		// 텍스트
		JPanel PanelSub2_1 = new JPanel();
		
		PanelSub2_1.setLayout(new GridLayout(3,1));
		JLabel name2 = new JLabel("다크 그레이 코튼 부클레 수팅 엔지니어 암밴드 클래식 재킷",SwingConstants.CENTER);
		JLabel price2 = new JLabel("2,368,000 (20% SALE)",SwingConstants.CENTER);
		price2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel info2 = new JLabel("THOM BROWNE",SwingConstants.CENTER);
				
		name2.setFont(new Font("맑은 고딕",Font.BOLD,12));
		price2.setFont(new Font("맑은 고딕",Font.BOLD,20));
		price2.setForeground(Color.RED);
		info2.setFont(new Font("맑은 고딕",Font.BOLD,15));
				
				
				
		PanelSub2_1.add(name2);
		PanelSub2_1.add(price2);
		PanelSub2_1.add(info2);
	
		PanelSub2_1.setOpaque(false);
		
		// 버튼
		JPanel PanelSub2_2 = new JPanel();
	
		PanelSub2_2.setLayout(new FlowLayout(0,0,60));

		
		JLabel buy2 = new JLabel(buyimg);
		
		PanelSub2_2.setOpaque(false);
		PanelSub2_2.add(buy2);
		
		
		// 붙이기
		Panel2.add(lblimg1,BorderLayout.WEST);
		Panel2.add(PanelSub2_1);
		Panel2.add(PanelSub2_2,BorderLayout.EAST);
		
		Panel2.setOpaque(false);
		
	    backpan.add(Panel2);
		
	    
	    // 세번째
	    JPanel Panel3 = new JPanel();
	    Panel3.setBorder(oneTb);
		Panel3.setLayout(new BorderLayout());
	    
		// 사진
		img1 = new ImageIcon("images/TOm2.png");
		img1 = imageSetSize(img1, 150, 150);
		lblimg1 = new JLabel(img1);
        
		// 텍스트
		JPanel PanelSub3_1 = new JPanel();
		
		PanelSub3_1.setLayout(new GridLayout(3,1));
		JLabel name3 = new JLabel("네추럴 코튼 캔버스 소프트 MRS. THOM 백",SwingConstants.CENTER);
		JLabel price3 = new JLabel("4,572,400 (12% SALE)",SwingConstants.CENTER);
		price3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel info3 = new JLabel("THOM BROWNE",SwingConstants.CENTER);
		
		name3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price3.setFont(new Font("맑은 고딕",Font.BOLD,20));
		price3.setForeground(Color.RED);
		info3.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		
		
		PanelSub3_1.add(name3);
		PanelSub3_1.add(price3);
		PanelSub3_1.add(info3);
		
		PanelSub3_1.setOpaque(false);
		
		// 버튼
		JPanel PanelSub3_2 = new JPanel();
	
		PanelSub3_2.setLayout(new FlowLayout(0,0,60));

		
		
		 buy3 = new JLabel(buyimg);
		
		PanelSub3_2.setOpaque(false);
		PanelSub3_2.add(buy3);
		
		
		// 붙이기
		
		Panel3.add(lblimg1,BorderLayout.WEST);
		Panel3.add(PanelSub3_1);
		Panel3.add(PanelSub3_2,BorderLayout.EAST);
		
		Panel1.setOpaque(false);
		
	    backpan.add(Panel3);
		
	    
	    // 네번째
	    JPanel Panel4 = new JPanel();
	    Panel4.setBorder(oneTb);
		Panel4.setLayout(new BorderLayout());
	    
		// 사진
		img1 = new ImageIcon("images/Sha.jpg");
		img1 = imageSetSize(img1, 150, 150);
		lblimg1 = new JLabel(img1);
        
		// 텍스트
		JPanel PanelSub4_1 = new JPanel();
		
		PanelSub4_1.setLayout(new GridLayout(3,1));
		JLabel name4 = new JLabel("AB6125 B05546 NC156 네크리스",SwingConstants.CENTER);
		JLabel price4 = new JLabel("1,239,300 (10% SALE)",SwingConstants.CENTER);
		price4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel info4 = new JLabel("CHANEL",SwingConstants.CENTER);
		
		name4.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price4.setFont(new Font("맑은 고딕",Font.BOLD,20));
		price4.setForeground(Color.RED);
		info4.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		
		PanelSub4_1.add(name4);
		PanelSub4_1.add(price4);
		PanelSub4_1.add(info4);
		
		PanelSub4_1.setOpaque(false);
		
		// 버튼
		JPanel PanelSub4_2 = new JPanel();
	
		PanelSub4_2.setLayout(new FlowLayout(0,0,60));

		
		buy4 = new JLabel(buyimg);
		
		PanelSub4_2.setOpaque(false);
		PanelSub4_2.add(buy4);
		
		
		// 붙이기
		Panel4.add(lblimg1,BorderLayout.WEST);
		Panel4.add(PanelSub4_1);
		Panel4.add(PanelSub4_2,BorderLayout.EAST);
		
		Panel4.setOpaque(false);
		
	    backpan.add(Panel4);
	    
		
	    // -------------------------------------------------------
	    
	    // 다섯번째
	    JPanel Panel5 = new JPanel();
	    Panel5.setBorder(oneTb);
		Panel5.setLayout(new BorderLayout());
	
	    
		// 사진
		img1 = new ImageIcon("images/gucci2.jpg");
		img1 = imageSetSize(img1, 150, 150);
		lblimg1 = new JLabel(img1);
        
	
		
		// 텍스트
		JPanel PanelSub5_1 = new JPanel();
		
		PanelSub5_1.setLayout(new GridLayout(3,1));
		JLabel name5 = new JLabel("[GG 마몽] 스몰 마틀라세 숄더백",SwingConstants.CENTER);
		JLabel price5 = new JLabel("2,781,000 (10% SALE)",SwingConstants.CENTER);
		price5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel info5 = new JLabel("GUCCI",SwingConstants.CENTER);
		
		name5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price5.setFont(new Font("맑은 고딕",Font.BOLD,20));
		price5.setForeground(Color.RED);
		info5.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		
		PanelSub5_1.add(name5);
		PanelSub5_1.add(price5);
		PanelSub5_1.add(info5);
		
		PanelSub5_1.setOpaque(false);
		
		// 버튼
		JPanel PanelSub5_2 = new JPanel();
	
		PanelSub5_2.setLayout(new FlowLayout(0,0,60));
		
		
		 buy5 = new JLabel(buyimg);
		
		PanelSub5_2.setOpaque(false);
		PanelSub5_2.add(buy5);
		
		// 붙이기
		Panel5.add(lblimg1,BorderLayout.WEST);
		Panel5.add(PanelSub5_1);
		Panel5.add(PanelSub5_2,BorderLayout.EAST);
		
		Panel1.setOpaque(false);
		
	    backpan.add(Panel5);
	    
	    
		add(scrollpane);

		
		setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) {
		new mainFrame("상품목록",600,825);
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
			new Productbuy("상품정보화면",650,800);
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
}
