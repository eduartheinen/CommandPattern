package commands;

import model.Fan;

public class DecreaseFanVelocity implements Command {

	private Fan fan;

	public DecreaseFanVelocity(Fan fan) {
		this.fan = fan;
	}

	@Override
	public void execute() {
		this.fan.decreaseVelocity();
	}

	@Override
	public void undo() {
		this.fan.increaseVelocity();
	}

}
