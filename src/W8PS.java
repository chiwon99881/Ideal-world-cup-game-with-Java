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

public class W8PS extends JFrame implements ActionListener{
	
	private JButton W8PSb;
	
	public W8PS() {
		setTitle("8°­ ½ºÅ¸Æ®");
		setSize(2000, 1000);
		setLocation(15, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel W8PSm = new JPanel();
		W8PSm.setLayout(new BorderLayout());
		W8PSm.setBackground(Color.PINK);
		add(W8PSm);
		
		JLabel W8PSl = new JLabel("8°­",SwingConstants.CENTER);
		W8PSl.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 120));
		W8PSl.setForeground(Color.YELLOW);
		
		W8PSb = new JButton("Start");
		W8PSb.addActionListener(this);
		W8PSb.setBackground(Color.pink);
		W8PSb.setPreferredSize(new Dimension(720, 100));
		
		W8PSm.add(W8PSl,BorderLayout.CENTER);
		W8PSm.add(W8PSb,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == W8PSb) {
			new W8P1();
			setVisible(false);
		}
	}
}
