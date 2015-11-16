
public class WeightedQuickUnionUF {
	
	private int [] id;
	private int [] sz;
	private int count;
	public WeightedQuickUnionUF(int N){
		//以整数为标识初始化N个触点
		count = N;
		id = new int[N];
		for(int i = 0; i < N; i++)	id[i] = i;
			
		sz = new int[N];
		for(int i = 0; i < N; i++)	sz[i] = 1;		
	}
	public void print_id(){
		for(int d : id)
			StdOut.print(d + " ");
	}
	public int count(){
		return count;
	}
	private int find( int p){
		//返回触点标识
		while(p != id[p])	p = id[p];
		return p;
	}
	public boolean connected(int p, int q){
		//触点接通则为True
		return find(p) == find(q);
	}
	public void union(int p, int q){
		//链接两个触点
		int pRoot = find(p);
		int qRoot = find(q);
		if(pRoot == qRoot)	return;
		if(sz[pRoot] < sz[qRoot])	{ id[pRoot] = qRoot; sz[qRoot] += sz[pRoot]; }
		else						{ id[qRoot] = pRoot; sz[pRoot] += sz[qRoot]; }
		count--;					
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = StdIn.readInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(uf.connected(p, q))	continue;
			uf.union(p, q);
			StdOut.println(p + " "+ q);
			uf.print_id();
			StdOut.println();
		}
		StdOut.println(uf.count() + "components");
	}

}
