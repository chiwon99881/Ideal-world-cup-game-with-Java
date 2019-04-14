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

public class W1P1 extends JFrame implements ActionListener{
	private ImageIcon one1image1;
	private JRadioButton one1imaR1;
	private JLabel one1nameL1,win1nameL1;
	private String id1_8,name1_8,gender1_8;

	public W1P1() {
		setTitle("¿ì½Â!");
		setSize(2000, 1000);
		setLocation(15,10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainP1one = new JPanel();
		add(mainP1one);
		
		JPanel subP1one = new JPanel();
		subP1one.setLayout(new BorderLayout());
		
		JPanel imageP1one = new JPanel();
		
		JPanel nameP1one = new JPanel();
		nameP1one.setBackground(Color.pink);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
				    "jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"sc",
					"sc");
			Statement st1 = conn.createStatement();
			
			String sql1 = "select * from W1 where nameid='1'";
			
			ResultSet rs1 = st1.executeQuery(sql1);
			
			while(rs1.next()) {
				id1_8 = rs1.getString(1);
				gender1_8 = rs1.getString(2);
				name1_8 = rs1.getString("name"); 
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		one1image1 = new ImageIcon("worldcup/"+name1_8+".jpg");
		Image image1S1_8 = one1image1.getImage();
		Image change1S1_8 = image1S1_8.getScaledInstance(750, 800, Image.SCALE_SMOOTH);
		ImageIcon change1Sfi1_8 = new ImageIcon(change1S1_8);
		one1imaR1 = new JRadioButton(change1Sfi1_8);
		one1imaR1.addActionListener(this);
		one1imaR1.setBorderPainted(true);

		imageP1one.add(one1imaR1);
			
		win1nameL1 = new JLabel("¿ì½Â :");
		win1nameL1.setForeground(Color.white);
		win1nameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));
		
		one1nameL1 = new JLabel(name1_8);
		one1nameL1.setForeground(Color.white);
		one1nameL1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 60));

		nameP1one.add(win1nameL1);
		nameP1one.add(one1nameL1);
		
		subP1one.add(imageP1one,BorderLayout.CENTER);
		subP1one.add(nameP1one,BorderLayout.SOUTH);
		
		mainP1one.add(subP1one);

		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == one1imaR1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@127.0.0.1:1521:xe",
						"sc",
						"sc");

				Statement st = conn.createStatement();
				Statement st2 = conn.createStatement();
				Statement st3 = conn.createStatement();
				Statement st4 = conn.createStatement();

				String sql = "DELETE FROM W8";
				String sql2 = "DELETE FROM W4";
				String sql3 = "DELETE FROM W2";
				String sql4 = "DELETE FROM W1";
				
				ResultSet rs = st.executeQuery(sql);
				ResultSet rs2 = st.executeQuery(sql2);
				ResultSet rs3 = st.executeQuery(sql3);
				ResultSet rs4 = st.executeQuery(sql4);

			} catch (ClassNotFoundException e2) {
				e2.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			System.exit(0);
			setVisible(false);
		}
	}
}
