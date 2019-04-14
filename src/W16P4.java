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

public class W16P4 extends JFrame implements ActionListener{
	private ImageIcon foimage1,foimage2;
	private JRadioButton foimaR1,foimaR2;
	private JLabel fonameL1,fonameL2;
	
	public W16P4() {
		setTitle("16∞≠");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup g = new ButtonGroup();
		
		JPanel mainP4 = new JPanel();
		add(mainP4);
		
		JLabel vsL4 = new JLabel("VS");
		vsL4.setForeground(Color.pink);
		vsL4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 60));
		
		JPanel leftP4 = new JPanel();
		leftP4.setLayout(new BorderLayout());
		leftP4.setBackground(Color.PINK);
		
		JPanel rightP4 = new JPanel();
		rightP4.setLayout(new BorderLayout());
		rightP4.setBackground(Color.PINK);
		
		foimage1 = new ImageIcon("worldcup/æ∆¿Ã∏∞.jpg");
		Image image1S4 = foimage1.getImage();
		Image change1S4 = image1S4.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi4 = new ImageIcon(change1S4);
		foimaR1 = new JRadioButton(change1Sfi4);
		foimaR1.addActionListener(this);
		foimaR1.setBorderPainted(true);
		
		foimage2 = new ImageIcon("worldcup/¬Í¿ß.jpg");
		Image image2S4 = foimage2.getImage();
		Image change2S4 = image2S4.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi4 = new ImageIcon(change2S4);
		foimaR2 = new JRadioButton(change2Sfi4);
		foimaR2.addActionListener(this);
		foimaR2.setBorderPainted(true);
		
		g.add(foimaR1);
		g.add(foimaR2);
		
		fonameL1 = new JLabel("æ∆¿Ã∏∞",SwingConstants.CENTER);
		fonameL1.setForeground(Color.white);
		fonameL1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 60));
		
		fonameL2 = new JLabel("¬Í¿ß",SwingConstants.CENTER);
		fonameL2.setForeground(Color.white);
		fonameL2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 60));
		
		leftP4.add(foimaR1,BorderLayout.CENTER);
		leftP4.add(fonameL1,BorderLayout.SOUTH);
		
		rightP4.add(foimaR2,BorderLayout.CENTER);
		rightP4.add(fonameL2,BorderLayout.SOUTH);
		
		mainP4.add(leftP4);
		mainP4.add(vsL4);
		mainP4.add(rightP4);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == foimaR1) {
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('4','ø©','æ∆¿Ã∏∞')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P5();
			setVisible(false);
		}else if(o == foimaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('4','ø©','¬Í¿ß')";
				ResultSet rs = st.executeQuery(sql);
	
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P5();
			setVisible(false);
		}
	}
}
