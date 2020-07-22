package leetcode.dynamicprogramming;

public class ZeroOneKnapackBurteForce {

	public static int solveKnapsack(int[] weights, int[] profits, int capacity) {
		int[][] dp = new int[weights.length][capacity + 1];
		return solveKnapsack(dp, weights, profits, capacity, 0);
	}

	private static int solveKnapsack(int[][] dp, int[] weights, int[] profits, int capacity, int index) {

		if (capacity <= 0 || index >= profits.length)
			return 0;

		if (dp[index][capacity] != 0)
			return dp[index][capacity];

		int profit1 = 0;
		if (weights[index] <= capacity) {
			profit1 = profits[index] + solveKnapsack(dp, weights, profits, capacity - weights[index], index + 1);
		}

		int profit2 = solveKnapsack(dp, weights, profits, capacity, index + 1);

		dp[index][capacity] = Math.max(profit1, profit2);

		return dp[index][capacity];
	}

	public static void main(String[] args) {
		int[] weights = new int[] { 2, 3, 1, 4 };
		int[] profits = new int[] { 4, 5, 3, 7 };

		int capacity = 5;

		int maxProfit = solveKnapsack(weights, profits, capacity);

		System.out.println(maxProfit);

	}

}
