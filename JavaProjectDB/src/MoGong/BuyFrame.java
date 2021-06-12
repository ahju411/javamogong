package MoGong;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BuyFrame extends JFrame implements ActionListener {

	private ImageIcon img;
	private JLabel lblimg, jungga, price, name, lbluser, lbladdress, lblphone, lblpay;
	private JPanel photopan, productinfopan, userinfopan, paypan;
	private JTextField tfaddress, tfuser, tfphone;
	private JScrollPane scrollpane;
	private JComboBox<String> cbStr;
	private String[] strs = { "신용카드", "계좌이체", "무통장입금" };
	private JButton btnBuy;
	private int itemid;
	private String itemname, itemclass, itembrand, itemprice, itemimage;
	String id;
	productInfo productInfo;

	public BuyFrame(String title, int width, int height, int n, String id, productInfo productInfo) throws MalformedURLException {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		this.productInfo = productInfo;
		this.id = id;

		//맨 뒤에 붙는 패널 4개
		JPanel panback = new JPanel();
		panback.setLayout(new GridLayout(4, 1));
		panback.setBackground(Color.white);

		outputProductListSpec(n); // 선택한 물건 DB불러오기

		// 사진
		JPanel photopan = new JPanel();
		photopan.setBackground(Color.white);
		URL ImageURL = new URL("http:" + itemimage);
		img = new ImageIcon(ImageURL);
		lblimg = new JLabel(img);

		photopan.add(lblimg);

		// 상품정보 3개
		productinfopan = new JPanel();
		productinfopan.setLayout(new GridLayout(3, 1));
		productinfopan.setBackground(Color.white);

		DecimalFormat dc = new DecimalFormat("###,###,###"); // 가격에 반점 넣기

		String ch = dc.format(Integer.parseInt(itemprice)); // 반점넣기
		double junggaprice = (double) ((Integer.parseInt(itemprice))); //
		ch = dc.format(junggaprice);
		name = new JLabel(itemname, SwingConstants.CENTER);
		jungga = new JLabel(ch + "원", SwingConstants.CENTER); // 정가에 반점넣기

		double saleprice = junggaprice * 0.85; // 15%할인 가격 만들기
		ch = dc.format(saleprice);

		price = new JLabel(ch + "원 (15% SALE)", SwingConstants.CENTER); // 10%할인 가격넣기

		name.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		jungga.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		price.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		price.setForeground(Color.RED);

		productinfopan.add(name);
		productinfopan.add(jungga);
		productinfopan.add(price);

		// 개인정보 4개
		userinfopan = new JPanel();
		userinfopan.setLayout(new GridLayout(4, 2, 0, 30));
		userinfopan.setBackground(Color.white);

		lbladdress = new JLabel("                          주소");
		lbluser = new JLabel("                          수신자");
		lblphone = new JLabel("                          전화번호");

		tfaddress = new JTextField();
		tfuser = new JTextField();
		tfphone = new JTextField();

		lblpay = new JLabel("                          결제방법 : ");
		cbStr = new JComboBox<String>(strs);

		userinfopan.add(lbluser);
		userinfopan.add(tfuser);
		userinfopan.add(lbladdress);
		userinfopan.add(tfaddress);
		userinfopan.add(lblphone);
		userinfopan.add(tfphone);
		userinfopan.add(lblpay);
		userinfopan.add(cbStr);

		// 결제방법
		paypan = new JPanel();
		paypan.setLayout(new GridLayout(2, 1));
		paypan.setBackground(Color.white);

		btnBuy = new JButton("결제하기");
		btnBuy.addActionListener(this);
		JLabel notice = new JLabel("본 예약구매는 취소가 가능합니다.", SwingConstants.CENTER);
		notice.setForeground(Color.red);
		notice.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		paypan.add(notice);
		paypan.add(btnBuy);

		panback.add(photopan);
		panback.add(productinfopan);
		panback.add(userinfopan);
		panback.add(paypan);
		
		scrollpane = new JScrollPane(panback);
		scrollpane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollpane);
		MemberDB db = new MemberDB();
		Member mem = db.getMember(id);
		Customerinfo(mem);

		setVisible(true);

	}


	ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
		Image ximg = icon.getImage();
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	private void outputProductListSpec(int n) {
		ProductDB db = new ProductDB();
		List<productdto> list = db.getProductList();

		// i는 5의배수로 넣을예정. 총 16개

		itemid = list.get(n).getItemid();
		itemname = list.get(n).getItemname();
		//
		itemprice = list.get(n).getItemprice();
		itembrand = list.get(n).getItembrand();
		itemclass = list.get(n).getItemclass();
		itemimage = list.get(n).getItemimage();

		itemprice = itemprice.replace(",", ""); // ,을 제거하여 나중에 int로 변환하여 할인하기 편하게함.

	}

	private void Customerinfo(Member mem) {
		String name = mem.getName();
		String addr = mem.getAddr();
		String tel = mem.getTel();

		tfaddress.setText(addr);
		tfuser.setText(name);
		tfphone.setText(tel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		
		if(obj == btnBuy) {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@118.217.168.174:1521:xe", "comet", "1234");
				
				Statement stmt = conn.createStatement();
				
				ResultSet os = stmt.executeQuery("select max(orderid) from orders");
				
				int ord = 0;
				
				if(os.next()) {
					ord = os.getInt(1);
				}
				
				ord++;
				
				String address = tfaddress.getText();
				String phone = tfphone.getText();
				String name = tfuser.getText();
				
				ResultSet rs = stmt.executeQuery("INSERT INTO ORDERS(ORDERID, NAME, ID, ITEMID, ADDRESS, PHONE, STATE) VALUES ('" + ord + "', '" + name + "', '" + id + "', '" + itemid + "', '" + address + "', '" + phone + "', 1)");

				
				
				conn.close();
			} catch (ClassNotFoundException e1) {
				System.out.println("JDBC드라이버 로드 에러");
				e1.printStackTrace();
			} catch (SQLException e1) {
				System.err.println("DB연결 오류 또는 쿼리 오류 입니다.");
				e1.printStackTrace();
			}
			productInfo.getBtnBuy().setEnabled(false);
			productInfo.getBtnCancel().setEnabled(true);
			productInfo.getWait().setText(" 남은 구매 예약자 : " + (productInfo.getRes()-1) + "명 ");
			if(productInfo.getRes() == 1) {
				JOptionPane.showMessageDialog(null, "마지막 예약자입니다.배송 시작하겠습니다");
			}
		}
		
		dispose();
	}

}
