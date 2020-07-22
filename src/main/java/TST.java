import java.util.LinkedList;
import java.util.Queue;

public class TST<Value> {

	private Node<Value> root;

	private class Node<Value> {
		private Value val;
		private char c;
		private Node<Value> left, mid, right;
	}

	public void put(String key, Value value) {
		root = put(root, key, value, 0);
	}

	private Node<Value> put(Node<Value> x, String key, Value value, int d) {

		char c = key.charAt(d);
		if (x == null) {
			x = new Node<Value>();
			x.c = c;
		}

		if (c < x.c)
			x.left = put(x.left, key, value, d);
		else if (c > x.c)
			x.right = put(x.right, key, value, d);
		else if (d < key.length() - 1)
			x.mid = put(x.mid, key, value, d + 1);
		else
			x.val = value;

		return x;
	}

	public Value get(String key) {
		Node<Value> x = get(root, key, 0);
		if (x == null)
			return null;
		return x.val;
	}

	private Node<Value> get(Node<Value> x, String key, int d) {

		if (x == null)
			return null;
		char c = key.charAt(d);

		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else
			return x;

	}
	
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<String>();
		collect(root, new StringBuilder(), queue);
		return queue;
	}
	
	private void collect(Node<Value> x, StringBuilder prefix, Queue<String> queue) {
		
		if (x == null) return;
		collect(x.left, prefix, queue);
		
		if(x.val != null) queue.add(prefix.toString() + x.c);
		
		
	}
}
