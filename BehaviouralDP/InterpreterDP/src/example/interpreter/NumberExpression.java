package example.interpreter;

public class NumberExpression implements Expression{

    double value;

    public NumberExpression(double value){
        this.value = value;
    }

    public double interpret(){
        return value;
    }
}
