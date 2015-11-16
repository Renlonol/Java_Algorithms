
public class KruskalMST {
	private Queue<Edge> mst;//��С�������ı�
	private MinPQ<Edge> pq;//����С���ѣ�ÿ��ȡ��Ȩ����С�ı�
	
	public KruskalMST(EdgeWeightedGraph G){
		mst = new Queue<Edge>();
		pq = new MinPQ<Edge>(G.E());
		UF uf = new UF(G.V());
		
		for(Edge e : G.edges())
			pq.insert(e);
		while(!pq.isEmpty() && mst.size() < G.V() - 1){
			Edge e = pq.delMin();
			int v = e.either(); int w = e.other(v);
			if(uf.connected(v, w)) continue;
			uf.union(v, w);
			mst.enqueue(e);
		}
		
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
		KruskalMST mst = new KruskalMST(G);
		for(Edge e : mst.edges())
			StdOut.println(e);
		StdOut.println(mst.weight());
	}

}
