package leetcode.heap;

import java.util.Arrays;

public class MinimumSumAfterKNegation {

	public static int largestSumAfterKNegations(int[] A, int K) {
		for (int i = 0; i < K; i++) {
			int min = A[0];
			int minIndex = 0;

			for (int j = 0; j < A.length; j++) {
				if (A[j] <= min) {
					minIndex = j;
					min = A[j];
				}
			}
			if (min == 0)
				break;
			else {
				System.out.println(" minIndex " + minIndex);
				A[minIndex] = -A[minIndex];
			}
		}

		return Arrays.stream(A).reduce(0, (x, y) -> x + y);
	}

	public static void main(String[] arrays) {
		int[] A = new int[] { 4, 2, 3 };
		int k = 1;
		System.out.println(largestSumAfterKNegations(A, k));
	}

}
