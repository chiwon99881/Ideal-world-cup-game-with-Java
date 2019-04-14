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

public class M8P4 extends JFrame implements ActionListener{
	private ImageIcon fo8image1,fo8image2;
	private JRadioButton fo8imaR1,fo8imaR2;
	private JLabel fo8nameL1,fo8nameL2;
	private String id1_4,id2_4,name1_4,name2_4,gender1_4,gender2_4;

	public M8P4() {
		setTitle("8°­");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ButtonGroup g = new ButtonGroup();

		JPanel mainP8fo = new JPanel();
		add(mainP8fo);

		JLabel vsL8fo = new JLabel("VS");
		vsL8fo.setForeground(Color.pink);
		vsL8fo.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		JPanel leftP8fo = new JPanel();
		leftP8fo.setLayout(new BorderLayout());
		leftP8fo.setBackground(Color.PINK);

		JPanel rightP8fo = new JPanel();
		rightP8fo.setLayout(new BorderLayout());
		rightP8fo.setBackground(Color.PINK);
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
				    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"sc",
					"sc");
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();
			
			String sql1 = "select * from M8 where nameid='7'";
			String sql2 = "select * from M8 where nameid='8'";
			
			ResultSet rs1 = st1.executeQuery(sql1);
			ResultSet rs2 = st2.executeQuery(sql2);
			
			while(rs1.next()) {
				id1_4 = rs1.getString(1);
				gender1_4 = rs1.getString(2);
				name1_4 = rs1.getString("name"); 
			}
			while(rs2.next()) {
				id2_4 = rs2.getString(1);
				gender2_4 = rs2.getString(2);
				name2_4 = rs2.getString("name"); 
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		fo8image1 = new ImageIcon("worldcup/"+name1_4+".jpg");
		Image image1S1_4 = fo8image1.getImage();
		Image change1S1_4 = image1S1_4.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi1_4 = new ImageIcon(change1S1_4);
		fo8imaR1 = new JRadioButton(change1Sfi1_4);
		fo8imaR1.addActionListener(this);
		fo8imaR1.setBorderPainted(true);

		fo8image2 = new ImageIcon("worldcup/"+name2_4+".jpg");
		Image image2S1_4 = fo8image2.getImage();
		Image change2S1_4 = image2S1_4.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change2Sfi1_4 = new ImageIcon(change2S1_4);
		fo8imaR2 = new JRadioButton(change2Sfi1_4);
		fo8imaR2.addActionListener(this);
		fo8imaR2.setBorderPainted(true);

		g.add(fo8imaR1);
		g.add(fo8imaR2);
		setBackground(Color.PINK);

		fo8nameL1 = new JLabel(name1_4,SwingConstants.CENTER);
		fo8nameL1.setForeground(Color.white);
		fo8nameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		fo8nameL2 = new JLabel(name2_4,SwingConstants.CENTER);
		fo8nameL2.setForeground(Color.white);
		fo8nameL2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		leftP8fo.add(fo8imaR1,BorderLayout.CENTER);
		leftP8fo.add(fo8nameL1,BorderLayout.SOUTH);

		rightP8fo.add(fo8imaR2,BorderLayout.CENTER);
		rightP8fo.add(fo8nameL2,BorderLayout.SOUTH);

		mainP8fo.add(leftP8fo);
		mainP8fo.add(vsL8fo);
		mainP8fo.add(rightP8fo);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == fo8imaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO M4 VALUES('4','³²','"+name1_4+"')";
				ResultSet rs = st.executeQuery(sql);
				
			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new M4PS();
			setVisible(false);
		}else if(o == fo8imaR2) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();

				String sql = "INSERT INTO M4 VALUES('4','³²','"+name2_4+"')";
				ResultSet rs = st.executeQuery(sql);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			new M4PS();
			setVisible(false);
		}
	}
}
