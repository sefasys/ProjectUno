

public class TestCases {

	private TestCases() { }

	static void arithmeticExpressioTest()
	{
	

		Expression e1 = new IntegerLiteral(5);
		Expression e2 = new DoubleVariable("e2", 7.5);
		Expression e3 = new IntegerVariable("e3", 4);
		Expression e4 = new StringVariable("e5", " is five");  // value'yı burada string olarak alıyor. Üzerinde işlem yapmamız pek mümkün görünmüyor...
		Expression e5 = new DoubleLiteral(2.5);
		System.out.println(e2 + " = " + e2.getValue());
		System.out.println(e3 + " = " + e3.getValue());
		System.out.println(e4 + " = " + e4.getValue());
		System.out.println(e1 + " + " + e2 + " = " + new AddExpression(e1, e2).execute()); // Create those classes as child classes of class ArithmeticExpression... 1
		System.out.println(e1 + " + " + e3 + " = " + new AddExpression(e1, e3).execute());//2
		System.out.println(e1 + " + " + e4 + " = " + new AddExpression(e1, e4).execute());//3 Burada addExpressionu aslında biraz amacından saptırıp String concat yapıyoruz..
		System.out.println(e2 + " - " + e3 + " = " + new SubtractExpression(e2, e3).execute());
		System.out.println(e2 + " * " + e3 + " = " + new MultiplyExpression(e2, e3).execute());
		System.out.println(e1 + " + (" + e2 + " / " + e5 + ") = " + new AddExpression(e1, new DivisionExpression(e2, e5)).execute());
		System.out.println("-" + e3 + " = " + new NegateExpression(e3).execute());
	}
	
	static void logicalExpression()
	{
		System.out.println("logicalExpression()");
		System.out.println("-------------------");
	
			
		Expression b1 = new BooleanLiteral(true);
		Expression b2 = new BooleanVariable("b2", false);
		System.out.println(b2 + " = " + b2.getValue());
		System.out.println("not(" + b1 + ") = " + new NotExpression(b1).execute());
		System.out.println(b1 + " and " + b2 + " = " + new AndExpression(b1, b2).getValue());
		System.out.println(b1 + " and not(" + b2 + ") = " + new AndExpression(b1, new NotExpression(b2)).getValue());
		System.out.println(b1 + " or " + b2 + " = " + new OrExpression(b1, b2).getValue());
		System.out.println(b1 + " xor " + b2 + " = " + new XorExpression(b1, b2).getValue());
		System.out.println(b1 + " xor not(" + b2 + ") = " + new XorExpression(b1, new NotExpression(b2)).getValue());
	}
	
	
        
	static void conditionalExpression()
	{
		System.out.println("conditionalExpression()");
		System.out.println("-----------------------");
		
		
		
		Expression two = new IntegerLiteral(2);
		Expression x1 = new IntegerLiteral(5);
		Expression x2 = new IntegerVariable("x2", 10);
		ConditionalOperator lessOp = ConditionalOperator.Less;
		ConditionalOperator equalOp = ConditionalOperator.Equal;
		
		System.out.println(x2 + " = " + x2.getValue());
		System.out.println(x1 + " " + lessOp + " " + x2 + " = " + new ConditionalExpression(x1, x2, lessOp).execute());
		System.out.println(x1 + " " + equalOp + " " + x2 + " = " + new ConditionalExpression(x1, x2, equalOp).getValue());
		System.out.println(two + "*" + x1 + " " + equalOp + " " + x2 + " = " + new ConditionalExpression(new MultiplyExpression(two, x1), x2, equalOp).getValue());
	}
        
	

	static void ifExpression()
	{
		System.out.println("ifExpression()");
		System.out.println("--------------");
						
		
		Expression x1 = new IntegerLiteral(5);
		Expression x2 = new IntegerVariable("x2", 10);
		ConditionalOperator lessOp = ConditionalOperator.Less;
		ConditionalOperator equalOp = ConditionalOperator.Equal;
                ConditionalOperator greaterOp = ConditionalOperator.Greater;
		ConditionalExpression lop = new ConditionalExpression(x1, x2, lessOp);
                System.out.println();
		ConditionalExpression zep = new ConditionalExpression(x1, x2, greaterOp );
                System.out.println();
                ConditionalExpression nep = new ConditionalExpression(x1, x2, equalOp);
                System.out.println();
                
		
		System.out.println(x2 + " = " + x2.getValue());
		
		
                
                Expression ifExpression1 = new IfExpression(lop, x1, new NegateExpression(x2));
		System.out.println(ifExpression1 + " --> " + ifExpression1.execute());
                
                Expression ifExpression2 = new IfExpression(zep, x1, new NegateExpression(x2));
		System.out.println(ifExpression2 + " --> " + ifExpression2.execute());
                
               
		
		System.out.println();
	}
        
        static void functionExpression(){
            
            System.out.println("Function Expression");
            System.out.println("-------------------");
            System.out.println("");
            
            Expression e1 = new IntegerLiteral(-7);
            Expression e2 = new DoubleLiteral(-23.5);
            Expression e3 = new IntegerLiteral(0);
            Expression e4 = new IntegerLiteral(1);
            Expression e5 = new IntegerLiteral(2);
            Expression e6 = new IntegerLiteral(3);
            Expression e7 = new IntegerLiteral(4);
            Expression e8 = new IntegerLiteral(5);
            Expression e9 = new IntegerLiteral(6);
            Expression e10 = new IntegerLiteral(7);
  
            Absolute abs = new Absolute(e1);
            Absolute ab1 = new Absolute(e2);
           
            System.out.println("Abs(" + e1.getValue() + ") = " + abs.execute());
            System.out.println("Abs(" + e2.getValue() + ") = " + ab1.execute());
            
            Square sqr = new Square(e1);
            Square sqr1 = new Square(e2);
            System.out.println("Sqr(" + e1.getValue() + ") = "  + sqr.execute());
            System.out.println("Sqr(" + e2.getValue() + ") = "  + sqr1.execute());
            
            MaxValue max = new MaxValue(e1,e2);
            System.out.println("Max(" + e1.getValue() + ", " + e2.getValue() + ") = " + max.execute());
            
            MinValue min = new MinValue(e1,e2);
            System.out.println("Min(" + e1.getValue() + ", " + e2.getValue() + ") = " + min.execute());
           
            Factorial factorial = new Factorial(e3);
            System.out.println("Factorial(" + e3.getValue() + ") = " + factorial.execute());
            
            FibonacciExpression fibo = new FibonacciExpression(e3);
            System.out.println(fibo.execute());
            FibonacciExpression fibo1 = new FibonacciExpression(e4);
            System.out.println(fibo1.execute());
            FibonacciExpression fibo2 = new FibonacciExpression(e5);
            System.out.println(fibo2.execute());
            FibonacciExpression fibo3 = new FibonacciExpression(e6);
            System.out.println(fibo3.execute());
            FibonacciExpression fibo4 = new FibonacciExpression(e7);
            System.out.println(fibo4.execute());
            FibonacciExpression fibo5 = new FibonacciExpression(e8);
            System.out.println(fibo5.execute());
            FibonacciExpression fibo6 = new FibonacciExpression(e9);
            System.out.println(fibo6.execute());
            FibonacciExpression fibo7 = new FibonacciExpression(e10);
            System.out.println(fibo7.execute());
            
            
        }
	
}
