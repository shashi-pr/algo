package com.edu.algo.dynamicprogramming;

public class Knapsack01TopDown {
	
	public int findOptiomalItems(int w, int[] val, int[] weight) {
		int[][] dp = new int[val.length][w + 1];
		return findOptiomalItems(w, 0, val, weight, dp);
	}
	
	
	private int findOptiomalItems(int w, int n, int[] val, int[] weight, int[][] dp) {

		if (w == 0 || n == weight.length) {
			return 0;
		}
		
		if(dp[n][w] != 0) {
			return dp[n][w];
		}

		if (weight[n] > w) {
			return findOptiomalItems(w, n + 1, val, weight, dp);
		}

		int include_n_benefit = val[n] + findOptiomalItems(w - weight[n], n + 1, val, weight, dp);
		int exlude_n_benfit = findOptiomalItems(w, n + 1, val, weight, dp);

		dp[n][w] = Math.max(include_n_benefit, exlude_n_benfit);
		
		return dp[n][w];
	}

	public static void main(String[] args) {
		Knapsack01TopDown knapsack01 = new Knapsack01TopDown();

		int[] val = { 3, 7, 2, 9 };
		int[] weight = { 2, 2, 4, 5 };

		int maxweight = knapsack01.findOptiomalItems(10, val, weight);

		System.out.println(maxweight);

	}
}
