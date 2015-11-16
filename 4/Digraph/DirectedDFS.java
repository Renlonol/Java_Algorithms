
public class DirectedDFS {
	//有向图的深度搜索
	private boolean [] marked;
	public DirectedDFS(Digraph G, int s){
		//从 s 可以到达的所有顶点
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	private void dfs(Digraph G, int v){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
	}
	public DirectedDFS(Digraph G, Iterable<Integer> source){
		//从多个点可以到达的所有顶点
		marked = new boolean[G.V()];
		for(int s : source)
			if(!marked[s])
				dfs(G,s);
	}
	public boolean marked(int v){
		return marked[v];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Digraph G = new Digraph(new In(args[0]));
		Bag<Integer> source = new Bag<Integer>();
		for(int i = 1; i < args.length; i++){
			source.add(Integer.parseInt(args[i]));
		}
		//int s = Integer.parseInt(args[1]);
		DirectedDFS reachable = new DirectedDFS(G,source);
		
		for(int v = 0; v < G.V(); v++){
			if(reachable.marked(v)) StdOut.print(v + " ");
		}
	}

}
