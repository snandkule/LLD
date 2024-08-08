package example.documentGeneration;

public class InvoiceDocument extends DocumentTemplate{

    @Override
    protected void generateContent() {
        System.out.println("Content: Itemized list of services.");
        System.out.println("Price: $200.00");
    }

    @Override
    protected String getTitle() {
        return "Invoice #12345";
    }

    @Override
    protected String getDate() {
        return "August 8, 2024";
    }
}
