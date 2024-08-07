import example.editor.Editor;
import example.editor.TextEditorController;
import example.editor.commandPackage.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Editor editor = new Editor();

        Command bold = new BoldCommand(editor);
        Command italic = new ItalicCommand(editor);
        Command underline = new UnderlineCommand(editor);
        Command insertHello = new InsertTextCommand(editor, "Hello ", 0);
        Command deleteHello = new DeleteTextCommand(editor, 5, 0);

        TextEditorController controller = new TextEditorController();

        // Test individual commands
        controller.setCommand(insertHello);
        controller.pressButton();

        controller.setCommand(bold);
        controller.pressButton();

        controller.setCommand(italic);
        controller.pressButton();

        controller.setCommand(deleteHello);
        controller.pressButton();

        // Test undo functionality
        controller.pressUndo();

        // Test macro command
        MacroCommand macro = new MacroCommand();
        macro.addCommand(bold);
        macro.addCommand(italic);
        controller.setCommand(macro);
        controller.pressButton();

        // Print command log
        controller.printLog();
    }
}
