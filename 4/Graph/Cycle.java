
public class Cycle {
	//图是否有环，判断的依据为：如果所往的节点已经搜索过，就判断所往的节点是否和所来的节点是同一节点，若是则为原路返回，此时还无法判断是否存在环，继续搜索。
	//若不是同一节点，则存在环。
	private boolean[] marked;
	private boolean hasCycle;
	
	public Cycle(Graph G){
		marked = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++){
			if(!marked[s])
				dfs(G,s,s);
		}
	}
	private void dfs(Graph G, int v, int u){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G,w,v);
			else if(w != u) hasCycle = true;//判断所往的节点是否和所来的节点是同一节点
		}
	}
	
	public boolean hasCycle(){
		return  hasCycle;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph(new In(args[0]));
		Cycle C = new Cycle(G);
		if(C.hasCycle()) StdOut.print("the Graph has cycle.");
		else StdOut.print("the Graph has no cycle.");
	}

}
