
public class SymbolGraph {
	private BinarySearchST<String,Integer> st;
	private String[] keys;
	private Digraph G;
	private final int capacity = 20;
	
	public SymbolGraph(String stream, String sp){
		st = new BinarySearchST<String,Integer>(capacity);
		//构造符号表索引
		In in = new In(stream);
		while(in.hasNextLine()){
			String[] a = in.readLine().split(sp);
			for(int i = 0; i < a.length; i++){
				if(!st.contains(a[i]))
					st.pull(a[i], st.size());
			}
		}
		//顶点名反向索引
		keys = new String[st.size()];
		for(String name : st.keys())
			keys[st.get(name)] = name;
		//构造图
		G = new Digraph(st.size());
		in = new In(stream);
		while(in.hasNextLine()){
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for(int i = 1; i < a.length; i++)
				G.addEdge(v, st.get(a[i]));
		}
	}
	public boolean contains(String s) { return st.contains(s); }
	public int index(String s) { return st.get(s); }
	public String name(int v) { return keys[v]; }
	public Digraph G() { return G; }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = args[0];
		String delim = args[1];
		SymbolGraph sg = new SymbolGraph(filename, delim);
		Digraph G = sg.G(); 
		while(StdIn.hasNextLine()){
			String source = StdIn.readLine();
			for(int w : G.adj(sg.index(source)))
				StdOut.println("  " + sg.name(w));
		}
	}

}
