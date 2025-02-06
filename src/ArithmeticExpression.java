
public abstract class ArithmeticExpression extends Expression {
 // override edeceğimiz execute metodu Expression döndürür, getValue ise Object döndürür...
    abstract Object getValue(); 
	
    abstract Expression execute();


}
