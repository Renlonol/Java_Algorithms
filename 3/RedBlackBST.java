
public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		Node left, right;
		int N;
		boolean color;//���ڵ�ָ���������ӵ���ɫ
		
		Node(Key k, Value v, int n, boolean c){
			key = k; val = v; N = n; color = c;
		}
	}
	private int size(Node x){
		if(x == null) return 0;
		return x.N;
	}
	private boolean isRed(Node x){
		if(x == null) return false;
		return x.color == RED;
	}
	private Node rotateLeft(Node h){
		//���ӽڵ�Ϊ��ɫ�����ӽڵ�Ϊ��ɫ������ת
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}
	private Node rotateRight(Node h){
		//���ӽڵ�Ϊ��ɫ�����ӽڵ�����ӽڵ�ҲΪ��ɫ
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.N = h.N;
		h.N = size(h.left) + size(h.right) + 1;
		return x;
	}
	private void flipColor(Node h){
		//���ҽڵ��Ϊ��ɫ
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	private Node put(Node h, Key k, Value v){
		if(h == null) 
			return new Node(k,v,1,RED);
		//�ݹ�Ĳ��Ҳ���λ��
		int cmp = k.compareTo(h.key);
		if(cmp < 0) h.left = put(h.left,k,v);
		if(cmp > 0) h.right = put(h.right,k,v);
		else h.val = v;
		//�����������Ա�֤�����ĺ������2-3����һһ��Ӧ��ϵ
		if(isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right))     flipColor(h); 
		
		h.N = size(h.left) + size(h.right) + 1;
		return h;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
