package example.editor.commandPackage;

import example.editor.Editor;

public class BoldCommand implements Command{
    private Editor editor;

    public BoldCommand(Editor editor){
        this.editor = editor;
    }
    @Override
    public void execute() {
        this.editor.makeBold();
    }

    @Override
    public void undo() {
        this.editor.undoBold();
    }
}
