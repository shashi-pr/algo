
public class Knapsack {
	
	
	public int solveKanpSack(int [] weights, int [] profits, int capacity) {
		return solveKanpSack(weights, profits, capacity, 0);
	}
	
	private int solveKanpSack(int [] weights, int [] profits, int capacity, int currentIndex) {
		
		if (capacity <= 0 || currentIndex >= profits.length) return 0;
		
		int profit1 = 0;
		if(weights[currentIndex]  <= capacity) {
			profit1 = profits[currentIndex] + solveKanpSack(weights, profits, capacity - weights[currentIndex] , currentIndex + 1);
		}
		
		int profit2 = solveKanpSack(weights, profits, capacity, currentIndex + 1);
		return Math.max(profit1, profit2);
	}
	
	public static void main(String[] args) {
		
		
	}

}
