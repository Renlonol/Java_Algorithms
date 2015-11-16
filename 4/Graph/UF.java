
public class UF {
	
	private int [] id;
	private int count;
	public UF(int N){
		//������Ϊ��ʶ��ʼ��N������
		id = new int[N];
		for(int i = 0; i < N; i++)
			id[i] = i;
		count = N;
	}
	public void print_id(){
		for(int d : id)
			StdOut.print(d + " ");
	}
	public int count(){
		return count;
	}
	private int find( int p){
		//���ش����ʶ
		return id[p];
	}
	public boolean connected(int p, int q){
		//�����ͨ��ΪTrue
		return find(p) == find(q);
	}
	public void union(int p, int q){
		//������������
		int pID = find(p);
		int qID = find(q);
		if(find(p) == qID)	return;
		for(int i = 0; i < id.length; i++)
			if(id[i] == pID)	id[i] = qID;
		count--;					
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(uf.connected(p, q))	continue;
			uf.union(p, q);
			StdOut.println(p + " "+ q);
			uf.print_id();
			StdOut.println();
		}
		StdOut.println(uf.count() + "components");
	}

}
