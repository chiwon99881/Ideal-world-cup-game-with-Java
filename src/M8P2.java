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

public class M8P2 extends JFrame implements ActionListener{
	private ImageIcon two8image1,two8image2;
	private JRadioButton two8imaR1,two8imaR2;
	private JLabel two8nameL1,two8nameL2;
	private String id1_2,id2_2,name1_2,name2_2,gender1_2,gender2_2;

	public M8P2() {
		setTitle("8°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonGroup g = new ButtonGroup();

		JPanel mainP8two = new JPanel();
		add(mainP8two);

		JLabel vsL8two = new JLabel("VS");
		vsL8two.setForeground(Color.pink);
		vsL8two.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		JPanel leftP8two = new JPanel();
		leftP8two.setLayout(new BorderLayout());
		leftP8two.setBackground(Color.PINK);

		JPanel rightP8two = new JPanel();
		rightP8two.setLayout(new BorderLayout());
		rightP8two.setBackground(Color.PINK);
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
				    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"sc",
					"sc");
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();
			
			String sql1 = "select * from M8 where nameid='3'";
			String sql2 = "select * from M8 where nameid='4'";
			
			ResultSet rs1 = st1.executeQuery(sql1);
			ResultSet rs2 = st2.executeQuery(sql2);
			
			while(rs1.next()) {
				id1_2 = rs1.getString(1);
				gender1_2 = rs1.getString(2);
				name1_2 = rs1.getString("name"); 
			}
			while(rs2.next()) {
				id2_2 = rs2.getString(1);
				gender2_2 = rs2.getString(2);
				name2_2 = rs2.getString("name"); 
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		two8image1 = new ImageIcon("worldcup/"+name1_2+".jpg");
		Image image1S1_2 = two8image1.getImage();
		Image change1S1_2 = image1S1_2.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi1_2 = new ImageIcon(change1S1_2);
		two8imaR1 = new JRadioButton(change1Sfi1_2);
		two8imaR1.addActionListener(this);
		two8imaR1.setBorderPainted(true);

		two8image2 = new ImageIcon("worldcup/"+name2_2+".jpg");
		Image image2S1_2 = two8image2.getImage();
		Image change2S1_2 = image2S1_2.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi1_2 = new ImageIcon(change2S1_2);
		two8imaR2 = new JRadioButton(change2Sfi1_2);
		two8imaR2.addActionListener(this);
		two8imaR2.setBorderPainted(true);

		g.add(two8imaR1);
		g.add(two8imaR2);
		setBackground(Color.PINK);

		two8nameL1 = new JLabel(name1_2,SwingConstants.CENTER);
		two8nameL1.setForeground(Color.white);
		two8nameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		two8nameL2 = new JLabel(name2_2,SwingConstants.CENTER);
		two8nameL2.setForeground(Color.white);
		two8nameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		leftP8two.add(two8imaR1,BorderLayout.CENTER);
		leftP8two.add(two8nameL1,BorderLayout.SOUTH);

		rightP8two.add(two8imaR2,BorderLayout.CENTER);
		rightP8two.add(two8nameL2,BorderLayout.SOUTH);

		mainP8two.add(leftP8two);
		mainP8two.add(vsL8two);
		mainP8two.add(rightP8two);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == two8imaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO M4 VALUES('2','³²','"+name1_2+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new M8P3();
			setVisible(false);
		}else if(o == two8imaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO M4 VALUES('2','³²','"+name2_2+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new M8P3();
			setVisible(false);
		}
	}
}
