package model;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Television extends JFrame {
	private JLabel img;

	public Television() {
		super("Televisão");

		configureScreen();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 340);
		setVisible(true);
	}

	private void configureScreen() {
		java.net.URL imgURL = Television.class.getResource("../noise.gif");
		ImageIcon icon = new ImageIcon(imgURL);

		img = new JLabel();
		img.setIcon(icon);
		img.setVisible(false);

		getContentPane().add(img);
	}

	public void turnOn() {
		img.setVisible(true);
	}

	public void turnOff() {
		img.setVisible(false);
	}
}
