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

public class W16P1 extends JFrame implements ActionListener{
	private ImageIcon image1,image2;
	private JRadioButton imaR1,imaR2;
	private JLabel nameL1,nameL2;
	
	public W16P1() {
		
		setTitle("16∞≠");
		setSize(2000, 1000);
		setLocation(15, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainP = new JPanel();
		add(mainP);
		ButtonGroup g = new ButtonGroup();
		
		JPanel leftP = new JPanel();
		leftP.setLayout(new BorderLayout());
		leftP.setBackground(Color.PINK);
		
		JLabel vsL = new JLabel("VS");
		vsL.setForeground(Color.pink);
		vsL.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 60));
		
		JPanel rightP = new JPanel();
		rightP.setLayout(new BorderLayout());
		rightP.setBackground(Color.PINK);
		
		image1 = new ImageIcon("worldcup/±Ëªı∑–.JPG");
		Image image1S = image1.getImage();
		Image change1S = image1S.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi = new ImageIcon(change1S);
		imaR1 = new JRadioButton(change1Sfi);
		imaR1.addActionListener(this);
		imaR1.setBorderPainted(true);
		
		image2 = new ImageIcon("worldcup/±Ë¿Ø¡§.jpg");
		Image image2S = image2.getImage();
		Image change2S = image2S.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi = new ImageIcon(change2S);
		imaR2 = new JRadioButton(change2Sfi);
		imaR2.addActionListener(this);
		imaR2.setBorderPainted(true);
		
		g.add(imaR1);
		g.add(imaR2);
		
		nameL1 = new JLabel("±Ëªı∑–",SwingConstants.CENTER);
		nameL1.setForeground(Color.white);
		nameL1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 60));
		
		nameL2 = new JLabel("±Ë¿Ø¡§",SwingConstants.CENTER);
		nameL2.setForeground(Color.white);
		nameL2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 60));
		
		leftP.add(imaR1,BorderLayout.CENTER);
		leftP.add(nameL1,BorderLayout.SOUTH);
		
		rightP.add(imaR2,BorderLayout.CENTER);
		rightP.add(nameL2,BorderLayout.SOUTH);
		
		mainP.add(leftP);
		mainP.add(vsL);
		mainP.add(rightP);

		setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == imaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('1','ø©','±Ëªı∑–')";
				ResultSet rs = st.executeQuery(sql);
		
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P2();
			setVisible(false);
		}else if(o == imaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('1','ø©','±Ë¿Ø¡§')";
				ResultSet rs = st.executeQuery(sql);
		
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P2();
			setVisible(false);
		}
	}
}
