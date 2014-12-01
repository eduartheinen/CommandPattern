package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import commands.Commands;

import model.RemoteControl;

public class RemoteControlView extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel jpHeader;
	private JPanel jpScreen;
	private JPanel jpButtons;
	private JButton jbTurnTVOn;
	private JButton jbTurnTVOff;
	private JButton jbIncreaseFanVelocity;
	private JButton jbDecreaseFanVelocity;
	private JButton jbUndo;

	private RemoteControl control;

	public RemoteControlView(RemoteControl control) {
		setLayout(new BorderLayout());

		configureHeader();
		configureButtons();
		configureListeners();

		this.control = control;
	}

	private void configureHeader() {
		jpHeader = new JPanel();
		JLabel jl = new JLabel("Remote Control Commander: The best ever!");
		jpHeader.add(jl);

		this.add(jpHeader, BorderLayout.NORTH);
	}

	private void configureButtons() {
		jpButtons = new JPanel();
		jpButtons.setLayout(new GridLayout(2, 2));

		jbTurnTVOn = new JButton("Ligar TV");
		jbTurnTVOff = new JButton("Desligar TV");
		jbIncreaseFanVelocity = new JButton("Aumentar Velocidade");
		jbDecreaseFanVelocity = new JButton("Diminuir Velocidade");
		jbUndo = new JButton("Desfazer");

		jpButtons.add(jbTurnTVOn);
		jpButtons.add(jbTurnTVOff);
		jpButtons.add(jbIncreaseFanVelocity);
		jpButtons.add(jbDecreaseFanVelocity);
		jpButtons.add(jbUndo);

		this.add(jpButtons, BorderLayout.CENTER);
	}

	private void configureListeners() {
		jbTurnTVOn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.pressButton(Commands.TURN_TV_ON);
			}
		});

		jbTurnTVOff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.pressButton(Commands.TURN_TV_OFF);
			}
		});

		jbIncreaseFanVelocity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				control.pressButton(Commands.INCREASE_FAN_VELOCITY);

			}
		});

		jbDecreaseFanVelocity.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				control.pressButton(Commands.DECREASE_FAN_VELOCITY);

			}
		});

		jbUndo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				control.undo();
			}
		});
	}

	public static void createAndShowGUI(RemoteControl control) {
		JFrame frame = new JFrame("Remote Control");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new RemoteControlView(control));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
