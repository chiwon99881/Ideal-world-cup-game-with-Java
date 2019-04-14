import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class W16P8 extends JFrame implements ActionListener{
	private ImageIcon eiimage1,eiimage2;
	private JRadioButton eiimaR1,eiimaR2;
	private JLabel einameL1,einameL2;
	
	public W16P8() {
		setTitle("16∞≠");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup g = new ButtonGroup();
		
		JPanel mainP8 = new JPanel();
		add(mainP8);
		
		JLabel vsL8 = new JLabel("VS");
		vsL8.setForeground(Color.pink);
		vsL8.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 60));
		
		JPanel leftP8 = new JPanel();
		leftP8.setLayout(new BorderLayout());
		leftP8.setBackground(Color.PINK);
		
		JPanel rightP8 = new JPanel();
		rightP8.setLayout(new BorderLayout());
		rightP8.setBackground(Color.PINK);
		
		eiimage1 = new ImageIcon("worldcup/æ∆¿Ã¿Ø.jpg");
		Image image1S8 = eiimage1.getImage();
		Image change1S8 = image1S8.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi8 = new ImageIcon(change1S8);
		eiimaR1 = new JRadioButton(change1Sfi8);
		eiimaR1.addActionListener(this);
		eiimaR1.setBorderPainted(true);
		
		eiimage2 = new ImageIcon("worldcup/Ω≈∫¿º±.jpg");
		Image image2S8 = eiimage2.getImage();
		Image change2S8 = image2S8.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi8 = new ImageIcon(change2S8);
		eiimaR2 = new JRadioButton(change2Sfi8);
		eiimaR2.addActionListener(this);
		eiimaR2.setBorderPainted(true);
		
		g.add(eiimaR1);
		g.add(eiimaR2);
		
		einameL1 = new JLabel("æ∆¿Ã¿Ø",SwingConstants.CENTER);
		einameL1.setForeground(Color.white);
		einameL1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 60));
		
		einameL2 = new JLabel("Ω≈∫¿º±",SwingConstants.CENTER);
		einameL2.setForeground(Color.white);
		einameL2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 60));
		
		leftP8.add(eiimaR1,BorderLayout.CENTER);
		leftP8.add(einameL1,BorderLayout.SOUTH);
		
		rightP8.add(eiimaR2,BorderLayout.CENTER);
		rightP8.add(einameL2,BorderLayout.SOUTH);
		
		mainP8.add(leftP8);
		mainP8.add(vsL8);
		mainP8.add(rightP8);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == eiimaR1) {
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('8','ø©','æ∆¿Ã¿Ø')";
				ResultSet rs = st.executeQuery(sql);
	
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W8PS();
			setVisible(false);
		}else if(o == eiimaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('8','ø©','Ω≈∫¿º±')";
				ResultSet rs = st.executeQuery(sql);
				
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W8PS();
			setVisible(false);
		}
	}
}
