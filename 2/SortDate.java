
public class SortDate {

	private static class Date implements Comparable<Date>{
		private final int day;
		private final int month;
		private final int year;
		
		public Date(int d, int m, int y){
			day = d; month =m; year =y;
		}
		public int day()   { return day; }
		public int month() { return month; }
		public int year()  { return year; }
		
		public int compareTo(Date that){
			if(this.year > that.year )   return +1;
			if(this.year < that.year)    return -1;
			if(this.month > that.month ) return +1;
			if(this.month < that.month)  return -1;
			if(this.day > that.day )     return +1;
			if(this.day < that.day)      return -1;
			return 0;
		}
		public String toString()
		{ return day + "/" + month + "/" + year; }
		
	}
	public static Date[] readDates( int N,String alg){
		Date[] dates = new Date[N];
		int [] date_d = In.readInts(alg);
		for(int i = 0,j = 0; i < date_d.length; i += 3, j++)
			dates[j] = new Date(date_d[i], date_d[i+1],date_d[i+2]);
		return dates;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		//StdOut.printf("N,d = %d %d",N,d);
		Date[] dates = readDates(N,args[1]);
		Shell.sort(dates);
		for(int i = 0; i < N; i++)
			StdOut.println(dates[i]);
	}
}
