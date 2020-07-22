package com.edu.algo;

public class StackArray<Item> {
	
	Item[] items;
	private int N;
	
	public StackArray(int capacity) {
		items = (Item[])new Object[capacity];
	}
	
	
	public boolean isEmpty() {
		return N ==0;
	}
	
	public void push(Item item) {
		items[N++] = item;
	}
	
	public Item pop() {
		Item item = items[--N];
		items[N] = null;
		return item;
	}

}
