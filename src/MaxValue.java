/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class MaxValue extends FunctionExpression{
    
    
    MaxValue(Expression e1, Expression e2) {
        super(e1,e2);
    }
    
    
    @Override 
    Expression execute(){
        Object obj = getValue();
        if(obj instanceof Integer)
            return new IntegerLiteral((int) obj);
        else if(obj instanceof Double)
            return new DoubleLiteral((double) obj);
        else 
            return null;
    }
    
    @Override 
    Object getValue(){
        ConditionalExpression con = new ConditionalExpression(e1, e2, ConditionalOperator.Greater);
        IfExpression exp = new IfExpression(con, e1, e2);
        return exp.execute().getValue();
    }
    
    
    
    
}
