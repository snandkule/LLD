package example.interpreter;

public class DivisionExpression implements Expression{
    Expression leftExpression;
    Expression rightExpression;

    public DivisionExpression(Expression leftExpression, Expression rightExpression){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
    @Override
    public double interpret() {
        return this.leftExpression.interpret() / this.rightExpression.interpret();
    }
}
