class OrExpression extends LogicalExpression{
    private Expression b1;
    private Expression b2;

    OrExpression(Expression b1, Expression b2){
        this.b1 = b1;
        this.b2 = b2;
    }

    @Override
    Expression execute(){
        Object bool = getValue();
        return new BooleanLiteral((boolean) bool);
    }

    @Override
    Object getValue(){
        if((boolean)b1.getValue() || (boolean)b2.getValue())
            return true;
        else
            return false;
    }

}