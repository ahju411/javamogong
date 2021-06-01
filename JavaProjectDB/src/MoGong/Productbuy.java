package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class Productbuy extends JFrame implements ActionListener {

	private int res = 3;
	
	private JButton btnBuy,btnres;
	private JLabel lblimg,lblinfoimg;
	private ImageIcon img, back, infoimg;

	JLabel wait;
	private JLabel jungga;
	//private Productbuy pbv;
	

	public Productbuy(String title , int width , int height) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		//setLocation(250, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		JPanel backpan = new JPanel();
		backpan.setBackground(Color.WHITE);
		JScrollPane scrollpane = new JScrollPane(backpan);
		
		backpan.setLayout(new BorderLayout());
		
		
		// 첫번째 팬 (사진넣기)
		JPanel pan1 = new JPanel();
		img = new ImageIcon("images/gucci.png");
		img = imageSetSize(img, 200, 200);
		lblimg = new JLabel(img);
		pan1.setOpaque(false);
		pan1.add(lblimg);
		backpan.add(pan1,BorderLayout.NORTH);
		
		// 두번째 팬 ( 가격정보 및 상품정보)
		JPanel pan2 = new JPanel();
		pan2.setLayout(new GridLayout(6,1));
	
		JLabel name = new JLabel("[GG 마몽] 스몰 마틀라세 숄더백",SwingConstants.CENTER);
		JLabel jungga = new JLabel(" 정가 : 3,090,000",SwingConstants.CENTER);
		JLabel price = new JLabel("2,781,000 (10% SALE)",SwingConstants.CENTER);
		
		wait = new JLabel(" 남은 구매 예약자 : " + res + "명 ",SwingConstants.CENTER);
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
	
	public static void main(String[] args) {
		new Productbuy("상품정보화면",650,800);
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
			//pbv = new Productbuy("구매화면",650,800);
			//pbv.setLocation(900, 150);
			/*if(res > 1) {
				res--;
				wait.setText(" 남은 구매 예약자 : " + res + "명 ");
			}else if(res == 1) {
				res--;
				wait.setText(" 남은 구매 예약자 : " + res + "명 ");
				btnres.setEnabled(true);
				btnBuy.setEnabled(false);
			}*/
		}else if(obj == btnres) {
			btnres.setEnabled(false);
			btnBuy.setEnabled(true);
			res++;
			wait.setText(" 남은 구매 예약자 : " + res + "명 ");
		}
		
	}


}
