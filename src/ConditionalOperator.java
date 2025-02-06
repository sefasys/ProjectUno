
public enum ConditionalOperator {
	Equal, 
	NotEqual, 
	Less, 
	LessEqual, 
	Greater, 
	GreaterEqual,
        Or;

	@Override
	public String toString()
	{
		switch(this)
		{
		case Equal: return "==";
		case NotEqual: return "!="; 
		case Less: return "<"; 
		case LessEqual: return "<="; 
		case Greater: return ">"; 
		case GreaterEqual: return ">="; 
                case Or: return "||";
		}
		
		return super.toString();
	}
}
