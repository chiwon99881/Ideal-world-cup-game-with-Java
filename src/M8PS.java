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

public class M8PS extends JFrame implements ActionListener{
	
	private JButton M8PSb;
	
	public M8PS() {
		setTitle("8°­ ½ºÅ¸Æ®");
		setSize(2000, 1000);
		setLocation(15, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel M8PSm = new JPanel();
		M8PSm.setLayout(new BorderLayout());
		M8PSm.setBackground(Color.PINK);
		add(M8PSm);
		
		JLabel M8PSl = new JLabel("8°­",SwingConstants.CENTER);
		M8PSl.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 120));
		M8PSl.setForeground(Color.YELLOW);
		
		M8PSb = new JButton("Start");
		M8PSb.addActionListener(this);
		M8PSb.setBackground(Color.pink);
		M8PSb.setPreferredSize(new Dimension(720, 100));
		
		M8PSm.add(M8PSl,BorderLayout.CENTER);
		M8PSm.add(M8PSb,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == M8PSb) {
			new M8P1();
			setVisible(false);
		}
	}
}
