
public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node{
		private Key key; 
		private Value val;
		private Node left, right;
		private int N;
		
		public Node(Key k, Value v, int n){
			key = k; val = v; N = n;           
		}
	}
	public int size(){
		return size(root);
	}
	private int size(Node x){
		if(x == null) return 0;
		else return x.N;
	}
	public Value get(Node x, Key k){
		if(x == null) return null;
		int cmp = k.compareTo(x.key);
		if	   (cmp < 0) return get(x.left,k);
		else if(cmp > 0) return get(x.right,k);
		else return x.val;
	}
	public void put(Key k, Value v){
		root = put(root,k,v);
	}
	private Node put(Node x, Key k, Value v){
		//
		if(x == null) return new Node(k,v,1);
		int cmp = k.compareTo(x.key);
		if	   (cmp < 0) x.left = put(x.left,k,v);
		else if(cmp > 0) x.right = put(x.right,k,v);
		else x.val = v;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public Key min(){
		return min(root).key;
	}
	private Node min(Node x){
		if(x.left == null) return x;
		return min(x.left);
	}
	public Key floor(Key k){
		Node x = floor(root,k);
		if(x == null) return null;
		return x.key;
	}
	private Node floor(Node x, Key k){
		if(x == null) return null;
		int cmp = k.compareTo(x.key);
		if(cmp == 0) return x;
		if(cmp < 0) return floor(x.left,k);
		Node t = floor(x.right,k);
		if(t != null) return t;
		else return x;
	}
	public void deleteMin(){
		root = deleteMin(root);
	}
	private Node deleteMin(Node x){
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public void delete(Key k){
		root = delete(root,k);
	}
	private Node delete(Node x, Key k){
		if(x == null) return null;
		int cmp = k.compareTo(x.key);
		if(cmp < 0)      x.left = delete(x.left,k);
		else if(cmp > 0) x.right = delete(x.right,k);
		else{
			if(x.left == null)  return x.right;
			if(x.right == null) return x.left;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}
	public Iterable<Key> keys(Node x,Queue q){
        if(x != null){ 
        	q.enqueue(x.key);
        	keys(x.left,q);
        	keys(x.right,q);
        }
        return q;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<String,Integer> st = new  BST<String,Integer>();
		Queue<String> queue = new Queue<String>();
		String [] k = In.readStrings(args[0]);
		for(int i = 0; i < k.length; i++){		
			st.put(k[i], i);
		}
		//st.delete("S");
		for(String s : st.keys(st.root,queue))
			StdOut.print(s + " " + st.get(st.root,s) + "   " );//
		
	//	st.delete("S");
//		
//		StdOut.println();
//		for(String s : st.keys(st.root,queue))
//			StdOut.print(s + " " + st.get(st.root,s) + "   " );

	}

}