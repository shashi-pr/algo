package com.edu.algo;

import java.util.Arrays;

public class SortExample {

	public static void main(String[] args) {
		Integer[] array = new Integer[]{1,2,4,3,6};
	
		//selectionSort(array);
	insertionSort(array);
		
		System.out.println(Arrays.toString(array));
	}
	
	//N2/2
	private static void selectionSort(Comparable[] array) {
		int length = array.length;		
		for (int i = 0; i < length; i++) {
			 int min = i;			 
			 for (int j = i+1; j < length; j++) {
				 if(less(array[j], array[min])) {
					 min = j;
				 }		
			 }
			exchange(array, i, min);
		}
	}
	
	//N2/4
	private static void insertionSort(Comparable[] a) {
		int length = a.length;
		for (int i = 0; i < length; i++) {
			for (int j = i; j >0; j--)  {
				if(less(a[j], a[j-1])) {
					exchange(a, j , j-1);
				} else break;
			}
				
		}
	}

	private static void exchange(Comparable[] array, int i, int j) {
		Comparable swap = array[i];
		array[i] = array[j];
		array[j] = swap;		
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
}
