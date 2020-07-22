package practice;

public class ZeroOneKnapSack {
	
	private static int solveKnapSack(int[] profits, int[] weights, int capacity) {
		Integer dp[][] = new Integer[profits.length][capacity +1];
		
		return solveKnapSack(dp, profits, weights, capacity, 0);
		
	}
	
	

	private static int solveKnapSack(Integer[][] dp, int[] profits, int[] weights, int capacity, int index) {
		
		if (index >= profits.length || capacity <= 0) {
			return 0;
		}
		
		if (dp[index][capacity] != null) {
			return dp[index][capacity];
		}
		
		int profit1 = 0;
		if (weights[index] <= capacity ) {
			profit1 = profits[index] + solveKnapSack(dp, profits, weights, capacity - weights[index], index + 1);
		}
		
		int profit2 = solveKnapSack(dp, profits, weights, capacity , index + 1);
		
		dp[index][capacity] = Math.max(profit1, profit2);
		
		return dp[index][capacity];
	}



	public static void main(String[] args) {
		int[] profits = {1, 6, 10, 16};
	    int[] weights = {1, 2, 3, 5};
	    int capacity = 7;
	    
	    int maxProfit = solveKnapSack(profits, weights, capacity);
	    
	    System.out.println("MaxProfit is : "+ maxProfit);

	}

}
