package leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
		// Min pq for capitals
		PriorityQueue<int[]> pqCap = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
		// Max pq for profits
		PriorityQueue<int[]> pqPro = new PriorityQueue<int[]>((a, b) -> (b[1] - a[1]));
		for (int i = 0; i < Capital.length; i++) {
			pqCap.offer(new int[] { Capital[i], Profits[i] });
		}
		
	
		for (int i = 0; i < k; i++) {
			while (!pqCap.isEmpty() && pqCap.peek()[0] <= W)
				pqPro.offer(pqCap.poll());
			if (pqPro.isEmpty())
				break;
			W += pqPro.poll()[1];
		}
		return W;
	}

	public static void main(String[] args) {
		int k = 2, W = 0;
		int[] profits = new int[] { 1, 3, 2 };
		int[] capital = new int[] { 0, 1, 1 };

		int profit = findMaximizedCapital(k, W, profits, capital);

		System.out.println(profit);

	}

}
