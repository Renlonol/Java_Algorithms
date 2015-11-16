
public class Parentheses {

	public static boolean match(String s1,String s2){
		//括号对匹配规则
		 return  ( ("(".equals(s1)) && (")".equals(s2)) ) || ( ("[".equals(s1)) && ( "]".equals(s2)) ) || ( ( "{".equals(s1)) && ("}".equals(s2)) );
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> par = new Stack<String>();
		String[] text = In.readStrings(args[0]);
		
		for(String t : text)	
			StdOut.print(t + " ");
		
		for(int i = 0; i < text.length; i++ ){
			//文本首个括号入栈，后续括号与首个括号进行匹配，若匹配则出栈，否则，入栈
			//当最后栈为空则文本括号对匹配完整，否则为不完整
			if(par.isEmpty())	par.push(text[i]);
			else if(match(par.top(),text[i]))
				par.pop();
			else par.push(text[i]);
		}
		
		if(par.isEmpty())	StdOut.print("True");//
		else StdOut.print("False");		
	}
}