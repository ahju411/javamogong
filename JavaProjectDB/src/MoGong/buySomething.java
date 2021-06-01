package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

	static loginPage loginPage;
	
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
		pan.setBackground(Color.pink);
		pan.setLayout(new BorderLayout());
		
		add(pan);
		
		
		JLabel lblbuy = new JLabel("결제", JLabel.CENTER);
		lblbuy.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		
		pan.add(lblbuy, BorderLayout.NORTH);

		
		JPanel panContents = new JPanel();//메인 콘텐츠 가 붙는 패널
		panContents.setLayout(new GridLayout(5, 1));
		panContents.setBackground(Color.pink);
		panContents.setBorder(new EmptyBorder(30, 10, 30, 10));
		pan.add(panContents);
		
		//1번째 줄
		JPanel panCon1 = new JPanel();
		panCon1.setBackground(Color.pink);
		panContents.add(panCon1);
		
		JLabel lblProduct = new JLabel("구찌");//상품명 가져오기
		lblProduct.setFont(new Font("맑은 고딕", 0, 30));
		panCon1.add(lblProduct);
		
		JLabel lblProductRight = new JLabel("상품 결제입니다.");
		panCon1.add(lblProductRight);
		
		
		//2번째 줄
		JPanel panCon2 = new JPanel();
		panCon2.setBackground(Color.pink);
		panContents.add(panCon2);
		
		JLabel lblPriceLeft = new JLabel("총 ");
		lblPriceLeft.setFont(new Font("맑은 고딕", 0, 30));
		panCon2.add(lblPriceLeft);
		
		JLabel lblprice = new JLabel("2998880");//가격 표시할 레이블
		lblprice.setFont(new Font("맑은 고딕", 0, 30));
		panCon2.add(lblprice);
		
		JLabel lblprice2 = new JLabel("원 입니다.");
		lblprice2.setFont(new Font("맑은 고딕", 0, 30));
		panCon2.add(lblprice2);
		
		//3번째 줄
		JPanel panCon3 = new JPanel();
		panCon3.setBackground(Color.pink);
		panContents.add(panCon3);
		
		cb = new JComboBox<String>(payment);
		panCon3.add(cb);
		
		JLabel lblpay = new JLabel("으로 결제합니다");
		panCon3.add(lblpay);
		
		//4번째 줄
		JPanel panCon4 = new JPanel();
		panCon4.setBackground(Color.pink);
		panContents.add(panCon4);
		
		JLabel lbladd = new JLabel("배송은");
		panCon4.add(lbladd);
		//기본 주소 불러오기 		
		taAdd = new JTextArea(address, 3, 20);
		
		panCon4.add(taAdd);
		JLabel lbladdcheck = new JLabel("로 하겠습니다.");
		panCon4.add(lbladdcheck);
		
		//5번째 줄
		JPanel panCon5 = new JPanel();
		panCon5.setBackground(Color.pink);
		panContents.add(panCon5);
		
		JLabel lblrequest = new JLabel("요청사항을 입력해주세요");
		panCon5.add(lblrequest);
		
		taReq = new JTextArea(6,30);
		panCon5.add(taReq);
		
		JPanel panPayment = new JPanel();
		panPayment.setBackground(Color.pink);
		add(panPayment, BorderLayout.SOUTH);
		
		btn = new JButton("결제");
		btn.addActionListener(this);
		panPayment.add(btn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		buySomething bs = new buySomething("결제창", 400, 500);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		 MemberDB db = new MemberDB();
		 
		 String id = loginPage.getLogid();
		 signUp su = new signUp();
		 
		 db.getMember(id);
		 signUp su = new signUp();
		 su.signUp(id, this);
		 
		 
		 
		 String add;
		 
		 su.setTitle("22");
		
		System.out.println("결제 완료");
		
	}

}
