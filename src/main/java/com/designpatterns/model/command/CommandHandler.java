package com.designpatterns.model.command;

import java.util.Stack;

public class CommandHandler {

    private Stack<Command> executedCommands;
    private Stack<Command> undoneCommands;

    public CommandHandler() {
        executedCommands = new Stack<>();
        undoneCommands = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        executedCommands.push(command);
        undoneCommands.clear();
    }

    public void undo() {
        if(executedCommands.isEmpty()) return;
        Command command = executedCommands.pop();
        command.undo();
        undoneCommands.push(command);
    }

    public void redo() {
        if(undoneCommands.isEmpty()) return;
        Command command = undoneCommands.pop();
        command.execute();
        executedCommands.push(command);
    }
}
