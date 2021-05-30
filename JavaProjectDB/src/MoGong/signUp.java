package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class signUp extends JFrame implements ActionListener {
	
	JTextField tfID, tfPassword, tfName, tfAge, tfAddress, tfPhone1, tfPhone2, tfPhone3, tfMail;
	JButton btnSignUp;

	public signUp(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(this);
		
	
		setLayout(new BorderLayout());
		
		
		JPanel leftpan = new JPanel();
		leftpan.setBackground(Color.white);
		leftpan.setBorder(new EmptyBorder(20, 30, 10, 30));
		leftpan.setLayout(new GridLayout(7, 1, 0 ,20));//같게 설정
		
		
		JPanel centerpan = new JPanel();
		centerpan.setBackground(Color.white);
		centerpan.setBorder(new EmptyBorder(20, 0, 10, 0));
		centerpan.setLayout(new GridLayout(7, 1, 0, 20));//같게 설정
		
		
		JPanel southpan = new JPanel();
		southpan.setBackground(Color.white);
		southpan.setBorder(new EmptyBorder(0, 0, 30, 0));
		southpan.setLayout(new FlowLayout());
		
		
		
		JPanel eastpan = new JPanel();
		eastpan.setBackground(Color.white);
		add(eastpan, BorderLayout.EAST);
		
		
		JPanel northpan = new JPanel();
		northpan.setBackground(Color.white);
		add(northpan, BorderLayout.NORTH);
		
		
		ImageIcon imglogo = new ImageIcon("image\\logo.png");
		JLabel logo = new JLabel(imglogo);
		northpan.add(logo, BorderLayout.NORTH);
		
		
		JLabel lblID = new JLabel("아이디 : ", JLabel.RIGHT);
		JLabel lblPassword = new JLabel("비밀번호 : ", JLabel.RIGHT);
		JLabel lblName = new JLabel("이름 : ", JLabel.RIGHT);
		JLabel lblAge = new JLabel("나이 : ", JLabel.RIGHT);
		JLabel lblAddress = new JLabel("주소 : ", JLabel.RIGHT);
		JLabel lblPhone = new JLabel("핸드폰 번호 : ", JLabel.RIGHT);
		JLabel lblMail = new JLabel("메일주소 : ", JLabel.RIGHT);
		
		tfID = new JTextField(15);
		tfPassword = new JPasswordField(15);
		tfName = new JTextField(15);
		tfAge = new JTextField(15);
		tfAddress = new JTextField(15);
		tfPhone1 = new JTextField(5);
		tfPhone2 = new JTextField(6);
		tfPhone3 = new JTextField(6);
		tfMail = new JTextField(15);
		
		ImageIcon iconSignUp = new ImageIcon("image\\signUpIcon.png");
		
		btnSignUp = new JButton("가입하기", iconSignUp);
		btnSignUp.setBackground(Color.gray);
		btnSignUp.setForeground(Color.white);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setFont(new Font("맑은 고딕", width, 20));
		btnSignUp.addActionListener(this);
		
		JPanel panPhone = new JPanel();
		panPhone.setBackground(Color.white);
		
		JLabel lblPhone1 = new JLabel("-");
		JLabel lblPhone2 = new JLabel("-");
		
		panPhone.add(tfPhone1);
		panPhone.add(lblPhone1);
		panPhone.add(tfPhone2);
		panPhone.add(lblPhone2);
		panPhone.add(tfPhone3);
		
		
		add(leftpan, BorderLayout.WEST);
		leftpan.add(lblID);
		leftpan.add(lblPassword);
		leftpan.add(lblName);
		leftpan.add(lblAge);
		leftpan.add(lblAddress);
		leftpan.add(lblPhone);
		leftpan.add(lblMail);
		
		
		add(centerpan);
		centerpan.add(tfID);
		centerpan.add(tfPassword);
		centerpan.add(tfName);
		centerpan.add(tfAge);
		centerpan.add(tfAddress);
		centerpan.add(panPhone);
		//centerpan.add(tfPhone);
		centerpan.add(tfMail);
		
		add(southpan, BorderLayout.SOUTH);
		southpan.add(btnSignUp);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btnSignUp) {
			insertMember();
			dispose();
		}
		
		
	}
	private void insertMember(){
	       
        //화면에서 사용자가 입력한 내용을 얻는다.
        Member mem = getViewData();
        MemberDB db = new MemberDB();       
        int ok = db.insertMem(mem);
       
        if(ok == 1){
           
            JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
            dispose();
           
        }else{
           
            JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");
        }
	}
        
	 public Member getViewData(){
	       
	        //화면에서 사용자가 입력한 내용을 얻는다.
	        Member mem = new Member();
	        String id = tfID.getText();
	        String pw =tfPassword.getText();
	        String name = tfName.getText();
	        String tel1 = tfPhone1.getText();
	        String tel2 = tfPhone2.getText();
	        String tel3 = tfPhone3.getText();
	        String tel = tel1+"-"+tel2+"-"+tel3;
	        String addr = tfAddress.getText();
	        int age = Integer.parseInt(tfAge.getText()); 
	        String email = tfMail.getText();
	       
	        //dto에 담는다.
	        mem.setId(id);
	        mem.setPw(pw);
	        mem.setName(name);
	        mem.setTel(tel);
	        mem.setAddr(addr);
	        mem.setEmail(email);
	        mem.setAge(age);
	       
	        return mem;
	    }

}
