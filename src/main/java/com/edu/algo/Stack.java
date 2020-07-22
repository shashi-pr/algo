package com.edu.algo;

public class Stack<Item> {
	
	private Node head;
	
	private class Node {
		Item item;
		Node next;
	}
	
	
	public void push(Item item) {
		Node oldHead = head;
		Node node = new Node();
		node.item = item;
		node.next= oldHead;
	}
	
	public Item pop() {
		Item item = head.item;
		head = head.next;
		return item;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	
	
	public static void main(String[] args) {
	}

}
