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

public class M16P2 extends JFrame implements ActionListener{
	private ImageIcon twoimage1,twoimage2;
	private JRadioButton twoimaR1,twoimaR2;
	private JLabel twonameL1,twonameL2;
	
	public M16P2() {
		setTitle("16°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup g = new ButtonGroup();
		
		JPanel mainP2 = new JPanel();
		add(mainP2);
		
		JLabel vsL2 = new JLabel("VS");
		vsL2.setForeground(Color.pink);
		vsL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		JPanel leftP2 = new JPanel();
		leftP2.setLayout(new BorderLayout());
		leftP2.setBackground(Color.PINK);
		
		JPanel rightP2 = new JPanel();
		rightP2.setLayout(new BorderLayout());
		rightP2.setBackground(Color.PINK);
		
		twoimage1 = new ImageIcon("worldcup/±è¹ü¼ö.jpg");
		Image image1S2 = twoimage1.getImage();
		Image change1S2 = image1S2.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi2 = new ImageIcon(change1S2);
		twoimaR1 = new JRadioButton(change1Sfi2);
		twoimaR1.addActionListener(this);
		twoimaR1.setBorderPainted(true);
		
		twoimage2 = new ImageIcon("worldcup/Çã°¢.jpg");
		Image image2S2 = twoimage2.getImage();
		Image change2S2 = image2S2.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi2 = new ImageIcon(change2S2);
		twoimaR2 = new JRadioButton(change2Sfi2);
		twoimaR2.addActionListener(this);
		twoimaR2.setBorderPainted(true);
		
		g.add(twoimaR1);
		g.add(twoimaR2);
		setBackground(Color.PINK);
		
		twonameL1 = new JLabel("±è¹ü¼ö",SwingConstants.CENTER);
		twonameL1.setForeground(Color.white);
		twonameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		twonameL2 = new JLabel("Çã°¢",SwingConstants.CENTER);
		twonameL2.setForeground(Color.white);
		twonameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		leftP2.add(twoimaR1,BorderLayout.CENTER);
		leftP2.add(twonameL1,BorderLayout.SOUTH);
		
		rightP2.add(twoimaR2,BorderLayout.CENTER);
		rightP2.add(twonameL2,BorderLayout.SOUTH);
		
		mainP2.add(leftP2);
		mainP2.add(vsL2);
		mainP2.add(rightP2);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == twoimaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO M8 VALUES('2','³²','±è¹ü¼ö')";
				ResultSet rs = st.executeQuery(sql);
	
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new M16P3();
			setVisible(false);
		}else if(o == twoimaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('2','³²','Çã°¢')";
				ResultSet rs = st.executeQuery(sql);
		
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new M16P3();
			setVisible(false);
		}
	}
}
