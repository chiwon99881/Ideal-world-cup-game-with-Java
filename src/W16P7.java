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

public class W16P7 extends JFrame implements ActionListener{
	private ImageIcon seimage1,seimage2;
	private JRadioButton seimaR1,seimaR2;
	private JLabel senameL1,senameL2;
	
	public W16P7() {
		setTitle("16°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup g = new ButtonGroup();
		
		JPanel mainP7 = new JPanel();
		add(mainP7);
		
		JLabel vsL7 = new JLabel("VS");
		vsL7.setForeground(Color.pink);
		vsL7.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		JPanel leftP7 = new JPanel();
		leftP7.setLayout(new BorderLayout());
		leftP7.setBackground(Color.PINK);
		
		JPanel rightP7 = new JPanel();
		rightP7.setLayout(new BorderLayout());
		rightP7.setBackground(Color.PINK);
		
		seimage1 = new ImageIcon("worldcup/Á¶ÀÌ.jpg");
		Image image1S7 = seimage1.getImage();
		Image change1S7 = image1S7.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi7 = new ImageIcon(change1S7);
		seimaR1 = new JRadioButton(change1Sfi7);
		seimaR1.addActionListener(this);
		seimaR1.setBorderPainted(true);
		
		seimage2 = new ImageIcon("worldcup/»ç³ª.jpg");
		Image image2S7 = seimage2.getImage();
		Image change2S7 = image2S7.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi7 = new ImageIcon(change2S7);
		seimaR2 = new JRadioButton(change2Sfi7);
		seimaR2.addActionListener(this);
		seimaR2.setBorderPainted(true);
		
		g.add(seimaR1);
		g.add(seimaR2);
		
		senameL1 = new JLabel("Á¶ÀÌ",SwingConstants.CENTER);
		senameL1.setForeground(Color.white);
		senameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		senameL2 = new JLabel("»ç³ª",SwingConstants.CENTER);
		senameL2.setForeground(Color.white);
		senameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		leftP7.add(seimaR1,BorderLayout.CENTER);
		leftP7.add(senameL1,BorderLayout.SOUTH);
		
		rightP7.add(seimaR2,BorderLayout.CENTER);
		rightP7.add(senameL2,BorderLayout.SOUTH);
		
		mainP7.add(leftP7);
		mainP7.add(vsL7);
		mainP7.add(rightP7);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == seimaR1) {
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('7','¿©','Á¶ÀÌ')";
				ResultSet rs = st.executeQuery(sql);
				
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P8();
			setVisible(false);
		}else if(o == seimaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('7','¿©','»ç³ª')";
				ResultSet rs = st.executeQuery(sql);
	
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P8();
			setVisible(false);
		}
	}
}
