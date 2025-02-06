abstract class FunctionExpression extends Expression{
    Expression e1;
    Expression e2;
    
    FunctionExpression(Expression e1){
        this.e1 = e1;
    }
    
    FunctionExpression(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }
    
    abstract Expression execute();
    abstract Object getValue();
}