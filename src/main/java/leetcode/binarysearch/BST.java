package leetcode.binarysearch;

public class BST<Key extends Comparable<Key>, Value> {

	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int count;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node root;

	public Value get(Key key) {
		Node node = root;
		while (node != null) {
			int cmp = key.compareTo(node.key);
			if (cmp < 0) {
				node = node.left;
			} else if (cmp > 0) {
				node = node.right;
			} else
				return node.value;
		}

		return null;
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);

	}

	private Node put(Node node, Key key, Value value) {
		if (node == null)
			return new Node(key, value);
		int cmp = key.compareTo(node.key);
		if (cmp > 0)
			node.right = put(node.right, key, value);
		if (cmp < 0)
			node.left = put(node.left, key, value);
		else
			node.value = value;
		node.count = 1 + size(node.left) + size(node.right);
		return node;
	}

	public int rank(Key key) {

		return rank(root, key);
	}

	private int rank(Node node, Key key) {
		if (node == null)
			return 0;

		int cmp = key.compareTo(node.key);

		if (cmp < 0)
			return rank(node.left, key);
		else if (cmp > 0)
			return 1 + rank(node.right, key) + size(node.left);
		else
			return size(node.left);
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		return node.count;
	}

}
