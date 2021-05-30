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

public class searchFrameID extends JFrame implements ActionListener {

	JTextField tfName, tfPhone1, tfPhone2, tfPhone3;
	JButton btn;
	
	public searchFrameID(String title, int width, int height) {
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
		panMid.setBorder(new EmptyBorder(50, 0, 30, 10));
		panMid.setLayout(new GridLayout(2,2,10,30));
		add(panMid);
		
		JLabel lblName = new JLabel("이름 : ", JLabel.RIGHT);
		panMid.add(lblName);
		
		tfName = new JTextField(15);
		panMid.add(tfName);
		
		JLabel lblPhone = new JLabel("핸드폰 번호 : ", JLabel.RIGHT);
		panMid.add(lblPhone);
		
		tfPhone1 = new JTextField(5);
		tfPhone2 = new JTextField(7);
		tfPhone3 = new JTextField(7);
		
		JPanel panPhone = new JPanel();
		panPhone.setBackground(Color.white);
		
		JLabel lblPhone1 = new JLabel("-");
		JLabel lblPhone2 = new JLabel("-");
		
		panPhone.add(tfPhone1);
		panPhone.add(lblPhone1);
		panPhone.add(tfPhone2);
		panPhone.add(lblPhone2);
		panPhone.add(tfPhone3);
		
		panMid.add(panPhone);
		
		
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
