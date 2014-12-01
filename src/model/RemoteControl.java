package model;

import java.util.HashMap;
import java.util.Stack;

import commands.Command;
import commands.Commands;

public class RemoteControl {
	private HashMap<Commands, Command> commands;
	private Stack<Command> stack;

	public RemoteControl() {
		commands = new HashMap<Commands, Command>();
		stack = new Stack<Command>();
	}

	public void addCommand(Commands name, Command command) {
		commands.put(name, command);
	}

	public void pressButton(Commands name) {
		Command lastCommand = commands.get(name);
		stack.add(lastCommand);
		lastCommand.execute();
	}

	public void undo() {
		if (!stack.isEmpty()) {
			System.out.println("houston");
			Command lastCommand = stack.pop();
			lastCommand.undo();
		}
	}

	public HashMap<Commands, Command> getCommands() {
		return this.commands;
	}
}
