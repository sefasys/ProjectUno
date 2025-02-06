/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Factorial extends FunctionExpression{

    Factorial(Expression e1) {
        super(e1);
    }
    
    
    @Override
    Expression execute(){
        Object obj = getValue();
        return new IntegerLiteral((int) obj);
    }
    
    @Override
    Object getValue(){
        Expression e2 = new IntegerLiteral((int)(e1.getValue()) -1);
        ConditionalExpression con = new ConditionalExpression(e2, new IntegerLiteral(1), ConditionalOperator.GreaterEqual);
        IfExpression exp = new IfExpression(con, new MultiplyExpression(e1, new Factorial(e2)) , new IntegerLiteral(1));
        return exp.execute().getValue();
    }
    
    
}
