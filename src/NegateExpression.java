

class NegateExpression extends ArithmeticExpression{
     private Expression e3;

    NegateExpression(Expression e3) {
        this.e3 = e3;
    }

     @Override
    Object getValue() {

        if (e3.getValue() instanceof Integer) {
            return -(int) (e3.getValue());
        } else if (e3.getValue() instanceof Double) {
            return -(double) (e3.getValue());
        } else {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e) {
                System.out.println("Given arithmetic expression is not valid for this test case" + e);
                return null;
            }
        }
    }

    @Override
    Expression execute() {
        Object value = getValue();
        if (value instanceof Integer) {
            return new IntegerLiteral((int) value);
        } else if (value instanceof Double) {
            return new DoubleLiteral((double) value);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return e3.toString();
    }

    
   

}
