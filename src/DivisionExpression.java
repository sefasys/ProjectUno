
class DivisionExpression extends Expression{
    Expression e1;
    Expression e2;

    DivisionExpression(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }

     @Override
    Expression execute() {
        Object obj = getValue();

        if (obj.getClass().getSimpleName().equals("Integer")) {
            return new IntegerLiteral((int) obj);
        } else if (obj.getClass().getSimpleName().equals("Double")) {
            return new DoubleLiteral((Double) obj);
        } else {
            return null;
        }
    }

    @Override
    Object getValue() {
        if (e1.getValue().getClass().getSimpleName().equals("Integer")) {
            if (e2.getValue().getClass().getSimpleName().equals("Integer")) {
                return (((int) e1.getValue()) / ((int) e2.getValue()));
            } else if (e2.getValue().getClass().getSimpleName().equals("Double")) {
                return ((int) e1.getValue() / (double) e2.getValue());
            }else {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.err.println("Multiplying expressions only support data types integer and double! Expression failed!");
                    return null;
                }
            }
        } else if (e1.getValue().getClass().getSimpleName().equals("Double")) {
            if (e2.getValue().getClass().getSimpleName().equals("Integer")) {
                return (((double) e1.getValue()) / ((int) e2.getValue()));
            } else if (e2.getValue().getClass().getSimpleName().equals("Double")) {
                return ((double) e1.getValue() / (double) e2.getValue());
            }else {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.err.println( "Multiplying expressions only support data types integer and double! Expression failed!");
                    return null;
                }
            }
        } else {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.err.println("Multiplying expressions only support data types integer and double! Expression failed!");
                return null;
            }
        }
    }
    
    @Override
    public String toString() {
        return "(" + e1.toString() + " * " + e2.toString() + ")";
    }
}