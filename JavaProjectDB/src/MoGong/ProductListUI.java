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

public class ProductListUI extends JFrame implements MouseListener, ActionListener {

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
	// , loginPage loginPage 넣어야합니다 int height 오른쪽에  프레임 연결시  !!!! -은철-
	public ProductListUI(String title , int width , int height) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	this.loginPage =loginPage; 이것도 풀어주셔야합니다 -은철-
		
		// 메뉴 
		menubar = new JMenuBar();
		menubar.setBackground(Color.PINK);
	
		menuUser = new JMenu("My");
		MyInfo = new JMenuItem("나의 정보");
		MyInfo.addActionListener(this);
		Reservation = new JMenuItem("예약현황");
		basket = new JMenuItem("장바구니");
		BuyList = new JMenuItem("구매목록");
		Logout = new JMenuItem("로그아웃");
		Logout.addActionListener(this);
	
		menuUser.add(MyInfo);
		menuUser.add(Reservation);
		menuUser.add(basket);
		menuUser.add(BuyList);
		menuUser.add(Logout);
	
		
		menubar.add(menuUser);
		setJMenuBar(menubar);	
		
		//
		//
		//
		//
		
		
		setVisible(true);
	}
	

	public static void main(String[] args) {
		 new ProductListUI("구찌상품",700,500);
		 

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
		
		
	}
	
}
