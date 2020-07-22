package interview.hackerrank;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static final void mergeSort(int a[]) {
		int[] aux = new int[a.length];
		sort(aux, a, 0, a.length - 1);
	
	}
	
	
	private static final void sort(int aux[], int a[], int lo, int hi) {
		if( hi <= lo ) return;
		int mid = lo + (hi - lo)/2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
		
		
	}
	
	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		
		
	}

	private static final void merge() {
		
	}
	

}
