
class IfExpression extends Expression{
    Expression e1;
    Expression e2;
    ConditionalExpression con;
    
    IfExpression(ConditionalExpression con, Expression e1, Expression e2){ // con true veya false döndüren bir sınıf. Ancak bu bool değerler 
        // ConditionalExpression constructorı altında döner.
        this.con = con;
        this.e1 = e1;
        this.e2 = e2;
    }
    
    @Override
    Expression execute(){
        Expression e3 = (Expression) getValue();
        return e3.execute();
    }
    
    @Override
    Object getValue(){
        if((boolean) con.getValue()){
            return e1;
        }else
            return e2;
            
        
    }
    
    @Override
    public String toString(){
        return "if (" + con.toString() + ") { " + e1.toString() + " } else { " + e2.toString() + " }";
    }
    
    
}