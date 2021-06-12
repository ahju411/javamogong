package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class firstpage extends JFrame implements ActionListener{

	JButton btnstart;
	JMenuBar jbar;
	JMenu ourinfo;
	JMenuItem ourinfolook;

	public firstpage(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		jbar = new JMenuBar();
		jbar.setBorderPainted(false);
		jbar.setBackground(Color.black);
		setJMenuBar(jbar);
		ourinfo = new JMenu("개발자 정보");
		ourinfo.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		ourinfo.setForeground(Color.white);
		
		jbar.add(ourinfo);
		
		ourinfolook = new JMenuItem("보기");
		ourinfolook.setBackground(Color.black);
		ourinfolook.setForeground(Color.white);
		ourinfolook.addActionListener(this);
		
		ourinfo.add(ourinfolook);
		
		
		ImageIcon img = new ImageIcon("image\\background.png");

		JLabel lbl1 = new JLabel(img);

		lbl1.setBounds(-8, 0, 495, 700);

		Panel p = new Panel();

		p.setLayout(null);
		p.add(lbl1);


		btnstart = new JButton("시작하기");
		btnstart.setFont(new Font("맑은 고딕",Font.BOLD,15));
		btnstart.setBounds(200, 350, 100, 50);
		btnstart.setOpaque(false);
		btnstart.setFocusPainted(false);
		btnstart.setBorderPainted(false);
		btnstart.setContentAreaFilled(false);
		
		btnstart.addActionListener(this);
		
		
		lbl1.add(btnstart);
		add(p);
		
		
		
		
		setVisible(true);
	}


	public static void main(String[] args) {
		new firstpage("시작 페이지", 490, 700);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btnstart) {
			loginPage lp = new loginPage();
			dispose();
		}if(obj == ourinfolook) {
			JOptionPane.showMessageDialog(null, "201845020 유은철\n201845024 이태현\n201845026 이혜성");
			
		}
		
		
	}


}
