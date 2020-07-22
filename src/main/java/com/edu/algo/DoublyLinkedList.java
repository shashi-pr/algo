package com.edu.algo;

public class DoublyLinkedList<Item> {
	
	private Node head;
	private Node last;
	
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	
	
	public Item removeFirst() {
		Item item = head.item;
		
		head = head.next;
		head.previous = null;
		
		return item;
	}
	
	public Item removeLast() {		
		Item item = last.item;		
		last = last.previous;
		last.next = null;
		
		return item;
		
	}
	
	public void addFirst(Item item) {
		
		Node node = new Node();
		node.item = item;
		
		node.next = head;
		node.previous= null;
		if(head != null) {
			head.previous = node;		
		}
		head = node;
		
		if(last == null) {
			last = node;
		}
			
		
		
	}
	
	public void addLast(Item item) {
		Node node = new Node();
		node.item = item;	
		if(last != null)
			last.next = node;
		node.previous= last;
		last = node;
		
		if(head == null)
			head = node;
		
		
		
		
	}

}
