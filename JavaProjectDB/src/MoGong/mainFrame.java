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
	private JButton btn1;
	private JButton btn2;
	
	public mainFrame(String title , int width , int height, loginPage loginPage) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		this.loginPage =loginPage;
		
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
		//
		//
		btn1 = new JButton("구찌시계");
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new JButton("구찌가방");
		btn2.addActionListener(this);
		add(btn2);
	
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
			String id =loginPage.getLogid();
			signUp su = new signUp();
			su.signUp(id, this);
			su.setTitle("회원정보");
			
		}else if(obj == Logout) {
			loginPage lg = new loginPage();
			dispose();
		}else if(obj == Reservation) {
			//예약현황 출력
			reservation reserv = new reservation("예약현황", 500, 600, loginPage);
		}
		
		if(obj == btn1) {
			// 0일때 구찌 시계출력
			int n = 0;
			ProductListUI ui = new ProductListUI("목록", 1300, 600,n,this);
			this.setVisible(false);

		
		}
		if(obj == btn2) {
			// 5일때 구찌 가방 출력
			int n = 5;
			ProductListUI ui = new ProductListUI("목록", 1300, 600,n,this);
			this.setVisible(false);
		}

		
		
	}
	
}
