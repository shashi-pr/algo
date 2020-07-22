package leetcode.binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

	public static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length < 2)
			return 0;

		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] interval1, int[] interval2) {
				return interval1[0] - interval2[0];
			}
		});

		int min = 0;
		int end = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < end) {
				end = Math.min(end, intervals[i][1]);
				min++;
			} else {
				end = intervals[i][1];
			}
		}
		return min;

	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		int result = eraseOverlapIntervals(intervals);
		
		System.out.println(result);
	}

}
