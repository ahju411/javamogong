package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

//asd
public class Member_List extends JFrame implements MouseListener, ActionListener {
	private JPanel pan;
	private JTable table;
	private JLabel lbl;
	private JButton btnback;
	private DefaultTableModel tModel;
	private JMenuBar menubar;
	private JMenu menures;
	private JMenuItem resall;
	
	
	public Member_List(String title, int width, int height) {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menubar = new JMenuBar();
		menubar.setBackground(Color.decode("#AAF0D1"));
		menubar.setBorderPainted(false);
		setJMenuBar(menubar);
		
		menures = new JMenu("예약현황");
		
		
		
		
		
		
		menubar.add(menures);
		
		resall = new JMenuItem("보기");
		menures.add(resall);
		resall.addActionListener(this);
		
		pan = new JPanel(new BorderLayout());
		pan.setBorder(new EmptyBorder(5,5,5,5));
		pan.setBackground(Color.decode("#CFFFE5"));
		setContentPane(pan);
		
		setJMenuBar(menubar);
		lbl = new JLabel("회원 목록");
		lbl.setFont(new Font("맑은 고딕",Font.BOLD,30));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setPreferredSize(new Dimension(400,80));
		
		pan.add(lbl,BorderLayout.NORTH);
		
		MemberDB db = new MemberDB();
		List<Member> list = db.getMemberList();
		
		String header[] = {"아이디","비밀번호","이름","나이","전화번호","주소","이메일"};
		
		tModel = new DefaultTableModel(header,0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		
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
		resizeColumnWidth(table);
		table.setFont(new Font("맑온 고딕", Font.PLAIN, 15));
		table.setRowHeight(30);
		//table.getColumn("나이").setPreferredWidth(10);
		table.setCellSelectionEnabled(false);
		table.setDragEnabled(false);
		table.getTableHeader().setBackground(Color.black);
		table.getTableHeader().setForeground(Color.white);
		table.setBackground(Color.white);
		table.setOpaque(false);
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


public void resizeColumnWidth(JTable table) {
		
		
		final TableColumnModel columnModel = table.getColumnModel(); 
	for (int column = 0; column < table.getColumnCount(); column++) {
	
		int width = 50; // Min width for 
		for(int row = 0; row < table.getRowCount(); row++) {
		
		TableCellRenderer renderer = table.getCellRenderer(row, column);
		Component comp = table.prepareRenderer(renderer, row, column); 
		width = Math.max(comp.getPreferredSize().width +1 , width); 
		
	}
		
		columnModel.getColumn(column).setPreferredWidth(width); 
		
	}
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
		if(resall == obj) {
			ReservationAll ra = new ReservationAll("예약현황");
		}
	}















	
}
