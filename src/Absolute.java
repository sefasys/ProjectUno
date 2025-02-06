
class Absolute extends FunctionExpression{
    
    Absolute(Expression e1){
        super(e1);
    }
    
    @Override
    Expression execute(){
        Object obj = getValue();
        return (Expression) obj;
    } 
    
    @Override
    Object getValue(){
        ConditionalExpression con = new ConditionalExpression(e1, new IntegerLiteral(0), ConditionalOperator.GreaterEqual);
        IfExpression exp = new IfExpression(con, e1,  new NegateExpression(e1).execute());
        return exp.getValue();
    }
    
    
    
}