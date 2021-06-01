package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class reservation extends JFrame {

	//public showpan()[] pan = {};
	
	private JList<String> jlist;//리스트로 보여줄 예정
	
	public reservation(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JPanel panBack = new JPanel();
		panBack.setBackground(Color.white);
		panBack.setLayout(new BorderLayout());
		add(panBack);

		JLabel lblreser = new JLabel("예약현황", JLabel.CENTER);
		lblreser.setFont(new Font(title, 0, 40));
		panBack.add(lblreser, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new reservation("예약현황", 400, 600);
		
	}
	
	//아래 매서드를 배열로 선언하여 리스트로 메인에 쭉 붙임
	public void showpan(){
		JPanel panShowres = new JPanel();
		panShowres.setBackground(Color.white);
		panShowres.setLayout(new BorderLayout());
		
		//이미지 보더 left에 삽입
		//상품 이름 보더 center에 삽입
		//구매 예약인지 결제 완료인지 보더 right에 삽입
	}
	

}
