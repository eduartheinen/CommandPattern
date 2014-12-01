package commands;

import model.Television;

public class TurnTVOff implements Command {

	private Television tv;

	public TurnTVOff(Television tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		this.tv.turnOff();
	}

	@Override
	public void undo() {
		this.tv.turnOn();
	}

}
