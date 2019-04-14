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

public class W8P3 extends JFrame implements ActionListener{
	private ImageIcon thr8image1,thr8image2;
	private JRadioButton thr8imaR1,thr8imaR2;
	private JLabel thr8nameL1,thr8nameL2;
	private String id1_3,id2_3,name1_3,name2_3,gender1_3,gender2_3;

	public W8P3() {
		setTitle("8°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonGroup g = new ButtonGroup();

		JPanel mainP8thr = new JPanel();
		add(mainP8thr);

		JLabel vsL8thr = new JLabel("VS");
		vsL8thr.setForeground(Color.pink);
		vsL8thr.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		JPanel leftP8thr = new JPanel();
		leftP8thr.setLayout(new BorderLayout());
		leftP8thr.setBackground(Color.PINK);

		JPanel rightP8thr = new JPanel();
		rightP8thr.setLayout(new BorderLayout());
		rightP8thr.setBackground(Color.PINK);
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
				    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"sc",
					"sc");
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();
			
			String sql1 = "select * from W8 where nameid='5'";
			String sql2 = "select * from W8 where nameid='6'";
			
			ResultSet rs1 = st1.executeQuery(sql1);
			ResultSet rs2 = st2.executeQuery(sql2);
			
			while(rs1.next()) {
				id1_3 = rs1.getString(1);
				gender1_3 = rs1.getString(2);
				name1_3 = rs1.getString("name"); 
			}
			while(rs2.next()) {
				id2_3 = rs2.getString(1);
				gender2_3 = rs2.getString(2);
				name2_3 = rs2.getString("name"); 
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		thr8image1 = new ImageIcon("worldcup/"+name1_3+".jpg");
		Image image1S1_3 = thr8image1.getImage();
		Image change1S1_3 = image1S1_3.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi1_3 = new ImageIcon(change1S1_3);
		thr8imaR1 = new JRadioButton(change1Sfi1_3);
		thr8imaR1.addActionListener(this);
		thr8imaR1.setBorderPainted(true);

		thr8image2 = new ImageIcon("worldcup/"+name2_3+".jpg");
		Image image2S1_3 = thr8image2.getImage();
		Image change2S1_3 = image2S1_3.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi1_3 = new ImageIcon(change2S1_3);
		thr8imaR2 = new JRadioButton(change2Sfi1_3);
		thr8imaR2.addActionListener(this);
		thr8imaR2.setBorderPainted(true);

		g.add(thr8imaR1);
		g.add(thr8imaR2);

		thr8nameL1 = new JLabel(name1_3,SwingConstants.CENTER);
		thr8nameL1.setForeground(Color.white);
		thr8nameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		thr8nameL2 = new JLabel(name2_3,SwingConstants.CENTER);
		thr8nameL2.setForeground(Color.white);
		thr8nameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		leftP8thr.add(thr8imaR1,BorderLayout.CENTER);
		leftP8thr.add(thr8nameL1,BorderLayout.SOUTH);

		rightP8thr.add(thr8imaR2,BorderLayout.CENTER);
		rightP8thr.add(thr8nameL2,BorderLayout.SOUTH);

		mainP8thr.add(leftP8thr);
		mainP8thr.add(vsL8thr);
		mainP8thr.add(rightP8thr);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == thr8imaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO W4 VALUES('3','¿©','"+name1_3+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new W8P4();
			setVisible(false);
		}else if(o == thr8imaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO W4 VALUES('3','¿©','"+name2_3+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new W8P4();
			setVisible(false);
		}
	}
}
