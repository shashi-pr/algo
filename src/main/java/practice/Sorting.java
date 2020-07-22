package practice;

import java.util.Arrays;

public class Sorting {
	
	public static void main(String [] args) {
		Integer[] array = new Integer[]{1,2,4,3,6};
		//selectionSort(array);
		//insertionSort(array);
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void selectionSort(Comparable[] a) {
		int length = a.length;
		
		for (int i = 0; i < length; i++) {
			int min = i;
			for(int j = i + 1; j < length; j++) {
				if(less(a[j], a[min])) {
					min = j;
				}				
			}
			 exchange(a, i, min);
		}
	}
	
	public static void insertionSort(Comparable[] a) {
		int length = a.length;
		
		for(int i = 0; i < length; i++) {
			for (int j = i; j > 0; j--) {
				if(less(a[j], a[j - 1])) {
					exchange(a, j , j -1);
				} else break;
			}
		}
	}
	
	public static void mergeSort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
		
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid +1 , hi);
		merge(a, aux, lo, mid, hi);
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		int i = lo, j = mid +1;
		
		for (int k = lo; k <= hi; k++) {
			if(i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if (less(aux[i], aux[j])) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	
	public void quickSort() {
		
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exchange(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
