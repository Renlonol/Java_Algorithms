
public class KosarajuSCC {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public KosarajuSCC(Digraph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		//反向图的逆后序
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		//以反向图的逆后序深度搜索图
		for(int s : order.reversePost())
			if(!marked[s])
			{ dfs(G,s); count++; }  
	}
	private void dfs(Digraph G, int v){
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	public boolean stronglyConnected(int v, int w){
		return id[v] == id[w];
	}
	public int id(int v)
	{ return id[v]; }
	public int count()
	{ return count; }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Digraph G = new Digraph( new In(args[0]));
		KosarajuSCC cc = new KosarajuSCC(G);
		int M = cc.count();
		Bag<Integer>[] components = (Bag<Integer>[])new Bag[M];
		for(int i = 0; i < M; i++){
			components[i] = new Bag<Integer>(); 
		}
		for(int v = 0; v < G.V(); v++){
			components[cc.id(v)].add(v);
		}
		StdOut.println(M + " components");
		for(int i = 0; i < M; i++){
			for(int v : components[i])
				StdOut.print(v + " ");
			StdOut.println();
		}
	}

}
