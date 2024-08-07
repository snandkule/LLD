package example.interpreter;

public class SubtractionExpression implements Expression{
    Expression leftExpression;
    Expression rightExpression;

    public SubtractionExpression(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public double interpret() {
        return this.leftExpression.interpret() - this.rightExpression.interpret();
    }
}
