package MoGong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class firstpage extends JFrame implements ActionListener{

	JButton btnstart;

	public firstpage(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		ImageIcon img = new ImageIcon("image\\background.png");

		JLabel lbl1 = new JLabel(img);

		lbl1.setBounds(-8, 0, 500, 700);

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
		new firstpage("시작 페이지", 500, 700);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btnstart) {
			loginPage lp = new loginPage("로그인 페이지", 450, 500);
			dispose();
		}
		
		
	}


}
