
public class Graph {
	private final int V;//������Ŀ
	private int E;//����Ŀ
	private Bag<Integer>[] adj;//�ڽӱ�
	
	public Graph(int v){
		//����һ���յ��ڽӱ�
		this.V = v; this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i = 0; i < V; i++)
			adj[i] = new Bag<Integer>();
	}
	public Graph(In in){
		//����������ȡͼ
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public int V() { return V; }
	public int E() { return E; }
	public void addEdge(int v, int w){
		//���һ����
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public String toString(){
		String s = V + " vertices, " + E + " edges\n";
		for(int v = 0; v < V; v++){
			s += v+ ": ";
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
		Graph g = new Graph(in);
		StdOut.print(g.toString());
	}

}
