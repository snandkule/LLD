package example.editor;

import example.editor.commandPackage.Command;

import java.util.Stack;

public class TextEditorController {
    Stack<Command> commandList;
    Command command;
    private CommandLog commandLog = new CommandLog();

    public TextEditorController(){
        commandList = new Stack<>();
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton() throws Exception {
        if(command==null)throw new Exception("Coomand is not set, need to set the command first");
        this.command.execute();
        commandList.push(command);
        commandLog.log(command.toString() + " executed.");
    }

    public void pressUndo(){
        if(commandList.isEmpty())return;
        Command command1 = commandList.pop();
        command1.undo();
        commandLog.log(command1.toString() + " undone.");
    }

    public void printLog() {
        commandLog.printLogs();
    }
}
