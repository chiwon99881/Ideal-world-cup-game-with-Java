import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Flow;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class StartFrame extends JFrame implements ActionListener{
	JPanel p1,p2;
	JButton b1,b2;
	JLabel l1,l2;
	ImageIcon image;
	JScrollPane sp;

	public StartFrame() {
		setTitle("2018 이상형 월드컵");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1500,1000);
		setLocation(500, 300);
		image = new ImageIcon("worldcup/아이린.jpg");

		p1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(image.getImage(), 0, 0,d.width,d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		p1.setLayout(new BorderLayout());

		l1 = new JLabel("2018이상형 월드컵",SwingConstants.CENTER);
		l1.setForeground(Color.YELLOW);
		l1.setFont(new Font("맑은 고딕", Font.BOLD, 60));
		l1.setOpaque(false);

		p1.add(l1,BorderLayout.CENTER);


		p2 = new JPanel();
		p2.setBackground(Color.PINK);

		b1 = new JButton("남자 버전");
		b1.setBackground(Color.PINK);
		b1.addActionListener(this);
		b1.setPreferredSize(new Dimension(720, 50));

		b2 = new JButton("여자 버전");
		b2.setBackground(Color.PINK);
		b2.addActionListener(this);
		b2.setPreferredSize(new Dimension(720, 50));


		p2.add(b1);
		p2.add(b2);

		p1.add(p2,BorderLayout.SOUTH);

		add(p1);

		setVisible(true);
	}
	public static void main(String[] args) {
		StartFrame sf = new StartFrame();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:xe",
					"sc",
					"sc");
			Statement st = conn.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == b1)
		{
			new mancup();
			setVisible(false);

		}
		if(o == b2) {
			new womancup();
			setVisible(false);
		}
	}

}
