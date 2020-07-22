package interview;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private class Node {
		private Key key;
		private Value value;
		Node left, right;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node root;

	public void put(Key key, Value value) {
		root = put(root, key, value);
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

	private Node put(Node node, Key key, Value value) {
		if (node == null)
			return new Node(key, value);

		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			node.left = put(node.left, key, value);
		else if (cmp > 0)
			node.right = put(node.right, key, value);
		else
			node.value = value;
		return node;
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<Key>();
		inorder(root, queue);
		return queue;
	}

	private void inorder(Node x, Queue queue) {
		if (x == null)
			return;

		inorder(x.left, queue);
		queue.add(x.key);
		inorder(x.right, queue);
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node node) {
		if (node == null)
			return 0;

		int lHeight = getHeight(node.left);

		int rHeight = getHeight(node.right);
		if (lHeight > rHeight) {
			return 1 + rHeight; // reverse?
		} else {
			return 1 + lHeight;
		}
	}

	public int getDiameter() {
		return getDiameter(root);
	}

	private int getDiameter(Node node) {
		if (node == null)
			return 0;

		int lHeight = getHeight(node.left);
		int rHeight = getHeight(node.right);

		int lDiameter = getDiameter(node.left);
		int rDiameter = getDiameter(node.right);

		int fd = Math.max(1 + lHeight + rHeight, Math.max(lDiameter, rDiameter));
		return fd;
	}
}
