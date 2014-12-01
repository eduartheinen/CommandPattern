package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fan extends JFrame {
	private int velocity;
	private List<ImageIcon> fanVelocities;
	private JLabel img;

	public Fan() {
		super("Fan");
		configureVelocities();
		configureScreen();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 480);
		setVisible(true);
	}

	private void configureVelocities() {

		fanVelocities = new ArrayList<ImageIcon>();
		String[] fileNames = { "small-fan.jpg", "med-fan.jpg", "big-fan.jpg" };

		for (String filename : fileNames) {
			java.net.URL imgURL = Television.class
					.getResource("../" + filename);
			ImageIcon icon = new ImageIcon(imgURL);
			fanVelocities.add(icon);
		}
	}

	private void configureScreen() {
		img = new JLabel();
		img.setIcon(fanVelocities.get(velocity));

		getContentPane().add(img);
	}

	private void changeVelocity() {
		img.setIcon(fanVelocities.get(velocity));
	}

	public void increaseVelocity() {
		if (velocity < 2) {
			velocity++;
			changeVelocity();
		}
	}

	public void decreaseVelocity() {
		if (velocity > 0) {
			velocity--;
			changeVelocity();
		}
	}
}
