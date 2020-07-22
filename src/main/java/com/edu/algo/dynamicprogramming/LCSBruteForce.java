package com.edu.algo.dynamicprogramming;

public class LCSBruteForce {

	public int findLongestCommonSubsequence(String s1, String s2) {
		return findLongestCommonSubsequence(s1, s2, 0, 0, 0);

	}

	private int findLongestCommonSubsequence(String s1, String s2, int i1, int i2, int count) {
		// TODO Auto-generated method stub
		if (i1 == s1.length() || i2 == s2.length())
			return count;
		if (s1.charAt(i1) == s2.charAt(i2)) {
			count = findLongestCommonSubsequence(s1, s2, i1 + 1, i2 + 1, count + 1);
		}
		int c1 = findLongestCommonSubsequence(s1, s2, i1 , i2 + 1, 0);
		int c2 = findLongestCommonSubsequence(s1, s2, i1 + 1, i2 , 0);

		return Math.max(count, Math.max(c1, c2));
	}

	public static void main(String[] args) {
		LCSBruteForce lcs = new LCSBruteForce();
		System.out.println(lcs.findLongestCommonSubsequence("abdca", "cbda"));

	}

}
