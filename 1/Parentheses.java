
public class Parentheses {

	public static boolean match(String s1,String s2){
		//���Ŷ�ƥ�����
		 return  ( ("(".equals(s1)) && (")".equals(s2)) ) || ( ("[".equals(s1)) && ( "]".equals(s2)) ) || ( ( "{".equals(s1)) && ("}".equals(s2)) );
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> par = new Stack<String>();
		String[] text = In.readStrings(args[0]);
		
		for(String t : text)	
			StdOut.print(t + " ");
		
		for(int i = 0; i < text.length; i++ ){
			//�ı��׸�������ջ�������������׸����Ž���ƥ�䣬��ƥ�����ջ��������ջ
			//�����ջΪ�����ı����Ŷ�ƥ������������Ϊ������
			if(par.isEmpty())	par.push(text[i]);
			else if(match(par.top(),text[i]))
				par.pop();
			else par.push(text[i]);
		}
		
		if(par.isEmpty())	StdOut.print("True");//
		else StdOut.print("False");		
	}
}