package example.documentGeneration;

public class ReportDocument extends DocumentTemplate{
    @Override
    protected void generateContent() {
        System.out.println("Content: Summary of the report.");
        System.out.println("Detailed analysis of the report...");
    }

    @Override
    protected String getTitle() {
        return "Monthly Report";
    }

    @Override
    protected String getDate() {
        return "August 2024";
    }
}
