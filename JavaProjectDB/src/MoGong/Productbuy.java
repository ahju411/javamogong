package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class Productbuy extends JFrame implements ActionListener {

	private int res = 10;
	
	private JButton btnBuy,btnres;
	private JLabel lblimg,lblinfoimg;
	private ImageIcon img, back, infoimg;

	JLabel wait;
	private JLabel jungga;

	private String itemname;

	private String itemprice;

	private String itembrand;

	private String itemclass;

	private String itemimage;

	private Object itemid;
	

	public Productbuy(String title , int width , int height, int n) throws MalformedURLException {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		//setLocation(250, 150);
	
		
		JPanel backpan = new JPanel();
		backpan.setBackground(Color.WHITE);
		JScrollPane scrollpane = new JScrollPane(backpan);
		
		backpan.setLayout(new BorderLayout());
		
		outputProductListSpec(n);
		
		// 첫번째 팬 (사진넣기)
		JPanel pan1 = new JPanel();
		URL ImageURL = new URL("http:"+itemimage);
	    img = new ImageIcon(ImageURL);
        lblimg = new JLabel(img);
        
		pan1.setOpaque(false);
		pan1.add(lblimg);
		backpan.add(pan1,BorderLayout.NORTH);
		
		// 두번째 팬 ( 가격정보 및 상품정보)
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(6,1));
		DecimalFormat dc = new DecimalFormat("###,###,###"); // 가격에 반점 넣기
	
		JLabel name = new JLabel(itemname,SwingConstants.CENTER);
		
		String ch = dc.format(Integer.parseInt(itemprice)); // 반점넣기
		
		JLabel jungga = new JLabel(ch+"원",SwingConstants.CENTER);
		
		double saleprice =((Integer.parseInt(itemprice) * 0.9)); // 10%할인 적용
	
		ch = dc.format(saleprice);
		JLabel price = new JLabel(ch+"원 (10% SALE)",SwingConstants.CENTER);
		
		wait = new JLabel(" 남은 구매 예약자 : " + res + "명 ",SwingConstants.CENTER);
		pan2.add(name);
		pan2.add(jungga);
		pan2.add(price);
		pan2.add(wait);
		
		// 폰트설정
		name.setFont(new Font("맑은 고딕",Font.BOLD,12));
		jungga.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price.setFont(new Font("맑은 고딕",Font.BOLD,30));
		price.setForeground(Color.RED);

		wait.setFont(new Font("맑은 고딕",Font.BOLD,20));
		wait.setForeground(Color.RED);
		
		JPanel subpan2_1 = new JPanel();
		
		btnBuy= new JButton("구매예약");
		btnBuy.addActionListener(this);
		
		btnres= new JButton("예약취소");
		btnres.addActionListener(this);
		btnres.setEnabled(false);

		
		subpan2_1.add(btnBuy);
        subpan2_1.add(btnres);
		subpan2_1.setOpaque(false);
		pan2.add(subpan2_1);
		
		
		pan2.setOpaque(false);
		
		
	
		
		// 상품정보 pan3
		JPanel pan3 = new JPanel();
		pan3.setLayout(new GridLayout());
		
		infoimg = new ImageIcon("images/info2.png");
		infoimg = imageSetSize(infoimg, 600, 2000);
		lblinfoimg = new JLabel(infoimg);
		
		pan3.add(lblinfoimg);
		pan3.setOpaque(false);
		

        
		backpan.add(pan2);
		backpan.add(pan3,BorderLayout.SOUTH);
		
		
		
		add(scrollpane);
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
		new Productbuy("상품정보화면", 650, 800, 4);
	
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
System.out.println("점없앤 itemprice : " +itemprice);
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
		
		if(obj == btnBuy) {
			btnres.setEnabled(true);
			btnBuy.setEnabled(false);
			res--;
			wait.setText(" 남은 구매 예약자 : " + res + "명 ");
			buySomething bs = new buySomething();
		}else if(obj == btnres) {
			btnres.setEnabled(false);
			btnBuy.setEnabled(true);
			res++;
			wait.setText(" 남은 구매 예약자 : " + res + "명 ");
		}
		
	}


}
