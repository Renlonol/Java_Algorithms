
public class DepthFirstSearch {
	private boolean [] marked;
	private int count;
	
	public DepthFirstSearch(Graph G, int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	private void dfs(Graph G, int v){
		marked[v] = true;
		count++;
		for(int w : G.adj(v))
			if(!marked[w]) dfs(G,w);
	}
	public boolean marked(int w){
		return marked[w];
	}
	public int count(){
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph( new In(args[0]));
		int s = Integer.parseInt(args[1]);
		DepthFirstSearch dfs = new DepthFirstSearch(G,s);
		
		for(int v = 0; v < G.V(); v++){
			if(dfs.marked(v))
				StdOut.print(v + " ");
		}
		StdOut.println();
		if(dfs.count != G.V())
			StdOut.print("Not connected");
		else StdOut.print("connected");
	}
}
