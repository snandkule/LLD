package example.editor.commandPackage;

import example.editor.Editor;


public class DeleteTextCommand implements Command{
    private Editor editor;
    private int length;
    private int position;
    private String deletedText;
    public DeleteTextCommand(Editor editor, int position, int length){
        this.editor = editor;
        this.length = length;
        this.position = position;
    }
    @Override
    public void execute() {
        deletedText = this.editor.deleteText(position,length);
    }

    @Override
    public void undo() {
        this.editor.undoDeleteText(deletedText, position);
    }
}
