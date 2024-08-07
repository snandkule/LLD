package example.editor.commandPackage;

import example.editor.Editor;

public class InsertTextCommand implements Command{
    private Editor editor;
    private String stringToBeInserted;
    private int position;
    public InsertTextCommand(Editor editor, String stringToBeInserted, int position){
        this.editor = editor;
        this.stringToBeInserted = stringToBeInserted;
        this.position = position;
    }
    @Override
    public void execute() {
        this.editor.insertText(stringToBeInserted, position);
    }

    @Override
    public void undo() {
        this.editor.undoInsertText(stringToBeInserted, position);
    }
}