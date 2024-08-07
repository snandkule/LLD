package example.interpreter;

public class AdditionExpression implements Expression{
    Expression leftExpression;
    Expression rightExpression;

    public AdditionExpression(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public double interpret() {
        return this.leftExpression.interpret() + this.rightExpression.interpret();
    }
}
