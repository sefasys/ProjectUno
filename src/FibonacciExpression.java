
class FibonacciExpression extends FunctionExpression{

    public FibonacciExpression(Expression e1) {
        super(e1);    
    }
    
    
    @Override 
    Expression execute(){
        Object obj = getValue();    
        return new IntegerLiteral((int) obj);
    }
    
    @Override 
    Object getValue(){
        Expression e2 = new IntegerLiteral((int)(e1.getValue())-1); // -0 ve -1 yapınca indexe göre tek sayıları veriyor.
        Expression e3 = new IntegerLiteral((int)(e1.getValue())-2);
        ConditionalExpression con = new ConditionalExpression(e1, new IntegerLiteral(1), ConditionalOperator.LessEqual);
        IfExpression exp = new IfExpression(con, e1 ,new AddExpression(new FibonacciExpression(e2),new FibonacciExpression(e3))) ;
        return exp.execute().getValue();
    
    }
    
    
    
}