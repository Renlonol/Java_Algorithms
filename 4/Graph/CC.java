
public class CC {
	private boolean[] marked;
	private int count;//连通分量个数
	private int[] id;//连通分量id
	
	public CC(Graph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for(int s = 0; s < G.V(); s++){
			if(!marked[s]){
				dfs(G,s);
				count++;
			}
		}
	}
	private void dfs(Graph G, int v){
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G,w);
		}
	}
	public boolean connected(int v, int w){
		return id[v] == id[w];
	}
	public int count(){
		return count;
	}
	public int id(int v){
		return id[v];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph( new In(args[0]));
		CC cc = new CC(G);
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
