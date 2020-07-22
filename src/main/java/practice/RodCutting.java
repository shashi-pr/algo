package practice;

public class RodCutting {

	private static int cutRod(int[] length, int[] profit, int size) {
		Integer[][] dp = new Integer[length.length][size + 1];
		return cutRod(dp, length, profit, size, 0);
	}

	private static int cutRod(Integer[][] dp, int[] length, int[] profit, int size, int index) {

		if (index >= profit.length || size <= 0) {
			return 0;
		}

		if (dp[index][size] != null) {
			return dp[index][size];
		}

		int profit1 = 0;

		if (length[index] <= size) {
			profit1 = profit[index] + cutRod(dp, length, profit, size - length[index], index);
		}

		int profit2 = cutRod(dp, length, profit, size, index + 1);

		dp[index][size] = Math.max(profit1, profit2);

		return dp[index][size];
	}

	public static void main(String[] args) {

		int[] length = { 1, 2, 3, 4, 5 };
		int[] prices = { 2, 6, 7, 10, 13 };

		int size = 5;

		int maxProfit = cutRod(length, prices, size);

		System.out.println(maxProfit);

	}

}
