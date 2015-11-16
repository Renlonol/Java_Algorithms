
public class Quick {
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];	a[i] = a[j];	a[j] = t; 
	}
	
	private static void show(Comparable[] a){
		for(int i = 0; i < a.length; i++){
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i = 1 ; i < a.length; i++){
			if(less(a[i],a[i-1]))	return false;
		}
		return true;
	}
	
	private static int partition(Comparable[] a, int lo, int hi){
		int i = lo, j = hi + 1 ;
		Comparable v = a[lo];
		while(true){
			while(less(a[++i],v))	if(i == hi) break;
			while(less(v,a[--j]))	if(j == lo) break;
			if(i >= j) break;
			exch(a,i,j);
		}
		exch(a,j,lo);
		return j;	
	}
	private static void sort(Comparable[] a, int lo, int hi){
		if(hi <= lo + 8)	{ Insertion.sort(a); return; }
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String [] a = In.readStrings(args[0]);
		show(a);
		sort(a);
		assert isSorted(a) : "sort to a is invalid";
		show(a);
	}

}
