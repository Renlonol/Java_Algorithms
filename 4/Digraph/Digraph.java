
public class Digraph {
	private final int V;//定点数
	private int E;//边数
	private Bag<Integer>[] adj;//与某一顶点指出的所有定点的集合
	public Digraph(int v){
		//创建含有定点而没有边的有向图
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[v];
		for(int i = 0; i < v; i++){
			adj[i] = new Bag<Integer>();
		}
	}
	public Digraph(In in){
		//从输入流创建有向图
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public void addEdge(int v,int w){
		//添加一条从 v 指向 w 的边
		adj[v].add(w);
		E++;
	}
	public int V(){	return V; }
	public int E(){ return E; }
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public Digraph reverse(){
		Digraph R = new Digraph(V);
		for(int v = 0; v < V; v++){
			for(int w  : adj[v])
				R.addEdge(w, v);
		}
		return R;
	}
	public String toString(){
		String s = V + " vertices, " + E + " edges\n";
		for(int v = 0; v < V; v++){
			s += v + ": ";
			for(int w : this.adj(v)){
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		In in = new In(args[0]);
		Digraph g = new Digraph(in);
		StdOut.print(g.toString());
	}

}
