
class ConditionalExpression extends Expression {

    Expression x1;
    Expression x2;
    ConditionalOperator op;

    ConditionalExpression(Expression x1, Expression x2, ConditionalOperator op) {
        this.x1 = x1;
        this.x2 = x2;
        this.op = op;
    }

    @Override
    Expression execute() {
        Object boolValue = getValue();
        return new BooleanLiteral((boolean) boolValue);
    }

    @Override
    Object getValue() {
      
         
        double x1Value = ((Number) x1.getValue()).doubleValue();
        double x2Value = ((Number) x2.getValue()).doubleValue();

        switch (op) {
            case Equal:
                return x1Value == x2Value;     
            case NotEqual:
                return x1Value != x2Value;
            case Greater:
                return x1Value > x2Value;
            case GreaterEqual:
                return x1Value >= x2Value;
            case Less:
                return x1Value < x2Value;
            default:
                return x1Value <= x2Value;

        }
    }

    @Override
    public String toString() {
        return x1.getValue() + " " + op.toString() + " " + x2.getValue();
    }
}
