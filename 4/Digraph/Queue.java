import java.util.Iterator;



public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() { return first  == null; }
	public int size() { return N; }
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;		
		if(isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}
	public Item dequeue(){
		Item item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		N--;
		return item;
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
//		Queue<String> q = new Queue<String>();
//		while(!StdIn.isEmpty()){
//			String item = StdIn.readString();
//			if(!item.equals("-"))
//				q.enqueue(item);
//			else if(!q.isEmpty())
//				StdOut.println(q.dequeue() + " ");				
//		}
//		StdOut.println("(" + q.size() + " left on queue)");
		Queue<String> q = new Queue<String>();
		String[] text = In.readStrings(args[0]);
		int k = Integer.parseInt(args[1]);
		for(String s : text)	q.enqueue(s);
		StdOut.printf("%d,%d\n",q.size(),k);
		if( k > text.length) 	StdOut.print("k is invaild");
		else{
				int size_q  = q.size();
				for(int i = 0; i < size_q - k; i++)
					q.dequeue();
				StdOut.print(q.dequeue());
		}
	}

}
