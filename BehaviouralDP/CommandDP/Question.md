**Scenario:**

You are building a simple text editor application that supports text formatting commands (like bold, italic, and underline) and text manipulation commands (like undo and redo). The editor also needs to support macro commands, which allow multiple actions to be executed as a single command, and log command history for debugging and feature tracking.

**Requirements:**

1. **Command Interface**: Create a `Command` interface with `execute()` and `undo()` methods.

2. **Concrete Commands**:
    - **Text Formatting Commands**: Implement commands to format text (e.g., bold, italic, underline).
    - **Text Manipulation Commands**: Implement commands to perform basic text manipulations like inserting or deleting text.

3. **Receiver Class**:
    - **TextEditor**: Class with methods to perform text formatting and manipulation operations. Methods might include `bold()`, `italic()`, `underline()`, `insertText(String text)`, and `deleteText(int length)`.

4. **Macro Command**: Implement a `MacroCommand` class to group multiple formatting commands into a single command.

5. **Invoker**: Implement a `TextEditorController` class that can execute commands, manage macro commands, undo and redo commands, and log command executions.

6. **Client**: Implement a test class `TextEditorTest` to demonstrate:
    - Executing individual formatting and manipulation commands.
    - Creating and executing macro commands that group multiple actions.
    - Undoing and redoing commands.
    - Viewing the command log to see the history of executed commands.

**Bonus Challenge:**
- Implement a feature to log command execution details with timestamps.
