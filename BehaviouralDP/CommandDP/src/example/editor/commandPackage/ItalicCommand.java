package example.editor.commandPackage;
import example.editor.Editor;

public class ItalicCommand implements Command{
    private Editor editor;

    public ItalicCommand(Editor editor){
        this.editor = editor;
    }
    @Override
    public void execute() {
        this.editor.makeItalic();
    }

    @Override
    public void undo() {
        this.editor.undoItalic();
    }
}