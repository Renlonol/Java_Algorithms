
public class Cycle {
	//ͼ�Ƿ��л����жϵ�����Ϊ����������Ľڵ��Ѿ������������ж������Ľڵ��Ƿ�������Ľڵ���ͬһ�ڵ㣬������Ϊԭ·���أ���ʱ���޷��ж��Ƿ���ڻ�������������
	//������ͬһ�ڵ㣬����ڻ���
	private boolean[] marked;
	private boolean hasCycle;
	
	public Cycle(Graph G){
		marked = new boolean[G.V()];
		for(int s = 0; s < G.V(); s++){
			if(!marked[s])
				dfs(G,s,s);
		}
	}
	private void dfs(Graph G, int v, int u){
		marked[v] = true;
		for(int w : G.adj(v)){
			if(!marked[w])
				dfs(G,w,v);
			else if(w != u) hasCycle = true;//�ж������Ľڵ��Ƿ�������Ľڵ���ͬһ�ڵ�
		}
	}
	
	public boolean hasCycle(){
		return  hasCycle;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph G = new Graph(new In(args[0]));
		Cycle C = new Cycle(G);
		if(C.hasCycle()) StdOut.print("the Graph has cycle.");
		else StdOut.print("the Graph has no cycle.");
	}

}
