package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Productbuy extends JFrame {

	
private JPanel backpan;
private JPanel pan1,pan2,pan3,pan4;
private JPanel subpan2_1;
private JButton but1,but2;
private JLabel lblimg,lblinfoimg;
private JLabel name,price,info,wait;
private ImageIcon img,back,infoimg;
private JScrollPane scrollpane;
private JLabel jungga;
	
	

	public Productbuy(String title , int width , int height) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
		
		backpan = new JPanel();
		backpan.setBackground(Color.WHITE);
		scrollpane = new JScrollPane(backpan);
		
		backpan.setLayout(new BorderLayout());
		
		
		// 첫번째 팬 ( 사진넣기)
		
		pan1 = new JPanel();
		img = new ImageIcon("images/gucci.png");
		img = imageSetSize(img, 200, 200);
		lblimg = new JLabel(img);
		pan1.setOpaque(false);
		pan1.add(lblimg);
		backpan.add(pan1,BorderLayout.NORTH);
		
		// 두번째 팬 ( 가격정보 및 상품정보)
		
		pan2 = new JPanel();
		pan2.setLayout(new GridLayout(6,1));
		
		
	
		name = new JLabel("[GG 마몽] 스몰 마틀라세 숄더백",SwingConstants.CENTER);
		jungga = new JLabel(" 정가 : 3,090,000",SwingConstants.CENTER);
		price = new JLabel("2,781,000 (10% SALE)",SwingConstants.CENTER);
		
		wait = new JLabel(" 남은 구매 예약자 : 3명 ",SwingConstants.CENTER);
		pan2.add(name);
		pan2.add(jungga);
		pan2.add(price);
		pan2.add(wait);
		
		// 폰트설정
		name.setFont(new Font("맑은 고딕",Font.BOLD,35));
		jungga.setFont(new Font("맑은 고딕",Font.BOLD,15));
		price.setFont(new Font("맑은 고딕",Font.BOLD,30));
		price.setForeground(Color.RED);

		wait.setFont(new Font("맑은 고딕",Font.BOLD,20));
		wait.setForeground(Color.RED);
		
		subpan2_1 = new JPanel();
		
		but1= new JButton("구매예약");
		but2= new JButton("예약취소");
		but2.setEnabled(false);

		
		subpan2_1.add(but1);
        subpan2_1.add(but2);
		subpan2_1.setOpaque(false);
		pan2.add(subpan2_1);
		
		
		pan2.setOpaque(false);
		
		
	
		
		// 상품정보 pan3
		
		pan3 = new JPanel();
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
	
	public static void main(String[] args) {
		new Productbuy("상품정보화면",650,800);
	}




ImageIcon imageSetSize(ImageIcon icon, int i, int j) {
	Image ximg = icon.getImage();
	Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
	ImageIcon xyimg = new ImageIcon(yimg);
	return xyimg;
}
}
