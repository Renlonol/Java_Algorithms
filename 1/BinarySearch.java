import java.util.Arrays;
//BinarySearch class
public class BinarySearch {
	//no recursion
	public static int rank(int key, int[] a,Counter c){
		int lo = 0;
		int hi = a.length - 1;
		c.increment();
		while(lo <= hi){
			int mid = hi + (lo - hi)/2;
			if(key < a[mid])
				hi = mid - 1;
			else if(key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	//recursion
	public static int rank1(int key, int[] a, int lo, int hi){
		if(lo > hi) return -1;
		int mid = lo + (hi - lo)/2;
		if(key < a[mid]) return rank1(key, a, lo, mid - 1);
		else if(key > a[mid]) return rank1(key, a, mid + 1, hi);
		else return mid;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c = new Counter("keynum");
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
//		while(!StdIn.isEmpty()){
//			int key = StdIn.readInt();
//			if(rank(key,whitelist) < 0){
//				StdOut.println(key);
//			}
//		}
		int[] keylist = In.readInts(args[1]);
		for(int i = 0; i < keylist.length; i++)
			if(rank(keylist[i],whitelist,c) < 0)
				StdOut.println(keylist[i]);
		StdOut.println(c.toString());
	}
}
