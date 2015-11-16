
public class SeparateChainingHashST<Key, Value> {
	
	private int N;//键值对总数
	private int M;//散列表大小
	private SequentialSearchST<Key, Value> []st;
	public SeparateChainingHashST(){
		this(997);
	}
	public SeparateChainingHashST(int M){
		this.M  = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i = 0; i < M; i++)
			st[i] = new SequentialSearchST();
	}
	public int size(){
		return N;
	}
	private int hash(Key k){
		return (k.hashCode() & 0x7fffffff) % M;
	}
	public Value get(Key k){
		return st[hash(k)].get(k);
	}
	public void put(Key k, Value v){
		if(st[hash(k)].contains(k))
			st[hash(k)].pull(k, v);
		else 
			{ st[hash(k)].pull(k, v); N++; }
	}
	public void delete(Key k){
		if(st[hash(k)].contains(k))
			{ st[hash(k)].delete(k); N--; }
	}
	public Iterable<Key> keys(){
		Queue<Key> queue = new Queue<Key>();
        for(int i = 0; i < M; i++){
        	for(Key s : st[i].keys())
        		queue.enqueue(s);      	 
        }
        return queue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST(5);
		String [] k = In.readStrings(args[0]);
		for(int i = 0; i < k.length; i++){		
			st.put(k[i], i);
		}
		//st.delete("P");?????
		for(String s : st.keys())
			StdOut.print(s + " " + st.get(s) +"    ");
		StdOut.println();
		StdOut.print(st.size() + " keys");
	}

}
