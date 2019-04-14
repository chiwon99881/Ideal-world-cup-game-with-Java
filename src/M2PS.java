import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class M2PS extends JFrame implements ActionListener{
	
	private JButton M2PSb;
	
	public M2PS() {
		setTitle("2°­ ½ºÅ¸Æ®");
		setSize(2000, 1000);
		setLocation(15, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel M2PSm = new JPanel();
		M2PSm.setLayout(new BorderLayout());
		M2PSm.setBackground(Color.PINK);
		add(M2PSm);
		
		JLabel M2PSl = new JLabel("2°­",SwingConstants.CENTER);
		M2PSl.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 120));
		M2PSl.setForeground(Color.YELLOW);
		
		M2PSb = new JButton("Start");
		M2PSb.addActionListener(this);
		M2PSb.setBackground(Color.pink);
		M2PSb.setPreferredSize(new Dimension(720, 100));
		
		M2PSm.add(M2PSl,BorderLayout.CENTER);
		M2PSm.add(M2PSb,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == M2PSb) {
			new M2P1();
			setVisible(false);
		}
	}
}
