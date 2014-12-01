package main;

import model.Fan;
import model.RemoteControl;
import model.Television;
import view.RemoteControlView;

import commands.Commands;
import commands.DecreaseFanVelocity;
import commands.IncreaseFanVelocity;
import commands.TurnTVOff;
import commands.TurnTVOn;

public class Main {
	public static void main(String[] args) {
		final RemoteControl control = new RemoteControl();
		Television tv = new Television();
		Fan fan = new Fan();

		control.addCommand(Commands.TURN_TV_ON, new TurnTVOn(tv));
		control.addCommand(Commands.TURN_TV_OFF, new TurnTVOff(tv));
		control.addCommand(Commands.INCREASE_FAN_VELOCITY,
				new IncreaseFanVelocity(fan));
		control.addCommand(Commands.DECREASE_FAN_VELOCITY,
				new DecreaseFanVelocity(fan));

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RemoteControlView.createAndShowGUI(control);
			}
		});
	}
}
