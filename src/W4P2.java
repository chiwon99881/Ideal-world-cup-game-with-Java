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

public class W4P2 extends JFrame implements ActionListener{
	private ImageIcon two4image1,two4image2;
	private JRadioButton two4imaR1,two4imaR2;
	private JLabel two4nameL1,two4nameL2;
	private String id1_6,id2_6,name1_6,name2_6,gender1_6,gender2_6;

	public W4P2() {
		setTitle("4°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonGroup g = new ButtonGroup();

		JPanel mainP4two = new JPanel();
		add(mainP4two);

		JLabel vsL4two = new JLabel("VS");
		vsL4two.setForeground(Color.pink);
		vsL4two.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		JPanel leftP4two = new JPanel();
		leftP4two.setLayout(new BorderLayout());
		leftP4two.setBackground(Color.PINK);

		JPanel rightP4two = new JPanel();
		rightP4two.setLayout(new BorderLayout());
		rightP4two.setBackground(Color.PINK);
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
				    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"sc",
					"sc");
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();
			
			String sql1 = "select * from W4 where nameid='3'";
			String sql2 = "select * from W4 where nameid='4'";
			
			ResultSet rs1 = st1.executeQuery(sql1);
			ResultSet rs2 = st2.executeQuery(sql2);
			
			while(rs1.next()) {
				id1_6 = rs1.getString(1);
				gender1_6 = rs1.getString(2);
				name1_6 = rs1.getString("name"); 
			}
			while(rs2.next()) {
				id2_6 = rs2.getString(1);
				gender2_6 = rs2.getString(2);
				name2_6 = rs2.getString("name"); 
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		two4image1 = new ImageIcon("worldcup/"+name1_6+".jpg");
		Image image1S1_6 = two4image1.getImage();
		Image change1S1_6 = image1S1_6.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi1_6 = new ImageIcon(change1S1_6);
		two4imaR1 = new JRadioButton(change1Sfi1_6);
		two4imaR1.addActionListener(this);
		two4imaR1.setBorderPainted(true);

		two4image2 = new ImageIcon("worldcup/"+name2_6+".jpg");
		Image image2S1_6 = two4image2.getImage();
		Image change2S1_6 = image2S1_6.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi1_6 = new ImageIcon(change2S1_6);
		two4imaR2 = new JRadioButton(change2Sfi1_6);
		two4imaR2.addActionListener(this);
		two4imaR2.setBorderPainted(true);

		g.add(two4imaR1);
		g.add(two4imaR2);

		two4nameL1 = new JLabel(name1_6,SwingConstants.CENTER);
		two4nameL1.setForeground(Color.white);
		two4nameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		two4nameL2 = new JLabel(name2_6,SwingConstants.CENTER);
		two4nameL2.setForeground(Color.white);
		two4nameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		leftP4two.add(two4imaR1,BorderLayout.CENTER);
		leftP4two.add(two4nameL1,BorderLayout.SOUTH);

		rightP4two.add(two4imaR2,BorderLayout.CENTER);
		rightP4two.add(two4nameL2,BorderLayout.SOUTH);

		mainP4two.add(leftP4two);
		mainP4two.add(vsL4two);
		mainP4two.add(rightP4two);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == two4imaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO W2 VALUES('2','¿©','"+name1_6+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new W2PS();
			setVisible(false);
		}else if(o == two4imaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO W2 VALUES('2','¿©','"+name2_6+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new W2PS();
			setVisible(false);
		}
	}
}
