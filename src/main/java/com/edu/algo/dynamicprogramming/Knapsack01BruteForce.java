package com.edu.algo.dynamicprogramming;

public class Knapsack01BruteForce {

	private int findOptiomalItems(int w, int n, int[] val, int[] weight) {

		if (w <= 0 || n == weight.length) {
			return 0;
		}

		if (weight[n] > w) {
			return findOptiomalItems(w, n + 1, val, weight);
		}

		int include_n_benefit = val[n] + findOptiomalItems(w - weight[n], n + 1, val, weight);
		int exlude_n_benfit = findOptiomalItems(w, n + 1, val, weight);

		return Math.max(include_n_benefit, exlude_n_benfit);
	}

	public static void main(String[] args) {
		Knapsack01BruteForce knapsack01 = new Knapsack01BruteForce();

		int[] val = { 3, 7, 2, 9 };
		int[] weight = { 2, 2, 4, 5 };

		int maxweight = knapsack01.findOptiomalItems(10, 0, val, weight);

		System.out.println(maxweight);

	}
}
