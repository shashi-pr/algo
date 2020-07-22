package leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonSubSequence {

	private static int bruteForceLongestCommonSubsequence(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int[] max = new int[nums.length];

		Arrays.fill(max, 1);

		int result = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					max[i] = Math.max(max[i], max[j] + 1);
				}
			}
			result = Math.max(result, max[i]);
		}
		return result;
	}

	private static int binarySearchLongestCommonSubsequence(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		ArrayList<Integer> list = new ArrayList<>();

		for (int num : nums) {
			if (list.size() == 0 || num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				int i = 0;
				int j = list.size() - 1;

				while (i < j) {
					int mid = (i + j) / 2;
					if (list.get(mid) < num) {
						i = mid + 1;
					} else {
						j = mid;
					}
				}
				System.out.println(list.toString());
				list.set(j, num);
				System.out.println(" Setting index " + j + " with " + num + " list is " + list.toString());
			}
		}
		System.out.println(list.toString());
		return list.size();
	}

	public static void main(String[] args) {
		// int[] input = { 10, 9, 2, 5, 3, 7, 1010, 18 };

		// int[] input = { 9, 1, 3, 7, 5, 6, 20 };
		// System.out.println(bruteForceLongestCommonSubsequence(input));

		int[] input = { 8, 10, 2, 3, 7, 5, 6, 20 };

		System.out.println(binarySearchLongestCommonSubsequence(input));

	}

}
