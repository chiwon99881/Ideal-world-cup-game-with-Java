import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mancup extends JFrame implements ActionListener{
	JPanel p;
	JButton b;
	ImageIcon image1;


	public mancup() {
		setTitle("16강 대진표");
		setSize(2000, 1000);
		setLocation(15, 10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		image1 = new ImageIcon("worldcup/남자 대진표1.jpg");
		p = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(image1.getImage(), 0, 0,d.width,d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		b = new JButton("Start");
		b.addActionListener(this);
		b.setPreferredSize(new Dimension(200, 50));
		p.add(b);

		add(p);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == b) {
			new M16P1();
			setVisible(false);
		}
	}
}
