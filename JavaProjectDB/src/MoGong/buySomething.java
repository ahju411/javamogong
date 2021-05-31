package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class buySomething extends JFrame implements ActionListener {

	private String[] payment = {"카드 결제", "무통장 입금"};
	private String address = "인천시 미추홀구";//나중에 삭제할것
	
	private JButton btn;
	private JComboBox<String> cb;
	private JTextArea taAdd, taReq;
	
	public buySomething(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//맨 뒤에 오는 패널
		JPanel pan = new JPanel();
		pan.setBackground(Color.white);
		pan.setLayout(new BorderLayout());
		
		add(pan);
		
		
		JLabel lblbuy = new JLabel("결제", JLabel.CENTER);
		lblbuy.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		
		pan.add(lblbuy, BorderLayout.NORTH);

		
		JPanel panContents = new JPanel();//메인 콘텐츠 가 붙는 패널
		panContents.setBackground(Color.white);
		panContents.setBorder(new EmptyBorder(10, 10, 10, 10));
		pan.add(panContents);
		
		//1번째 줄
		JLabel lblPriceLeft = new JLabel("총 ");
		lblPriceLeft.setFont(new Font("맑은 고딕", 0, 30));
		panContents.add(lblPriceLeft);
		
		JLabel lblprice = new JLabel("2998880");//가격 표시할 레이블
		lblprice.setFont(new Font("맑은 고딕", 0, 30));
		panContents.add(lblprice);
		
		JLabel lblprice2 = new JLabel("원 입니다.");
		lblprice2.setFont(new Font("맑은 고딕", 0, 30));
		panContents.add(lblprice2);
		
		//2번째 줄
		cb = new JComboBox<String>(payment);
		panContents.add(cb);
		
		JLabel lblpay = new JLabel("으로 결제합니다");
		panContents.add(lblpay);
		
		//3번째 줄
		JLabel lbladd = new JLabel("배송은");
		panContents.add(lbladd);
		//기본 주소 불러오기 		
		taAdd = new JTextArea(address, 3, 25);
		taAdd.setBackground(Color.gray);
		
		panContents.add(taAdd);
		JLabel lbladdcheck = new JLabel("주소로 하겠습니다.");
		panContents.add(lbladdcheck);
		
		//4번째 줄
		JLabel lblrequest = new JLabel("요청사항을 입력해주세요");
		panContents.add(lblrequest);
		
		//5번째 줄?
		taReq = new JTextArea(6,30);
		panContents.add(taReq);
		taReq.setBackground(Color.gray);
		
		JPanel panPayment = new JPanel();
		panPayment.setBackground(Color.white);
		add(panPayment, BorderLayout.SOUTH);
		
		btn = new JButton("결제");
		btn.addActionListener(this);
		panPayment.add(btn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new buySomething("결제창", 400, 500);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("결제 완료");
		
	}

}
