
public class BinarySearchST<Key extends Comparable<Key>,Value>{
	private Key[] keys;//键数组
	private Value[] vals;//值数组
	private int N;//键值对数量
	public BinarySearchST(int capacity){
		//构造一定容量容量的键值数组
		keys = (Key []) new Comparable[capacity];
		vals = (Value []) new Object[capacity];
	}
	public int size(){
		return N;
	}
	public boolean contains(Key k){
		int i = rank(k);
		return i < N && k.compareTo(keys[i]) == 0;
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public Value get(Key k){
	//
		int i = rank(k);
		if(i < N && k.compareTo(keys[i]) == 0)
			return vals[i];
		else 
			return null;		
	}
	public void pull(Key k, Value v){
		int i = rank(k);
		if(i < N && k.compareTo(keys[i])==0){
			vals[i] = v;
			return;
		}
		for(int j = N; j > i; j--){
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = k; vals[i] = v;
		N++;
	}
	private int rank(Key k){
		//小于键 k 的键的数量
		int lo = 0, hi = N-1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(k.compareTo(keys[mid]) < 0)
				hi = mid - 1;
			else if(k.compareTo(keys[mid]) > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}
	public void delete(Key k){
		int i = rank(k);
		if(i < N && k.compareTo(keys[i]) == 0){
			for(int j = i; j < N-1; j++){
				keys[j] = keys[j+1];
				vals[j] = vals[j+1];
			}
			keys[N-1] = null; vals[N-1] = null;
			N--;
		}
		else  
			return;
	}
	public Iterable<Key> keys(){
		Queue<Key> queue = new Queue<Key>();
        for(int i = 0 ; i != N; i++)
            queue.enqueue(keys[i]);
        return queue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchST<String,Integer> st = new  BinarySearchST<String,Integer>(20);
		String [] k = In.readStrings(args[0]);
		for(int i = 0; i < k.length; i++){		
			st.pull(k[i], i);
		}
		for(String s : st.keys())
			StdOut.print(s + " " + st.get(s) + "   ");
		st.delete("L");
		StdOut.println();
		for(String s : st.keys())
			StdOut.print(s + " " + st.get(s) + "   ");
	}

}


