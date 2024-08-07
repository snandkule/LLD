package example.editor.commandPackage;

import example.editor.Editor;

public class UnderlineCommand implements Command{
    private Editor editor;

    public UnderlineCommand(Editor editor){
        this.editor = editor;
    }
    @Override
    public void execute() {
        this.editor.makeUnderline();
    }

    @Override
    public void undo() {
        this.editor.undoUnderline();
    }
}