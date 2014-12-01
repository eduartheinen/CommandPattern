package commands;

import model.Television;

public class TurnTVOn implements Command {

	private Television tv;

	public TurnTVOn(Television tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		this.tv.turnOn();
	}

	@Override
	public void undo() {
		this.tv.turnOff();
	}

}
