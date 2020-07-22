package com.edu.algo;

import java.util.LinkedList;

public class TrieST<Value> {
	
	private static final int R = 256; //Extended ASCII
	private Node root = new Node();
	
	private static class Node {
		private Object value;
		private Node[] next = new Node[R];
	}
	
	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		
		if (x == null) x = new Node();
		if(d == key.length()) {
			x.value = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}
	
	@SuppressWarnings("unchecked")
	public Value get(String key) {
		Node x = get(root, key, 0);
		if(x == null) return null;
		return (Value) x.value;
	}
	
	private Node get(Node x, String key, int d) {
		if (x == null) return null;
		if(d == key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}
	
	public Iterable<String> keys() {
		LinkedList<String> queue = new LinkedList<String>();
		collect(root, "", queue);
		return queue;
	}
	
	private void collect(Node x, String prefix, LinkedList<String> q) {
		
		if(x == null) return;
		if(x.value != null) q.offer(prefix);
		for (char c = 0; c< R; c++) {
			collect(x.next[c], prefix + c, q);
		}
		
	}

	public static void main(String[] args) {
		TrieST trieST = new TrieST();
		trieST.put("ab", "hello");
	}
	

}
