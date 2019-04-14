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

public class W16P6 extends JFrame implements ActionListener{
	private ImageIcon siimage1,siimage2;
	private JRadioButton siimaR1,siimaR2;
	private JLabel sinameL1,sinameL2;
	
	public W16P6() {
		setTitle("16강");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup g = new ButtonGroup();
		
		JPanel mainP6 = new JPanel();
		add(mainP6);
		
		JLabel vsL6 = new JLabel("VS");
		vsL6.setForeground(Color.pink);
		vsL6.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		
		JPanel leftP6 = new JPanel();
		leftP6.setLayout(new BorderLayout());
		leftP6.setBackground(Color.PINK);
		
		JPanel rightP6 = new JPanel();
		rightP6.setLayout(new BorderLayout());
		rightP6.setBackground(Color.PINK);
		
		siimage1 = new ImageIcon("worldcup/크리스틴 스튜어트.jpg");
		Image image1S6 = siimage1.getImage();
		Image change1S6 = image1S6.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi6 = new ImageIcon(change1S6);
		siimaR1 = new JRadioButton(change1Sfi6);
		siimaR1.addActionListener(this);
		siimaR1.setBorderPainted(true);
		
		siimage2 = new ImageIcon("worldcup/한예슬.jpg");
		Image image2S6 = siimage2.getImage();
		Image change2S6 = image2S6.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi6 = new ImageIcon(change2S6);
		siimaR2 = new JRadioButton(change2Sfi6);
		siimaR2.addActionListener(this);
		siimaR2.setBorderPainted(true);
		
		g.add(siimaR1);
		g.add(siimaR2);
		
		sinameL1 = new JLabel("크리스틴 스튜어트",SwingConstants.CENTER);
		sinameL1.setForeground(Color.white);
		sinameL1.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		
		sinameL2 = new JLabel("한예슬",SwingConstants.CENTER);
		sinameL2.setForeground(Color.white);
		sinameL2.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		
		leftP6.add(siimaR1,BorderLayout.CENTER);
		leftP6.add(sinameL1,BorderLayout.SOUTH);
		
		rightP6.add(siimaR2,BorderLayout.CENTER);
		rightP6.add(sinameL2,BorderLayout.SOUTH);
		
		mainP6.add(leftP6);
		mainP6.add(vsL6);
		mainP6.add(rightP6);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == siimaR1) {
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('6','여','크리스틴 스튜어트')";
				ResultSet rs = st.executeQuery(sql);
	
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P7();
			setVisible(false);
		}else if(o == siimaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
					    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");
				
				Statement st = conn.createStatement();
				
				String sql = "INSERT INTO W8 VALUES('6','여','한예슬')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			new W16P7();
			setVisible(false);
		}
	}
}
