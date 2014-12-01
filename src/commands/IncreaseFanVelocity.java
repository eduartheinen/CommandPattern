package commands;

import model.Fan;

public class IncreaseFanVelocity implements Command {

	private Fan fan;

	public IncreaseFanVelocity(Fan fan) {
		this.fan = fan;
	}

	@Override
	public void execute() {
		this.fan.increaseVelocity();
	}

	@Override
	public void undo() {
		this.fan.decreaseVelocity();
	}

}
