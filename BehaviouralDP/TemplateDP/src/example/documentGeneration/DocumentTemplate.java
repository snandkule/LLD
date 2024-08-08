package example.documentGeneration;

public abstract class DocumentTemplate {

    public final void generateDocument() {
        generateHeader();
        generateContent();
        generateFooter();
    }

    private void generateHeader() {
        System.out.println("Header: Title - " + getTitle());
        System.out.println("Date: " + getDate());
    }

    private void generateFooter() {
        System.out.println("Footer: Thank you for reading.");
    }

    protected abstract void generateContent();

    protected abstract String getTitle();
    protected abstract String getDate();{
    }
}
