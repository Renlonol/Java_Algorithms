
public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreadthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	private void bfs(Graph G, int s){
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		marked[s] = true;
		while(!q.isEmpty()){
			int v = q.dequeue();
			for(int w : G.adj(v)){
				if(!marked[w]){
					q.enqueue(w);
					marked[w] = true;
					edgeTo[w] = v;
				}	
			}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph(new In(args[0]));
		int s = Integer.parseInt(args[1]);
		BreadthFirstPaths bfp = new BreadthFirstPaths(G,s);
		
		for(int v = 0; v < G.V(); v++){
			StdOut.print(s + " to " + v + ": " );
			if(bfp.hasPathTo(v)){
				for(int x : bfp.pathTo(v)){
					if(x == s) StdOut.print(x);
					else StdOut.print("-" + x);
				}
			}
			StdOut.println();
		}
	}

}
