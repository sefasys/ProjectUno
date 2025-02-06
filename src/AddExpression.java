
class AddExpression extends ArithmeticExpression{
    // override edeceğimiz execute metodu Expression döndürür, getValue ise Object döndürür...
    private Expression e1;
    private Expression e2;

    AddExpression(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    Expression execute() {  //getValue hep Object döndürdüğü için direkt olarak + kullanarak işlem yapamıyorum...
        Object obj = getValue();

        if(obj.getClass().getSimpleName().equals("Integer")){
            return new IntegerLiteral((int) obj);
        }else if(obj.getClass().getSimpleName().equals("Double")){
            return new DoubleLiteral((double) obj);
        }else if(obj.getClass().getSimpleName().equals("String")){
            return new StringLiteral((String) obj);
        }else{
            return null;
        }
    }
    
    @Override
    Object getValue() { //Belki kolaylık sağlar diye Number classını kullanmaya çalıştık ancak öğrendik ki class Number abstract bir class olduğu için + sign is undefined. 
        if(e1.getValue().getClass().getSimpleName().equals("Integer")){
            if(e2.getValue().getClass().getSimpleName().equals("Integer")){
                return (int) e1.getValue() + (int) e2.getValue();
            }else if(e2.getValue().getClass().getSimpleName().equals("Double")){
                return (int) e1.getValue() + (double) e2.getValue();
            }else if(e2.getValue().getClass().getSimpleName().equals("String")){
                return (int) e1.getValue() + (String) e2.getValue();
            }else{
                try{
                    throw new IllegalArgumentException();
                }catch(IllegalArgumentException e){
                    System.err.println("Arithmetic expressions only support data types integer, double, string! Execution failed!");
                    return null;
                }
            }
        }else if(e1.getValue().getClass().getSimpleName().equals("Double")){
            if(e2.getValue().getClass().getSimpleName().equals("Integer")){
                return (double) e1.getValue() + (int) e2.getValue();
            }else if(e2.getValue().getClass().getSimpleName().equals("Double")){
                return (double) e1.getValue() + (double) e2.getValue();
            }else if(e2.getValue().getClass().getSimpleName().equals("String")){
                return (double) e1.getValue() + (String) e2.getValue();
            }else{
                try{
                    throw new IllegalArgumentException();
                }catch(IllegalArgumentException e){
                    System.err.println("Arithmetic expressions only support data types integer, double, string! Execution failed!");
                    return null;
                }
            }
        }else if(e1.getValue().getClass().getSimpleName().equals("String")){ 
            if(e2.getValue().getClass().getSimpleName().equals("Integer")){
                return (String) e1.getValue() + (int) e2.getValue();
            }else if(e2.getValue().getClass().getSimpleName().equals("Double")){
                return (String) e1.getValue() + (double) e2.getValue();
            }else if(e2.getValue().getClass().getSimpleName().equals("String")){
                return (String) e1.getValue() + "" + (String) e2.getValue();
            }else{
                try{
                    throw new IllegalArgumentException();
                }catch(IllegalArgumentException e){
                    System.err.println("Arithmetic expressions only support data types integer, double, string! Execution failed!");
                    return null;
                }
            }
        }else{
            try{
                throw new IllegalArgumentException();
            }catch(IllegalArgumentException e){
                System.err.println("Arithmetic expressions only support data types integer, double, string! Execution failed!");
                return null;
            }
        }        
    }

    @Override
    public String toString() {
        return "(" + e1.toString() + " + " + e2.toString() + ")";
    }

    
    

}