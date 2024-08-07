import example.interpreter.*;

public class Main {
    public static void main(String[] args) {
        Expression expression = new AdditionExpression(
                new NumberExpression(5),
                new MultiplicationExpression(
                        new NumberExpression(10),
                        new SubtractionExpression(
                                new NumberExpression(20),
                                new NumberExpression(5)
                        )
                )
        );

        // Interpret and evaluate the expression
        double result = expression.interpret();
        System.out.println("Result: " + result);

    }
}