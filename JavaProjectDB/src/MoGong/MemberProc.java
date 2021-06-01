package MoGong;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import MoGong.Member;
import MoGong.MemberDB;
import java.awt.event.*;
 
public class MemberProc extends JFrame implements ActionListener {
   
   
    JPanel p;
    JTextField tfId, tfName, tfAddr, tfEmail, tfAge;
    JTextField tfTel1, tfTel2, tfTel3; //전화
    JPasswordField pfpw; //비밀번호   
    JButton btnInsert, btnCancel, btnUpdate,btnDelete; //가입, 취소, 수정 , 탈퇴 버튼
   
    GridBagLayout gb;
    GridBagConstraints gbc;
    Member_List mList ;
   
    public MemberProc(){ //가입용 생성자
       
        createUI(); // UI작성해주는 메소드
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);
        btnDelete.setEnabled(false);
        btnDelete.setVisible(false);
       
       
    }//생성자
   
//    public MemberProc(Member_List mList){ //가입용 생성자
//       
//        createUI(); // UI작성해주는 메소드
//        btnUpdate.setEnabled(false);
//        btnUpdate.setVisible(false);
//        btnDelete.setEnabled(false);
//        btnDelete.setVisible(false);
//        this.mList = mList;
//       
//    }//생성자
    public MemberProc(String id,Member_List mList){ // 수정/삭제용 생성자
        createUI();
        btnInsert.setEnabled(false);
        btnInsert.setVisible(false);
        this.mList = mList;
       
       
        System.out.println("id="+id);
       
        MemberDB db = new MemberDB();
        Member mem = db.getMember(id);
        viewData(mem);
       
       
    }//id를 가지고 생성
 
       
    //MemberDTO 의 회원 정보를 가지고 화면에 셋팅해주는 메소드
    private void viewData(Member vMem){
       
        String id = vMem.getId();
        String pw = vMem.getPw();
        String name = vMem.getName();
        String tel = vMem.getTel();
        String addr = vMem.getAddr();
        String email= vMem.getEmail();
        int age = vMem.getAge();   
       
        //화면에 세팅
        tfId.setText(id);
        tfId.setEditable(false); //편집 안되게
        pfpw.setText(""); //비밀번호는 안보여준다.
        tfName.setText(name);
        String[] tels = tel.split("-");
        tfTel1.setText(tels[0]);
        tfTel2.setText(tels[1]);
        tfTel3.setText(tels[2]);
        tfAddr.setText(addr);
        tfAge.setText(Integer.toString(age));
        tfEmail.setText(email);
   
       
    }//viewData
   
   
   
    private void createUI(){
        this.setTitle("회원가입");
        setLocation(750, 300);
        gb = new GridBagLayout();
        setLayout(gb);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        ImageIcon imgicon = new ImageIcon("mogonglogo.png");
        Image change = imgicon.getImage();
        Image changeimg = change.getScaledInstance(50, 50, DO_NOTHING_ON_CLOSE);
        ImageIcon img = new ImageIcon(changeimg);
        JLabel lblimg = new JLabel(img);
        
        gbAdd(lblimg, 0, 11, 5, 1);
       
       
        //아이디
        JLabel bId = new JLabel("아이디 : ");
        tfId = new JTextField(20);     
        //그리드백에 붙이기
        gbAdd(bId, 0, 0, 1, 1);
        gbAdd(tfId, 1, 0, 3, 1);
       
        //비밀번호
        JLabel bpw = new JLabel("비밀번호 : ");
        pfpw = new JPasswordField(20);
        gbAdd(bpw, 0, 1, 1, 1);
        gbAdd(pfpw, 1, 1, 3, 1);
       
        //이름
        JLabel bName = new JLabel("이름 :");
        tfName = new JTextField(20);
        gbAdd(bName,0,2,1,1);
        gbAdd(tfName,1,2,3,1);
        //나이
        JLabel bAge = new JLabel("나이 :");
        tfAge = new JTextField(2);
        gbAdd(bAge, 0, 3, 1, 1);
        gbAdd(tfAge, 1, 3, 3, 1);
        
        //전화
        JLabel bTel = new JLabel("전화 :");
        JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tfTel1 = new JTextField(6);    
        tfTel2 = new JTextField(6);    
        tfTel3 = new JTextField(6);
        pTel.add(tfTel1);
        pTel.add(new JLabel(" - "));
        pTel.add(tfTel2);
        pTel.add(new JLabel(" - "));
        pTel.add(tfTel3);
        gbAdd(bTel, 0, 4, 1,1);
        gbAdd(pTel, 1, 4, 3,1);
       
        //주소
        JLabel bAddr = new JLabel("주소: ");
        tfAddr = new JTextField(20);
        gbAdd(bAddr, 0,5,1,1);
        gbAdd(tfAddr, 1,5, 3,1);
       
      
       
       
       
       
        //이메일
        JLabel bEmail = new JLabel("이메일 : ");
        tfEmail = new JTextField(20);
        gbAdd(bEmail, 0,8,1,1);
        gbAdd(tfEmail,1,8,3,1);
       
 
       
        //버튼
        JPanel pButton = new JPanel();
        btnInsert = new JButton("가입");
        btnUpdate = new JButton("수정"); 
        btnDelete = new JButton("탈퇴");
        btnCancel = new JButton("취소");     
        pButton.add(btnInsert);
        pButton.add(btnUpdate);
        pButton.add(btnDelete);
        pButton.add(btnCancel);    
        gbAdd(pButton, 0, 10, 4, 1);
       
        //버튼에 감지기를 붙이자
        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnCancel.addActionListener(this);
        btnDelete.addActionListener(this);
       
        setSize(350,500);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //프로그램종료
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
       
       
    }//createUI
   
    //그리드백레이아웃에 붙이는 메소드
    private void gbAdd(JComponent c, int x, int y, int w, int h){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gb.setConstraints(c, gbc);
        gbc.insets = new Insets(2, 2, 2, 2);
        add(c, gbc);
    }//gbAdd
   
    public static void main(String[] args) {
       
        new MemberProc();
    }
   
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnInsert){
            insertMember();
            System.out.println("insertMember() 호출 종료");
        }else if(ae.getSource() == btnCancel){
            this.dispose(); //창닫기 (현재창만 닫힘)
            //system.exit(0)=> 내가 띄운 모든 창이 다 닫힘          
        }else if(ae.getSource() == btnUpdate){
            UpdateMember();            
        }else if(ae.getSource() == btnDelete){
            //int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?");
            int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
           
            if (x == JOptionPane.OK_OPTION){
                deleteMember();
            }else{
                JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
            }
        }
       
        //jTable내용 갱신 메소드 호출
       // mList.jTableRefresh();
       
    }//actionPerformed 
   
   
    private void deleteMember() {
        String id = tfId.getText();
        String pw = pfpw.getText();
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
       
    }//deleteMember
   
    private void UpdateMember() {
       
        //1. 화면의 정보를 얻는다.
        Member mem = getViewData();     
        //2. 그정보로 DB를 수정
        MemberDB db = new MemberDB();
        int ok = db.updateMember(mem);
       
        if(ok == 1){
            JOptionPane.showMessageDialog(this, "수정되었습니다.");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요");   
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
       
       
       
    }//insertMember
   
    public Member getViewData(){
       
        //화면에서 사용자가 입력한 내용을 얻는다.
        Member mem = new Member();
        String id = tfId.getText();
        String pw = pfpw.getText();
        String name = tfName.getText();
        String tel1 = tfTel1.getText();
        String tel2 = tfTel2.getText();
        String tel3 = tfTel3.getText();
        String tel = tel1+"-"+tel2+"-"+tel3;
        String addr = tfAddr.getText();
        int age = Integer.parseInt(tfAge.getText()); 
        String email = tfEmail.getText();
       
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
   
}//end