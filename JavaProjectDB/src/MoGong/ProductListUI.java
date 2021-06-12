package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ProductListUI extends JFrame implements MouseListener, ActionListener {

	private JTable table;
	private DefaultTableModel tModel;
	private JButton btnback;

	private JMenu menuUser;
	private JMenuItem MyInfo, Reservation, Logout;

	private JMenuBar menubar;

	mainFrame mainFrame;
	private int l;
	String id;

	public ProductListUI(String title, int width, int height, int n, mainFrame mainFrame, String id) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame = mainFrame;
		this.id = id;
        setBackground(Color.WHITE);
		// 메뉴
		menubar = new JMenuBar();
		menubar.setBackground(Color.PINK);

		menuUser = new JMenu("My");
		MyInfo = new JMenuItem("나의 정보");
		MyInfo.addActionListener(this);
		Reservation = new JMenuItem("예약현황");
		Reservation.addActionListener(this);

		Logout = new JMenuItem("로그아웃");
		Logout.addActionListener(this);

		menuUser.add(MyInfo);
		menuUser.add(Reservation);

		menuUser.add(Logout);
		

		outputProductList(n);

		l = n;

		
		menubar.add(menuUser);
		setJMenuBar(menubar);


		setVisible(true);
	}

// 누른  상품종류별로 그 항목이 뜨게하는 메소드
	private void outputProductList(int n) {
		JPanel pan = new JPanel(new BorderLayout());
		pan.setBackground(Color.WHITE);
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pan);

		JLabel lbl = new JLabel("상품 목록");
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setPreferredSize(new Dimension(400, 80));

		pan.add(lbl, BorderLayout.NORTH);

		ProductDB db = new ProductDB();
		List<productdto> list = db.getProductList();

		String header[] = { "상품이름", "상품할인가격", "상품브랜드", "상품종류", "상품사진" };

		tModel = new DefaultTableModel(header, 0) {
			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}

			public boolean isCellEditable(int i, int c) {
				return false;
			}

		};
		// i는 5의배수로 넣을예정. 총 16개
		for (int i = n + 0; i < n + 5; i++) {
			int itemid = list.get(i).getItemid();
			String itemname = list.get(i).getItemname();
			String itemprice = list.get(i).getItemprice();
			String itembrand = list.get(i).getItembrand();
			String itemclass = list.get(i).getItemclass();
			String itemimage = list.get(i).getItemimage();

			// 할인된가격 표시하기
			itemprice = itemprice.replace(",", ""); // 가격에 ' , ' 빼기
			DecimalFormat dc = new DecimalFormat("###,###,###"); // 점 넣기
			double SpotDel = (double) ((Integer.parseInt(itemprice) * 0.85)); // 15%할인 적용
			String saleprice = dc.format(SpotDel); // 점 넣기

			Icon icon;
			try {
				URL url = new URL("https:" + itemimage);
				icon = new ImageIcon(url);
				Object[] data = { itemname, saleprice + " (15% SALE)", itembrand, itemclass, icon };

				tModel.addRow(data);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 근데 이렇게 하잖아?

		}

		table = new JTable(tModel) { 
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row , int column) {
			
				JComponent component = (JComponent) super.prepareRenderer(renderer, row,column);
				
				component.setBackground(Color.white);
				
				return component;
			}
		};

		resizeColumnWidth(table);
		table.setFont(new Font("맑온 고딕", Font.PLAIN, 15));
		table.setRowHeight(200);
		/*
		 * table.getColumn("상품사진").setPreferredWidth(200);
		 * table.getColumn("상품이름").setPreferredWidth(200);
		 * table.getColumn("상품종류").setPreferredWidth(3);
		 * table.getColumn("상품가격").setPreferredWidth(3);
		 * table.getColumn("상품브랜드").setPreferredWidth(3);
		 */
		table.setCellSelectionEnabled(false);
		table.addMouseListener(this);

		JScrollPane scrollPane = new JScrollPane(table);
		pan.add(scrollPane, BorderLayout.CENTER);

		btnback = new JButton("뒤로가기");
		btnback.setBackground(Color.WHITE);
		btnback.addActionListener(this);
		pan.add(btnback, BorderLayout.SOUTH);

	}


	public void resizeColumnWidth(JTable table) {

		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {

			int width = 30; // Min width for
			for (int row = 0; row < table.getRowCount(); row++) {

				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);

			}

			columnModel.getColumn(column).setPreferredWidth(width);

		}
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

		if (e.getClickCount() == 2) {
			int r = table.getSelectedRow();
			int tmp;
			tmp = l + r;
			try {
				productInfo pby = new productInfo("상품정보화면/" + id, 500, 650, tmp, id);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		if (obj == btnback) {
			mainFrame.setVisible(true);
			dispose();
		}

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
		
		
		
	}

}
