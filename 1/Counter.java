
public class Counter {
	private final String name;
	private int count;
	//conductor
	public Counter(String id)
	{ name = id; }
	//method
	public void increment()
	{ count++; }
	
	public int tally()
	{ return count; }
	
	public String toString()
	{ return count + " " + name; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
