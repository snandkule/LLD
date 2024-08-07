package example.editor.commandPackage;

import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements Command{
    List<Command> list;

    public MacroCommand(){
        list = new ArrayList<>();
    }

    public void addCommand(Command command){
        this.list.add(command);
    }
    @Override
    public void execute() {
        for(Command command: list){
            command.execute();
        }
    }

    @Override
    public void undo() {
        for(Command command: list){
            command.undo();
        }
    }
}
