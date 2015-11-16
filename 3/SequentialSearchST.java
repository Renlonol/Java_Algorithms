
public class SequentialSearchST<Key, Value> {
	private Node first;
	private int N;
	private class Node{
		//
		Key key;
		Value val;
		Node next;
		public Node(Key k, Value v, Node n){
			key = k; val = v; next = n;
		}
	}
	public int size(){
		return N;
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public boolean contains(Key k){
		for(Node x = first; x != null; x = x.next)
			if(x.key.equals(k)) return true;
		return false;
	}
	public Value get(Key k){
		//
		for(Node x = first; x != null; x = x.next){
			if(x.key.equals(k))  return x.val;
		}
		return null;
	}
	public void pull(Key k, Value v){
		//
		for(Node x = first; x != null; x = x.next)
			if(x.key.equals(k)){
				x.val = v; return; 
			}
		first = new Node(k,v,first);
		N++;
	}
	public void delete(Key k){
		
		for(Node x = first,xPre = first; x != null; xPre = x,x = x.next)
			if(x.key.equals(k)){
				xPre.next = x.next;
				N--;
			}
	}
	public Iterable<Key> keys(){
		Queue<Key> queue = new Queue<Key>();
        for(Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		SequentialSearchST<String,Integer> st = new  SequentialSearchST<String,Integer>();
		String [] k = In.readStrings(args[0]);
		for(int i = 0; i < k.length; i++){		
			st.pull(k[i], i);
		}
		st.delete("P");
		for(String s : st.keys())
			StdOut.print(s + " " + st.get(s) + "   ");
	}

}
