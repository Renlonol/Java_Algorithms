
public class Selection {
	
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
	public static void sort(Comparable[] a){
		//ѡ������ÿ��ѭ���ҳ���С�Ķ��󣬽�֮������λ����ʣ�µ�Ԫ���м����ò�����
		for(int i = 0; i < a.length; i++){
			int min = i;
			for(int j = i+1; j < a.length; j++){
				if(less(a[j],a[min]))	min = j;
			}
			exch(a,i,min);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = In.readStrings(args[0]);
		show(a);
		sort(a);
		assert isSorted(a) : "sort to a is invalid";
		show(a);
	}

}
