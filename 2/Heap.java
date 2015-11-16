
public class Heap {
	
	private static boolean less(Comparable[] a, int i, int j){
		return a[i].compareTo(a[j]) < 0;
	}
	private static void exch(Comparable[]a, int i, int j){
		Comparable v = a[i]; a[i] = a[j]; a[j] = v; 
	}
	private static void sink(Comparable[]a, int k, int N){
		while(2*k <= N){
			int j = 2*k;
			if(j < N && less(a,j,j+1)) j++;
			if(!less(a,k,j)) break;
			exch(a,k,j);
			k = j;
		}
	}
	public static void sort(Comparable[] a){
		//堆排序
		int N = a.length-1;
		for(int i = a.length/2; i >= 1; i--)//将数组数据进行堆排列
			sink(a,i,N);
		while(N > 1){
			exch(a,1,N--);
			sink(a,1,N);
		} 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sTmp = In.readStrings(args[0]);
		String[] a = new String[sTmp.length + 1];
		a[0] = "X";
		for(int i = 1; i <= sTmp.length; i++)
			a[i] = sTmp[i-1];
		for(String s:a)
			StdOut.print(s+" ");
		StdOut.println();
		sort(a);
		for(String s:a)
			StdOut.print(s+" ");
	}

}
