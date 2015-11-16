
public class LinearProbingHashST<Key, Value> {
	private int N;//键值对总数
	private int M = 16;//线性探测表的大小
	private Key[] keys;//键
	private Value[] vals;//值
	public LinearProbingHashST(){
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	public LinearProbingHashST(int cap){
		M = cap;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	public int size(){
		return N;
	}
	public int size_st(){
		return M;
	}
	public boolean contains(Key k){
		for(int i = hash(k); keys[i] != null; i = (i+1) % M){
			if(k.equals(keys[i])) return true;
		}
		return false;
	}
	private void resize(int cap){
		LinearProbingHashST<Key,Value> t;
		t = new LinearProbingHashST(cap);
		for(int i = 0; i < M; i++){
			if(keys[i] != null)
				t.put(keys[i], vals[i]);
		}
		keys = t.keys;
		vals = t.vals;
		M = t.M;
	}
	private int hash(Key k){
		return (k.hashCode() & 0x7fffffff) % M;
	}
	public void put(Key k, Value v){
		if(N > M/2) resize(2*M);
		int i;
		for(i = hash(k); keys[i] != null; i = (i + 1) % M){
			if(k.equals(keys[i])){
				vals[i] = v; return;
			}
		}
		keys[i] = k;
		vals[i] = v;
		N++;
	}
	public Value get(Key k){
		for(int i = hash(k); keys[i] != null; i = (i+1) % M){
			if(k.equals(keys[i])) return vals[i];
		}
		return null;
	}
	public void delete(Key k){
		if(!contains(k)) return;
		int i = hash(k);
		while(!keys[i].equals(k))
			i = (i+1) % M;
		keys[i] = null;
		vals[i] = null;
		
		i = (i+1) % M;
		while(keys[i] != null){
			put(keys[i],vals[i]);
			keys[i] = null;
			vals[i] = null;
			N--;
			i = (i+1) % M;
		}
		N--;
		if(N > 0 && N == M/8) resize(M/2);
	}
	public Iterable<Key> keys(){
		Queue<Key> queue = new Queue<Key>();
        for(int i = 0; i < M; i++){
        	if(keys[i] != null)
        		queue.enqueue(keys[i]);      	 
        }
        return queue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
		String [] k = In.readStrings(args[0]);
		for(int i = 0; i < k.length; i++){		
			st.put(k[i], i);
		}
		st.delete("A");//?????
		st.delete("S");
		st.delete("P");
		st.delete("X");
		st.delete("R");
		st.delete("M");
		for(String s : st.keys())
			StdOut.print(s + " " + st.get(s) +"    ");
		StdOut.println();
		StdOut.print(st.size() + " keys in  " + st.size_st() + "st");
	}

}
