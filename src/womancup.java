import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class womancup extends JFrame implements ActionListener{
	JPanel pp;
	JButton bb;
	ImageIcon image2;
	//public 	W16P1 w16p;

	public womancup() {
		setTitle("16강 대진표");
		setSize(2000, 1000);
		setLocation(15, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		image2 = new ImageIcon("worldcup/여자대진표.jpg");
		pp = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(image2.getImage(), 0, 0,d.width,d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		bb = new JButton("Start");
		bb.addActionListener(this);
		bb.setPreferredSize(new Dimension(200, 50));
		pp.add(bb);

		add(pp);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == bb) {
			new W16P1();
			setVisible(false);
		}

	}
}
