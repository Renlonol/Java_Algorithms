
public class Topological {
	private Iterable<Integer> order;
	
	public Topological(Digraph G){
		
		 DirectedCycle cyclefinder = new  DirectedCycle(G);
		 if(!cyclefinder.hasCycle()){
			 DepthFirstOrder dfs = new DepthFirstOrder(G);
			 order = dfs.reversePost();
		 }
		 
	}
	public Iterable<Integer> order() { return order; }
	public boolean isDAG() { return order != null; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = args[0];
		String separator = args[1];
		SymbolGraph sg = new SymbolGraph(filename, separator);
		Topological top = new Topological(sg.G());
		if(!top.isDAG()) StdOut.print("is not a DAG");
		else {
		 for(int v : top.order())
			StdOut.println(sg.name(v));
		}
	}
}
