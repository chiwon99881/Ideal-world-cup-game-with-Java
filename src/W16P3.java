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

public class W16P3 extends JFrame implements ActionListener{
	private ImageIcon thrimage1,thrimage2;
	private JRadioButton thrimaR1,thrimaR2;
	private JLabel thrnameL1,thrnameL2;
	
	public W16P3() {
		setTitle("16°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup g = new ButtonGroup();
		
		JPanel mainP3 = new JPanel();
		add(mainP3);
		
		JLabel vsL3 = new JLabel("VS");
		vsL3.setForeground(Color.pink);
		vsL3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		JPanel leftP3 = new JPanel();
		leftP3.setLayout(new BorderLayout());
		leftP3.setBackground(Color.PINK);
		
		JPanel rightP3 = new JPanel();
		rightP3.setLayout(new BorderLayout());
		rightP3.setBackground(Color.PINK);
		
		thrimage1 = new ImageIcon("worldcup/¾Ø ÇØ¼­¿þÀÌ.jpg");
		Image image1S3 = thrimage1.getImage();
		Image change1S3 = image1S3.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi3 = new ImageIcon(change1S3);
		thrimaR1 = new JRadioButton(change1Sfi3);
		thrimaR1.addActionListener(this);
		thrimaR1.setBorderPainted(true);
		
		thrimage2 = new ImageIcon("worldcup/¿¥¸¶½ºÅæ.jpg");
		Image image2S3 = thrimage2.getImage();
		Image change2S3 = image2S3.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi3 = new ImageIcon(change2S3);
		thrimaR2 = new JRadioButton(change2Sfi3);
		thrimaR2.addActionListener(this);
		thrimaR2.setBorderPainted(true);
		
		g.add(thrimaR1);
		g.add(thrimaR2);
		
		thrnameL1 = new JLabel("¾Ø ÇØ¼­¿þÀÌ",SwingConstants.CENTER);
		thrnameL1.setForeground(Color.white);
		thrnameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		thrnameL2 = new JLabel("¿¥¸¶½ºÅæ",SwingConstants.CENTER);
		thrnameL2.setForeground(Color.white);
		thrnameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		leftP3.add(thrimaR1,BorderLayout.CENTER);
		leftP3.add(thrnameL1,BorderLayout.SOUTH);
		
		rightP3.add(thrimaR2,BorderLayout.CENTER);
		rightP3.add(thrnameL2,BorderLayout.SOUTH);
		
		mainP3.add(leftP3);
		mainP3.add(vsL3);
		mainP3.add(rightP3);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == thrimaR1) {
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('3','¿©','¾Ø ÇØ¼­¿þÀÌ')";
				ResultSet rs = st.executeQuery(sql);
	
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P4();
			setVisible(false);
		}else if(o == thrimaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('3','¿©','¿¥¸¶½ºÅæ')";
				ResultSet rs = st.executeQuery(sql);
		
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P4();
			setVisible(false);
		}
	}
}
