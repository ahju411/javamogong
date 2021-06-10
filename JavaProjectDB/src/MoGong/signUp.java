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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class signUp extends JFrame implements ActionListener {
	
	JTextField tfID, tfPassword, tfName, tfAge, tfAddress, tfPhone1, tfPhone2, tfPhone3, tfMail;
	JButton btnSignUp,btnConfirm,btnUpdate,btnDelete;
	mainFrame mainFrame;
	buySomething buySomething;

	
	public void signUp() {
		signUpUI();
		
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		
	}
	//수정용 멤버
	public void signUp(String id,mainFrame mainFrame) {
		signUpUI();
		btnConfirm.setEnabled(false);
		btnConfirm.setVisible(false);
		btnSignUp.setEnabled(false);
		btnSignUp.setVisible(false);
		
		this.mainFrame = mainFrame;
		MemberDB db = new MemberDB();
		Member mem = db.getMember(id);
		viewData(mem);
		
	}
	
	
	
	public void signUp(String id, buySomething buySomething) {
		signUpUI();
		btnConfirm.setEnabled(false);
		btnConfirm.setVisible(false);
		btnSignUp.setEnabled(false);
		btnSignUp.setVisible(false);
		
		this.buySomething = buySomething;
		MemberDB db = new MemberDB();
		Member mem = db.getMember(id);
		viewAddress(mem);
		
	}
	
	private String viewAddress(Member vMem){
	       
        String addr = vMem.getAddr();
       
        //화면에 세팅
        //taAdd.setText(addr);
        return addr;
        
    }
	
	
	
	
	
	
	private void signUpUI() {
		this.setTitle("회원가입");
		setSize(400,600);
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
		tfID = new JTextField(15);
		btnConfirm = new JButton("아이디 중복확인");
		btnConfirm.setHorizontalAlignment(SwingConstants.LEFT);
		btnConfirm.setFocusPainted(false);
		btnConfirm.setBorderPainted(false);
		btnConfirm.setBackground(Color.LIGHT_GRAY);
		btnConfirm.setFont(new Font("맑은 고딕",Font.BOLD,11));
		btnConfirm.addActionListener(this);
		JPanel idpan = new JPanel();
		idpan.setLayout(new GridLayout(1,2,5,0));
		idpan.setBackground(Color.white);
		idpan.add(tfID);
		idpan.add(btnConfirm);
		
		
		
		JPanel southpan = new JPanel();
		southpan.setBackground(Color.white);
		southpan.setBorder(new EmptyBorder(0, 0, 30, 0));
		southpan.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		
		
		
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
		btnSignUp.setFont(new Font("맑은 고딕", 0, 20));
		btnSignUp.addActionListener(this);
		
		btnUpdate = new JButton("수정");
		btnUpdate.setFocusPainted(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.setFont(new Font("맑은 고딕",Font.BOLD,11));
		btnUpdate.addActionListener(this);
		
		btnDelete = new JButton("탈퇴");
		btnDelete.setFocusPainted(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setFont(new Font("맑은 고딕",Font.BOLD,11));
		btnDelete.addActionListener(this);
		
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
		centerpan.add(idpan);
		centerpan.add(tfPassword);
		centerpan.add(tfName);
		centerpan.add(tfAge);
		centerpan.add(tfAddress);
		centerpan.add(panPhone);
		centerpan.add(tfMail);
		
		add(southpan, BorderLayout.SOUTH);
		southpan.add(btnSignUp);
		southpan.add(btnUpdate);
		southpan.add(btnDelete);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new signUp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btnSignUp) {
			insertMember();
			dispose();
		}else if(obj == btnConfirm) {
			confirmid();
		}else if(obj == btnDelete) {
			int x = JOptionPane.showConfirmDialog(this, "정말 탈퇴하시겠습니까?", "탈퇴", JOptionPane.YES_NO_OPTION);
			if(x == JOptionPane.OK_OPTION) {
				deleteMember();
			}else {
				JOptionPane.showMessageDialog(this, "탙퇴 취소");
			}
		}else if(obj == btnUpdate) {
			UpdateMember();
		}
		
	}
	private void confirmid() {
		String id = tfID.getText();
		MemberDB db = new MemberDB();
		boolean ok = db.confrimid(id);
		if(id.length()==0){ //길이가 0이면
	           
            JOptionPane.showMessageDialog(this, "아이디를 입력 해주세요");
            return; //메소드 끝
        }else {
		
		 if(ok == false) {
			
			JOptionPane.showMessageDialog(this, "아이디가 존재합니다.");
		}else {
			JOptionPane.showMessageDialog(this, "사용 가능한 아이디입니다.");
		}
        }
	}
	private void UpdateMember() {
	       
        //1. 화면의 정보를 얻는다.
        Member mem = getViewData();     
        //2. 그정보로 DB를 수정
        String pw = tfPassword.getText();
        if(pw.length()==0){ //길이가 0이면
	           
            JOptionPane.showMessageDialog(this, "수정하려면 비밀번호가 필요합니다");
            return; //메소드 끝
        }
        MemberDB db = new MemberDB();
        int ok = db.updateMember(mem);
       
        if(ok == 1){
            JOptionPane.showMessageDialog(this, "수정되었습니다.");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요");   
        }
    }
	 private void deleteMember() {
	        String id = tfID.getText();
	        String pw = tfPassword.getText();
	        if(pw.length()==0){ //길이가 0이면
	           
	            JOptionPane.showMessageDialog(this, "탈퇴하려면 비밀번호가 필요합니다");
	            return; //메소드 끝
	        }
	        //System.out.println(mList);
	        MemberDB db = new MemberDB();
	        boolean ok = db.deleteMember(id, pw);
	       
	        if(ok){
	            JOptionPane.showMessageDialog(this, "삭제완료");
	            dispose();         
	           
	        }else{
	            JOptionPane.showMessageDialog(this, "삭제실패");
	           
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
        
	private void viewData(Member vMem){
	       
        String id = vMem.getId();
        String pw = vMem.getPw();
        String name = vMem.getName();
        String tel = vMem.getTel();
        String addr = vMem.getAddr();
        String email= vMem.getEmail();
        int age = vMem.getAge();   
       
        //화면에 세팅
        tfID.setText(id);
        tfID.setEditable(false); //편집 안되게
        tfPassword.setText(""); //비밀번호는 안보여준다.
        tfName.setText(name);
        String[] tels = tel.split("-");
        tfPhone1.setText(tels[0]);
        tfPhone2.setText(tels[1]);
        tfPhone3.setText(tels[2]);
        tfAddress.setText(addr);
        tfAge.setText(Integer.toString(age));
        tfMail.setText(email);
   
       
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
