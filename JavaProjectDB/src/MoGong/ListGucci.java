package MoGong;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ListGucci extends JFrame {

	


	public ListGucci(String title , int width , int height) throws IOException {
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		new ListGucci("MyFrame",300,200);
	}

}
