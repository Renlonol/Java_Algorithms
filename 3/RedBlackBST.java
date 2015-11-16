
public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		Node left, right;
		int N;
		boolean color;//父节点指向他的链接的颜色
		
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
		//右子节点为红色，左子节点为黑色，左旋转
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
		//左子节点为红色且左子节点的左子节点也为红色
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
		//左右节点均为红色
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	private Node put(Node h, Key k, Value v){
		if(h == null) 
			return new Node(k,v,1,RED);
		//递归的查找插入位置
		int cmp = k.compareTo(h.key);
		if(cmp < 0) h.left = put(h.left,k,v);
		if(cmp > 0) h.right = put(h.right,k,v);
		else h.val = v;
		//修正二叉树以保证插入后的红黑树和2-3树的一一对应关系
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
