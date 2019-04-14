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

public class M4PS extends JFrame implements ActionListener{
	
	private JButton M4PSb;
	
	public M4PS() {
		setTitle("4°­ ½ºÅ¸Æ®");
		setSize(2000, 1000);
		setLocation(15, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel M4PSm = new JPanel();
		M4PSm.setLayout(new BorderLayout());
		M4PSm.setBackground(Color.PINK);
		add(M4PSm);
		
		JLabel M4PSl = new JLabel("4°­",SwingConstants.CENTER);
		M4PSl.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 120));
		M4PSl.setForeground(Color.YELLOW);
		
		M4PSb = new JButton("Start");
		M4PSb.addActionListener(this);
		M4PSb.setBackground(Color.pink);
		M4PSb.setPreferredSize(new Dimension(720, 100));
		
		M4PSm.add(M4PSl,BorderLayout.CENTER);
		M4PSm.add(M4PSb,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == M4PSb) {
			new M4P1();
			setVisible(false);
		}
	}
}
