package example.interpreter;

public class MultiplicationExpression implements Expression{
    Expression leftExpression;
    Expression rightExpression;

    public MultiplicationExpression(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public double interpret() {
        return this.leftExpression.interpret() * this.rightExpression.interpret();
    }
}
