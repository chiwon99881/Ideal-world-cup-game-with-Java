import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class W2PS extends JFrame implements ActionListener{
	
	private JButton W2PSb;
	
	public W2PS() {
		setTitle("2°­ ½ºÅ¸Æ®");
		setSize(2000, 1000);
		setLocation(15, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel W2PSp = new JPanel();
		W2PSp.setLayout(new BorderLayout());
		W2PSp.setBackground(Color.PINK);
		add(W2PSp);
		
		JLabel W2PSl = new JLabel("2°­",SwingConstants.CENTER);
		W2PSl.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 120));
		W2PSl.setForeground(Color.YELLOW);
		
		
		W2PSb = new JButton("Start");
		W2PSb.addActionListener(this);
		W2PSb.setBackground(Color.pink);
		W2PSb.setPreferredSize(new Dimension(720, 100));
		
		W2PSp.add(W2PSl,BorderLayout.CENTER);
		W2PSp.add(W2PSb,BorderLayout.SOUTH);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == W2PSb) {
			new W2P1();
			setVisible(false);
		}
	}
}
