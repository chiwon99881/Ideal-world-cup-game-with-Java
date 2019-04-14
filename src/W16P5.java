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

public class W16P5 extends JFrame implements ActionListener{
	private ImageIcon fiimage1,fiimage2;
	private JRadioButton fiimaR1,fiimaR2;
	private JLabel finameL1,finameL2;
	
	public W16P5() {
		setTitle("16°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup g = new ButtonGroup();
		
		JPanel mainP5 = new JPanel();
		add(mainP5);
		
		JLabel vsL5 = new JLabel("VS");
		vsL5.setForeground(Color.pink);
		vsL5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		JPanel leftP5 = new JPanel();
		leftP5.setLayout(new BorderLayout());
		leftP5.setBackground(Color.PINK);
		
		JPanel rightP5 = new JPanel();
		rightP5.setLayout(new BorderLayout());
		rightP5.setBackground(Color.PINK);
		
		fiimage1 = new ImageIcon("worldcup/Ãµ¿ìÈñ.jpg");
		Image image1S5 = fiimage1.getImage();
		Image change1S5 = image1S5.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi5 = new ImageIcon(change1S5);
		fiimaR1 = new JRadioButton(change1Sfi5);
		fiimaR1.addActionListener(this);
		fiimaR1.setBorderPainted(true);
		
		fiimage2 = new ImageIcon("worldcup/À¯¶ó.jpg");
		Image image2S5 = fiimage2.getImage();
		Image change2S5 = image2S5.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi5 = new ImageIcon(change2S5);
		fiimaR2 = new JRadioButton(change2Sfi5);
		fiimaR2.addActionListener(this);
		fiimaR2.setBorderPainted(true);
		
		g.add(fiimaR1);
		g.add(fiimaR2);
		
		finameL1 = new JLabel("Ãµ¿ìÈñ",SwingConstants.CENTER);
		finameL1.setForeground(Color.white);
		finameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		finameL2 = new JLabel("À¯¶ó",SwingConstants.CENTER);
		finameL2.setForeground(Color.white);
		finameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		leftP5.add(fiimaR1,BorderLayout.CENTER);
		leftP5.add(finameL1,BorderLayout.SOUTH);
		
		rightP5.add(fiimaR2,BorderLayout.CENTER);
		rightP5.add(finameL2,BorderLayout.SOUTH);
		
		mainP5.add(leftP5);
		mainP5.add(vsL5);
		mainP5.add(rightP5);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == fiimaR1) {
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('5','¿©','Ãµ¿ìÈñ')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P6();
			setVisible(false);
		}else if(o == fiimaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('5','¿©','À¯¶ó')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P6();
			setVisible(false);
		}
	}
}
