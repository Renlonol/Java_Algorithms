
public class Digraph {
	private final int V;//������
	private int E;//����
	private Bag<Integer>[] adj;//��ĳһ����ָ�������ж���ļ���
	public Digraph(int v){
		//�������ж����û�бߵ�����ͼ
		this.V = v;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[v];
		for(int i = 0; i < v; i++){
			adj[i] = new Bag<Integer>();
		}
	}
	public Digraph(In in){
		//����������������ͼ
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}
	public void addEdge(int v,int w){
		//���һ���� v ָ�� w �ı�
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
