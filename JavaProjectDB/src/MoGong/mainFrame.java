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
	private JMenu  Man,Woman,Child;
	private JMenuItem ManWear,WomanWear,ManShoes,WomanShoes,Accessory;
	
	private JMenu menuUser;
	private JMenuItem BuyList,basket,MyInfo,Reservation,Logout;
	loginPage loginPage;
	private JPanel pan;
	private JLabel lbl;
	
	public mainFrame(String title , int width , int height, loginPage loginPage) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.loginPage =loginPage;
		
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
	
		menubar.add(menuProduct);
		menubar.add(menuUser);
		setJMenuBar(menubar);	
		
		//
		//
		//
		//
		
		pan = new JPanel(new BorderLayout());
		pan.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(pan);
		
		lbl = new JLabel("회원 목록");
		lbl.setFont(new Font("맑은 고딕",Font.BOLD,30));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setPreferredSize(new Dimension(400,80));
		
		pan.add(lbl,BorderLayout.NORTH);
		
        ProductDB db = new ProductDB();
		List<productdto> list = db.getProductList();
		
		String header[] = {"상품번호","상품이름","상품가격","상품브랜드","상품종류","상품URL"};
		
		tModel = new DefaultTableModel(header,0);
		
		for(int i = 0; i<list.size(); i++) {
			int itemid = list.get(i).getItemid();
			String itemname = list.get(i).getItemname();
			String itemprice = list.get(i).getItemprice();
			String itembrand = list.get(i).getItembrand();
			String itemclass = list.get(i).getItemclass();
			String itemimage = list.get(i).getItemimage();
		
			
			
			
			Object [] data = {itemid,itemname,itemprice,itembrand,itemclass,itemimage};
			
			tModel.addRow(data);
		}
		
		table = new JTable(tModel);
		table.setFont(new Font("맑온 고딕", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.getColumn("상품이름").setPreferredWidth(10);
		table.setCellSelectionEnabled(false);
		table.addMouseListener(this);
		
		JScrollPane scrollPane = new JScrollPane(table);
		pan.add(scrollPane,BorderLayout.CENTER);
		
		btnback = new JButton("나가기");
		btnback.addActionListener(this);
		pan.add(btnback,BorderLayout.SOUTH);
		
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
			
		}if(obj == Logout) {
			loginPage lg = new loginPage();
			dispose();
		}
	
		if(btnback == obj) {
			System.exit(0);
		}
		
	}
	
}
