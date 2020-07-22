package com.edu.algo;

public class Substring {

	public static void main(String[] args) {
		array();
	}

	void string() {
		String string = "fun";
		int length = string.length();
		String sub;

		System.out.println("Substrings of \"" + string + "\" are:");

		for (int i = 0; i < length; i++) {
			for (int j = 1; j <= length - i; j++) {
				sub = string.substring(i, i + j);
				System.out.println(sub);
			}
		}
	}
	
	static void array() {
		int[] array = {1, 2, 3};
		int length = array.length;
		
		for(int i = 0; i < length; i++) {			
			for (int j = 1; j < length - i; j++) {
				print(array, i, j);
				System.out.println("");
			}
			
		}
	}
	
	static void print(int[] array, int start, int end) {
		
		for(int i = 0; i < end; i++) {
			System.out.print(array[i]);
		}
	}
}
