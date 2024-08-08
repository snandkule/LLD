package example.documentGeneration;

public class LetterDocument extends DocumentTemplate{
    @Override
    protected void generateContent() {
        System.out.println("Content: Dear Sir/Madam,");
        System.out.println("Thank you for your continued support.");
        System.out.println("Sincerely, Your Company");
    }

    @Override
    protected String getTitle() {
        return "Letter of Appreciation";
    }

    @Override
    protected String getDate() {
        return "August 8, 2024";
    }
}
