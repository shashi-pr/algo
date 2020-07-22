package interview;

import java.util.Arrays;

public class RemoveDuplicateFromSortedArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 3, 3, 4, 4 };

		int j = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if(array[i] != array[i + 1]) {
				array[j] = array[i];
				j++;
			}			
		}
		array[j] = array[array.length -1];
		System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, j + 1)));

	}

}
