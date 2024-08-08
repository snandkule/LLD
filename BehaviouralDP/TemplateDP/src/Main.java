import example.documentGeneration.DocumentTemplate;
import example.documentGeneration.InvoiceDocument;
import example.documentGeneration.LetterDocument;
import example.documentGeneration.ReportDocument;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DocumentTemplate report = new ReportDocument();
        DocumentTemplate invoice = new InvoiceDocument();
        DocumentTemplate letter = new LetterDocument();

        System.out.println("Generating Report:");
        report.generateDocument();
        System.out.println();

        System.out.println("Generating Invoice:");
        invoice.generateDocument();
        System.out.println();

        System.out.println("Generating Letter:");
        letter.generateDocument();
    }
}