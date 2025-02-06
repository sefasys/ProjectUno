/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class Square extends FunctionExpression{
    
    Square(Expression e1){
        super(e1);
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
       MultiplyExpression e2 = new MultiplyExpression(e1,e1);
       return e2.getValue();
    }
        
}
