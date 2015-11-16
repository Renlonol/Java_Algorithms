
public class RandomSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		double lo = Double.parseDouble(args[1]);
		double hi = Double.parseDouble(args[2]);
		for(int i = 0; i < N; i++)
		{
			double x = StdRandom.uniform(lo,hi);
			StdOut.printf("%.3f\r\n", x);
			//StdOut.println(x);
		}
//		double sum = 0.0;
//		int cnt = 0;
//		for(int i = 0; i < 5; ++i)//while(!StdIn.isEmpty())
//		{
//			sum += StdIn.readDouble();
//			cnt++;
//		}
//		StdOut.printf("Average is %.2f\n", sum/cnt);
	}

}
