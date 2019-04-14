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

public class W8P1 extends JFrame implements ActionListener{
	private ImageIcon one8image1,one8image2;
	private JRadioButton one8imaR1,one8imaR2;
	private JLabel one8nameL1,one8nameL2;
	private String id1,id2,name1,name2,gender1,gender2;

	public W8P1() {
		setTitle("8°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonGroup g = new ButtonGroup();

		JPanel mainP8one = new JPanel();
		add(mainP8one);

		JLabel vsL8one = new JLabel("VS");
		vsL8one.setForeground(Color.pink);
		vsL8one.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		JPanel leftP8one = new JPanel();
		leftP8one.setLayout(new BorderLayout());
		leftP8one.setBackground(Color.PINK);

		JPanel rightP8one = new JPanel();
		rightP8one.setLayout(new BorderLayout());
		rightP8one.setBackground(Color.PINK);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"sc",
					"sc");
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();

			String sql1 = "select * from W8 where nameid='1'";
			String sql2 = "select * from W8 where nameid='2'";

			ResultSet rs1 = st1.executeQuery(sql1);
			ResultSet rs2 = st2.executeQuery(sql2);

			while(rs1.next()) {
				id1 = rs1.getString(1);
				gender1 = rs1.getString(2);
				name1 = rs1.getString("name"); 
			}
			while(rs2.next()) {
				id2 = rs2.getString(1);
				gender2 = rs2.getString(2);
				name2 = rs2.getString("name"); 
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		one8image1 = new ImageIcon("worldcup/"+name1+".jpg");
		Image image1S1_1 = one8image1.getImage();
		Image change1S1_1 = image1S1_1.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi1_1 = new ImageIcon(change1S1_1);
		one8imaR1 = new JRadioButton(change1Sfi1_1);
		one8imaR1.addActionListener(this);
		one8imaR1.setBorderPainted(true);

		one8image2 = new ImageIcon("worldcup/"+name2+".jpg");
		Image image2S1_1 = one8image2.getImage();
		Image change2S1_1 = image2S1_1.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi1_1 = new ImageIcon(change2S1_1);
		one8imaR2 = new JRadioButton(change2Sfi1_1);
		one8imaR2.addActionListener(this);
		one8imaR2.setBorderPainted(true);

		g.add(one8imaR1);
		g.add(one8imaR2);

		one8nameL1 = new JLabel(name1,SwingConstants.CENTER);
		one8nameL1.setForeground(Color.white);
		one8nameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		one8nameL2 = new JLabel(name2,SwingConstants.CENTER);
		one8nameL2.setForeground(Color.white);
		one8nameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		leftP8one.add(one8imaR1,BorderLayout.CENTER);
		leftP8one.add(one8nameL1,BorderLayout.SOUTH);

		rightP8one.add(one8imaR2,BorderLayout.CENTER);
		rightP8one.add(one8nameL2,BorderLayout.SOUTH);

		mainP8one.add(leftP8one);
		mainP8one.add(vsL8one);
		mainP8one.add(rightP8one);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == one8imaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO W4 VALUES('1','¿©','"+name1+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new W8P2();
			setVisible(false);
		}else if(o == one8imaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO W4 VALUES('1','¿©','"+name2+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new W8P2();
			setVisible(false);
		}
	}
}
