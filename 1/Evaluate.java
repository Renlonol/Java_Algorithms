
public class Evaluate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Double>val = new Stack<Double>();
		Stack<String>op = new Stack<String>();
		String[] exp = In.readStrings(args[0]);
		for(String s : exp){
			if(s.equals("(")) 				  ;
			else if(s.equals("+"))  op.push(s);
			else if(s.equals("-"))	op.push(s);
			else if(s.equals("*"))	op.push(s);
			else if(s.equals("/"))	op.push(s);
			else if(s.equals(")")){
				String o = op.pop(); 
				double v = val.pop();
				if(o.equals("+"))		v = val.pop() + v;
				else if(o.equals("-"))	v = val.pop() - v;
				else if(o.equals("*"))	v = val.pop() * v;
				else if(o.equals("/"))	v = val.pop() / v;
				val.push(v);
			}
			else val.push(Double.parseDouble(s));
		}
		StdOut.printf("the result is %.2f", val.pop());
	}
}
