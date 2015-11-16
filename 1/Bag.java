import java.util.Iterator;
public class Bag<Item> implements Iterable<Item>{
	private Node first;
	int N;
	//private Item item;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty(){
		return first == null;
	}
	public int size(){
		return N; 
	}
	public void add(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext(){
			return current != null;
		}
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove() {}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag<Double> numbers = new Bag<Double>();
		while(!StdIn.isEmpty()){
			numbers.add(StdIn.readDouble());
		}
		double sum = 0;
		for(double x : numbers)
			sum += x;
		StdOut.printf("the sum is: %.2f\n",sum);
		StdOut.printf("the avr is: %.2f",sum/numbers.size());		
	}
}
