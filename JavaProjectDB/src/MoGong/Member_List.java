package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//asd
public class Member_List extends JFrame implements MouseListener, ActionListener {
	private JPanel pan;
	private JTable table;
	private JLabel lbl;
	private JButton btnback;
	private DefaultTableModel tModel;
	
	public Member_List(String title, int width, int height) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan = new JPanel(new BorderLayout());
		pan.setBorder(new EmptyBorder(5,5,5,5));
		pan.setBackground(Color.pink);
		setContentPane(pan);
		
		lbl = new JLabel("회원 목록");
		lbl.setFont(new Font("맑은 고딕",Font.BOLD,30));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setPreferredSize(new Dimension(400,80));
		
		pan.add(lbl,BorderLayout.NORTH);
		
		MemberDB db = new MemberDB();
		List<Member> list = db.getMemberList();
		
		String header[] = {"아이디","비밀번호","이름","나이","전화번호","주소","이메일"};
		
		tModel = new DefaultTableModel(header,0);
		
		for(int i = 0; i<list.size(); i++) {
			String id = list.get(i).getId();
			String pw = list.get(i).getPw();
			String name = list.get(i).getName();
			int age = list.get(i).getAge();
			String tel = list.get(i).getTel();
			String addr = list.get(i).getAddr();
			String email = list.get(i).getEmail();
			
			
			
			Object [] data = {id,pw,name,age,tel,addr,email};
			
			tModel.addRow(data);
		}
		
		table = new JTable(tModel);
		table.setFont(new Font("맑온 고딕", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.getColumn("나이").setPreferredWidth(10);
		table.setCellSelectionEnabled(false);
		table.addMouseListener(this);
		
		JScrollPane scrollPane = new JScrollPane(table);
		pan.add(scrollPane,BorderLayout.CENTER);
		
		btnback = new JButton("나가기");
		btnback.setFont(new Font("맑은 고딕",Font.BOLD,15));
		btnback.setOpaque(false);
		btnback.setFocusPainted(false);
		btnback.setBorderPainted(false);
		btnback.setContentAreaFilled(false);
		btnback.addActionListener(this);
		pan.add(btnback,BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		 new Member_List("회원관리창",700,500);
		 

	}






	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			int r = table.getSelectedRow();
			String id = (String)table.getValueAt(r, 0);
			MemberProc mem = new MemberProc(id,this);
		}
		
	}






	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(btnback == obj) {
			System.exit(0);
		}
		
	}
}
