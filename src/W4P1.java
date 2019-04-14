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

public class W4P1 extends JFrame implements ActionListener{
	private ImageIcon one4image1,one4image2;
	private JRadioButton one4imaR1,one4imaR2;
	private JLabel one4nameL1,one4nameL2;
	private String id1_5,id2_5,name1_5,name2_5,gender1_5,gender2_5;

	public W4P1() {
		setTitle("4°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonGroup g = new ButtonGroup();

		JPanel mainP4one = new JPanel();
		add(mainP4one);

		JLabel vsL4one = new JLabel("VS");
		vsL4one.setForeground(Color.pink);
		vsL4one.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		JPanel leftP4one = new JPanel();
		leftP4one.setLayout(new BorderLayout());
		leftP4one.setBackground(Color.PINK);

		JPanel rightP4one = new JPanel();
		rightP4one.setLayout(new BorderLayout());
		rightP4one.setBackground(Color.PINK);
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
				    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"sc",
					"sc");
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();
			
			String sql1 = "select * from W4 where nameid='1'";
			String sql2 = "select * from W4 where nameid='2'";
			
			ResultSet rs1 = st1.executeQuery(sql1);
			ResultSet rs2 = st2.executeQuery(sql2);
			
			while(rs1.next()) {
				id1_5 = rs1.getString(1);
				gender1_5 = rs1.getString(2);
				name1_5 = rs1.getString("name"); 
			}
			while(rs2.next()) {
				id2_5 = rs2.getString(1);
				gender2_5 = rs2.getString(2);
				name2_5 = rs2.getString("name"); 
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		one4image1 = new ImageIcon("worldcup/"+name1_5+".jpg");
		Image image1S1_5 = one4image1.getImage();
		Image change1S1_5 = image1S1_5.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi1_5 = new ImageIcon(change1S1_5);
		one4imaR1 = new JRadioButton(change1Sfi1_5);
		one4imaR1.addActionListener(this);
		one4imaR1.setBorderPainted(true);

		one4image2 = new ImageIcon("worldcup/"+name2_5+".jpg");
		Image image2S1_5 = one4image2.getImage();
		Image change2S1_5 = image2S1_5.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi1_5 = new ImageIcon(change2S1_5);
		one4imaR2 = new JRadioButton(change2Sfi1_5);
		one4imaR2.addActionListener(this);
		one4imaR2.setBorderPainted(true);

		g.add(one4imaR1);
		g.add(one4imaR2);

		one4nameL1 = new JLabel(name1_5,SwingConstants.CENTER);
		one4nameL1.setForeground(Color.white);
		one4nameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		one4nameL2 = new JLabel(name2_5,SwingConstants.CENTER);
		one4nameL2.setForeground(Color.white);
		one4nameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		leftP4one.add(one4imaR1,BorderLayout.CENTER);
		leftP4one.add(one4nameL1,BorderLayout.SOUTH);

		rightP4one.add(one4imaR2,BorderLayout.CENTER);
		rightP4one.add(one4nameL2,BorderLayout.SOUTH);

		mainP4one.add(leftP4one);
		mainP4one.add(vsL4one);
		mainP4one.add(rightP4one);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == one4imaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO W2 VALUES('1','¿©','"+name1_5+"')";
				ResultSet rs = st.executeQuery(sql);
				
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new W4P2();
			setVisible(false);
		}else if(o == one4imaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO W2 VALUES('1','¿©','"+name2_5+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new W4P2();
			setVisible(false);
		}
	}
}
