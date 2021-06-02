package MoGong;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BuyFrame extends JFrame {

	private ImageIcon img;
    private JLabel lblimg;
    private JLabel jungga,price,name;
  private  JPanel backpan,photopan,productinfopan,userinfopan,paypan;
  private JLabel lbluser,lbladdress,lblphone,lblpay;
  private JTextField address,user,phone;
  private JScrollPane scrollpane;
private JComboBox<String> cbStr;
private String[] strs = {"신용카드","계좌이체","무통장입금"};
private JButton buy;
private JLabel notice;
private int itemid;
private String itemname,itemclass,itembrand,itemprice,itemimage;
    
	public BuyFrame(String title , int width , int height, int n) throws MalformedURLException {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		backpan = new JPanel();
	   backpan.setLayout(new GridLayout(4,1));
		backpan.setBackground(Color.white);
		
		outputProductListSpec(n); //선택한 물건 DB불러오기
		
		
		// 사진
		
		JPanel photopan = new JPanel();
		URL ImageURL = new URL("http:"+itemimage);
	    img = new ImageIcon(ImageURL);
        lblimg = new JLabel(img);
		
		photopan.add(lblimg);
		
		//상품정보
		
		productinfopan = new JPanel();
		productinfopan.setLayout(new GridLayout(3,1,0,-30));
		productinfopan.setBackground(Color.white);

		
		DecimalFormat dc = new DecimalFormat("###,###,###"); // 가격에 반점 넣기 // 가격에 반점넣기
		String ch = dc.format(Integer.parseInt(itemprice)); // 반점넣기
		
	   name = new JLabel(itemname,SwingConstants.CENTER);
		jungga = new JLabel(itemprice,SwingConstants.CENTER);
		
		double saleprice =(double)((Integer.parseInt(itemprice) * 0.9)); // 10%할인 적용
	    ch = dc.format(saleprice);
		
		price = new JLabel(ch+"(10% SALE)",SwingConstants.CENTER);
		
		name.setFont(new Font("맑은 고딕",Font.BOLD,20));
		jungga.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price.setFont(new Font("맑은 고딕",Font.BOLD,25));
		price.setForeground(Color.RED);
		
		productinfopan.add(name);
		productinfopan.add(jungga);
		productinfopan.add(price);
		
		// 개인정보
		
		userinfopan = new JPanel();
        userinfopan.setLayout(new GridLayout(4,2,-100,30));
		userinfopan.setBackground(Color.white);
		
		lbladdress = new JLabel("                                  주소");
		lbluser = new JLabel("                                  수신자");
		lblphone = new JLabel("                                  전화번호");
		
		address = new JTextField();
		user = new JTextField();
		phone = new JTextField();
		
		 lblpay = new JLabel("                                  결제방법 : ");
		 cbStr = new JComboBox<String>(strs);
		
		
		userinfopan.add(lbluser);
	    userinfopan.add(user);
	 	userinfopan.add(lbladdress);
		userinfopan.add(address);
		userinfopan.add(lblphone);
		userinfopan.add(phone);
		userinfopan.add(lblpay); 
		userinfopan.add(cbStr);
		
	// 결제방법
		paypan = new JPanel();
        paypan.setLayout(new GridLayout(2,1));
		paypan.setBackground(Color.white);
	
	
		
		 buy = new JButton("결제하기");
		 notice = new JLabel("본 예약구매는 취소가 가능합니다.",SwingConstants.CENTER);
		 notice.setForeground(Color.red);
		 notice.setFont(new Font("맑은 고딕",Font.BOLD,15));
		 
		
		paypan.add(notice);
		paypan.add(buy);
		
		
		
		
		
		
		
		backpan.add(photopan);
		backpan.add(productinfopan);
		backpan.add(userinfopan);
		backpan.add(paypan);
		scrollpane = new JScrollPane(backpan);
		add(scrollpane);
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) throws MalformedURLException {

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
	 itemimage =list.get(n).getItemimage();
	
      itemprice = itemprice.replace(",", "");  // ,을 제거하여 나중에 int로 변환하여 할인하기 편하게함.

		}


}

