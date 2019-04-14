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

public class M2P1 extends JFrame implements ActionListener{
	private ImageIcon one2image1,one2image2;
	private JRadioButton one2imaR1,one2imaR2;
	private JLabel one2nameL1,one2nameL2;
	private String id1_7,id2_7,name1_7,name2_7,gender1_7,gender2_7;

	public M2P1() {
		setTitle("2°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonGroup g = new ButtonGroup();

		JPanel mainP2one = new JPanel();
		add(mainP2one);

		JLabel vsL2one = new JLabel("VS");
		vsL2one.setForeground(Color.pink);
		vsL2one.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		JPanel leftP2one = new JPanel();
		leftP2one.setLayout(new BorderLayout());
		leftP2one.setBackground(Color.PINK);

		JPanel rightP2one = new JPanel();
		rightP2one.setLayout(new BorderLayout());
		rightP2one.setBackground(Color.PINK);
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
				    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"sc",
					"sc");
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();
			
			String sql1 = "select * from M2 where nameid='1'";
			String sql2 = "select * from M2 where nameid='2'";
			
			ResultSet rs1 = st1.executeQuery(sql1);
			ResultSet rs2 = st2.executeQuery(sql2);
			
			while(rs1.next()) {
				id1_7 = rs1.getString(1);
				gender1_7 = rs1.getString(2);
				name1_7 = rs1.getString("name"); 
			}
			while(rs2.next()) {
				id2_7 = rs2.getString(1);
				gender2_7 = rs2.getString(2);
				name2_7 = rs2.getString("name"); 
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		one2image1 = new ImageIcon("worldcup/"+name1_7+".jpg");
		Image image1S1_7 = one2image1.getImage();
		Image change1S1_7 = image1S1_7.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi1_7 = new ImageIcon(change1S1_7);
		one2imaR1 = new JRadioButton(change1Sfi1_7);
		one2imaR1.addActionListener(this);
		one2imaR1.setBorderPainted(true);

		one2image2 = new ImageIcon("worldcup/"+name2_7+".jpg");
		Image image2S1_7 = one2image2.getImage();
		Image change2S1_7 = image2S1_7.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi1_7 = new ImageIcon(change2S1_7);
		one2imaR2 = new JRadioButton(change2Sfi1_7);
		one2imaR2.addActionListener(this);
		one2imaR2.setBorderPainted(true);

		g.add(one2imaR1);
		g.add(one2imaR2);
		setBackground(Color.PINK);

		one2nameL1 = new JLabel(name1_7,SwingConstants.CENTER);
		one2nameL1.setForeground(Color.white);
		one2nameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		one2nameL2 = new JLabel(name2_7,SwingConstants.CENTER);
		one2nameL2.setForeground(Color.white);
		one2nameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		leftP2one.add(one2imaR1,BorderLayout.CENTER);
		leftP2one.add(one2nameL1,BorderLayout.SOUTH);

		rightP2one.add(one2imaR2,BorderLayout.CENTER);
		rightP2one.add(one2nameL2,BorderLayout.SOUTH);

		mainP2one.add(leftP2one);
		mainP2one.add(vsL2one);
		mainP2one.add(rightP2one);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == one2imaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO M1 VALUES('1','³²','"+name1_7+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new M1P1();
			setVisible(false);
		}else if(o == one2imaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO M1 VALUES('1','³²','"+name2_7+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new M1P1();
			setVisible(false);
		}
	}
}
