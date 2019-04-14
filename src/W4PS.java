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

public class W4PS extends JFrame implements ActionListener{
	
	private JButton W4PSb;
	
	public W4PS() {
		setTitle("4°­ ½ºÅ¸Æ®");
		setSize(2000, 1000);
		setLocation(15, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel W4PSp = new JPanel();
		W4PSp.setLayout(new BorderLayout());
		W4PSp.setBackground(Color.PINK);
		add(W4PSp);
		
		JLabel W4PSl = new JLabel("4°­",SwingConstants.CENTER);
		W4PSl.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 120));
		W4PSl.setForeground(Color.YELLOW);
		
		
		W4PSb = new JButton("Start");
		W4PSb.addActionListener(this);
		W4PSb.setBackground(Color.pink);
		W4PSb.setPreferredSize(new Dimension(720, 100));
		
		
		W4PSp.add(W4PSl,BorderLayout.CENTER);
		W4PSp.add(W4PSb,BorderLayout.SOUTH);
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == W4PSb) {
			new W4P1();
			setVisible(false);
		}
	}
}
