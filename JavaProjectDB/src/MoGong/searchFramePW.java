package MoGong;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class searchFramePW extends JFrame implements ActionListener {

	JTextField tfID, tfPhone, tfName;
	JButton btn;
	
	public searchFramePW(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		
		
		JPanel panNorth = new JPanel();
		panNorth.setBackground(Color.white);
		add(panNorth, BorderLayout.NORTH);
		
		ImageIcon imglogo = new ImageIcon("image\\logo.png");
		JLabel logo = new JLabel(imglogo);
		panNorth.add(logo);
		
		
		JPanel panMid = new JPanel();
		panMid.setBackground(Color.white);
		panMid.setBorder(new EmptyBorder(50, 0, 100, 50));
		panMid.setLayout(new GridLayout(3,2,10,30));
		add(panMid);
		
		JLabel lblID = new JLabel("ID : ", JLabel.RIGHT);
		panMid.add(lblID);
		
		tfID = new JTextField(15);
		panMid.add(tfID);
		
		JLabel lblName = new JLabel("이름 : ", JLabel.RIGHT);
		panMid.add(lblName);
		
		tfName = new JTextField(15);
		panMid.add(tfName);
		
		JLabel lblPhone = new JLabel("핸드폰 번호 : ", JLabel.RIGHT);
		panMid.add(lblPhone);
		
		tfPhone = new JTextField(15);
		panMid.add(tfPhone);
		
		
		JPanel panSouth = new JPanel();
		panSouth.setBackground(Color.white);
		add(panSouth, BorderLayout.SOUTH);
		
		btn = new JButton("완료");
		btn.addActionListener(this);
		panSouth.add(btn);
		
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btn) {
			dispose();
		}
		
		
	}

}
