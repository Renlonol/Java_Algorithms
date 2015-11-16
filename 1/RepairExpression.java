
public class RepairExpression {

	public static boolean isOperator(String s){
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String>val = new Stack<String>();
		Stack<String>op = new Stack<String>();
		String[] exp = In.readStrings(args[0]);
		for(String s : exp){
			if(isOperator(s)) op.push(s);
			else if(s.equals(")")){
				String rightOperand = val.pop();
				String leftOperand = val.pop();
				String operator = op.pop();
				val.push("( " + leftOperand + " " + operator + " " + rightOperand + " )");
			}
			else val.push(s);
		}
		StdOut.print(val.pop());
	}	
}
