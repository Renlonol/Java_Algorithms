
public class Merge {
	
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
	
	private static void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi){
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++){
			aux[k] = a[k];
		}
		for(int k = lo; k <= hi; k++){
			if	   (i > mid)				a[k] = aux[j++];
			else if(j > hi)					a[k] = aux[i++];
			else if(less(aux[j],aux[i]))	a[k] = aux[j++];
			else 						    a[k] = aux[i++];
		}
	}
	public static void sort(Comparable[] a){
		Comparable[] aux = new Comparable[a.length];
		sort(a,aux,0,a.length - 1);
	}
	private static void sort(Comparable[] a,Comparable[] aux, int lo, int hi){
		if(hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a,aux,lo,mid);
		sort(a,aux,mid+1,hi);
		merge(a,aux,lo,mid,hi);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] a = In.readStrings(args[0]);
		show(a);
		sort(a);
		assert isSorted(a) : "sort to a is invalid";
		show(a);
	}

}
