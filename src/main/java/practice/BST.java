package practice;

public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node node, Key key, Value value) {
		if (node == null) {
			return new Node(key, value);
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			node.left = put(node.left, key, value);
		else if (cmp > 0)
			node.right = put(node.right, key, value);
		else
			node.value = value;

		return node;
	}

	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0)
				x = x.left;
			else if (cmp > 0)
				x = x.right;
			else
				return x.value;
		}
		return null;
	}

	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null)
			return null;
		return x.key;
	}

	private Node floor(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0)
			return x;
		if (cmp < 0) {
			Node r = floor(x.left, key);
			return r;
		}
			
		    
		Node t = floor(x.right, key);
		if (t != null)
			return t;
		else
			return x;
	}

	public void delete(Key key) {

	}

	public Iterable<Key> iterator() {
		return null;
	}
	
	public Node getRoot() {
		return root;
	}

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		BST bst = new BST();
		
		bst.put("S", "S");		
		bst.put("X", "X");
		bst.put("E", "E");
		bst.put("R", "R");		
		bst.put("H", "H");
		bst.put("M", "M");		
		bst.put("A", "A");
		bst.put("C", "C");		
	

		
		System.out.println(bst.floor("G"));
	}
}
