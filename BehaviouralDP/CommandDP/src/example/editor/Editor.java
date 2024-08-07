package example.editor;

public class Editor {
    StringBuilder content;

    public Editor(){
        content = new StringBuilder();
    }
    public void makeBold(){
        System.out.println("making the text bold");
    }

    public void makeItalic(){
        System.out.println("making the text italic");
    }

    public void makeUnderline(){
        System.out.println("making the text underlined");
    }

    public void insertText(String str, int position){
        content.insert(position, str);
        System.out.println("inserting the text: "+ str);
    }
    public String deleteText(int position, int length){
        String deletedString = content.substring(position,position+length);
        content.delete(position,position+length);
        System.out.println("deleting the text: "+deletedString);
        return deletedString;
    }

    public void undoBold(){
        System.out.println("Undoing the text bold");
    }

    public void undoItalic(){
        System.out.println("Undoing the text italic");
    }

    public void undoUnderline(){
        System.out.println("Undoing the text underlined");
    }

    public void undoInsertText(String str, int position){
        content.delete(position, position+str.length());
        System.out.println("Undoing insertion of the text: "+ str);
    }
    public void undoDeleteText(String deletedText, int position){
        content.insert(position,deletedText);
        System.out.println("Undoing deletion of the text from editor: "+ deletedText);
    }

}
