
class NotExpression extends LogicalExpression{
    private Expression b1;
    
    NotExpression(Expression b1){
        this.b1 = b1;
    }


    @Override
    Expression execute(){
        Object bool = getValue();
        return new BooleanLiteral((boolean) bool);
    }

    @Override
    Object getValue(){
        if((boolean) b1.getValue())
            return false;
        else
            return true;
    }


}