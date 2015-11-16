
public class LazyPrimMST {
	private boolean marked[];//最小生成树的顶点
	private Queue<Edge> mst;//最小生成树的边
	private MinPQ<Edge> pq;//横切边（包括无效的）
	
	public LazyPrimMST(EdgeWeightedGraph G){
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>(G.E());
		
		visit(G,0);
		while(!pq.isEmpty()){
			Edge e = pq.delMin();
			int v = e.either(); int w = e.other(v);
			if(marked[v] && marked[w]) continue;//???
			mst.enqueue(e);
			if(!marked[v]) visit(G,v);
			if(!marked[w]) visit(G,w);
		}
	}
	
	private void visit(EdgeWeightedGraph G, int v){
		marked[v] = true;
		for(Edge e : G.adj(v))
			if(!marked[e.other(v)])
				pq.insert(e);
	}
	
	public Iterable<Edge> edges()
	{ return mst; }
	
	public double weight(){
		double weight = 0;;
		for(Edge e : mst)
			weight += e.weight();
		return weight;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EdgeWeightedGraph G;
		G = new EdgeWeightedGraph(new In(args[0]));
		LazyPrimMST mst = new LazyPrimMST(G);
		for(Edge e : mst.edges())
			StdOut.println(e);
		StdOut.println(mst.weight());
	}

}
