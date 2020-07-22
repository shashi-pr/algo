package leetcode.heap;

public class LastStoneWeight {

	public int lastStoneWeight(int[] stones) {
		createPQ(stones.length);
		for (int stone : stones) {
			insert(stone);
		}

		while (getSize() > 1) {
			int stone1 = deleteMax();
			int stone2 = deleteMax();
			if (stone1 != stone2) {
				int remainingSize = stone1 - stone2;
				insert(remainingSize);
			}
		}

		return pq[1];
	}

	private int[] pq;
	int N;

	private void createPQ(int capacity) {
		pq = new int[capacity + 1];

	}

	private int getSize() {
		return N;
	}

	private void insert(int k) {
		pq[++N] = k;
		swim(N);
	}

	private int deleteMax() {
		int max = pq[1];
		exchange(1, N--);
		sink(1);
		pq[N + 1] = 0;
		return max;
	}

	private void exchange(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	private boolean less(int i, int j) {
		return pq[i] < pq[j];
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exchange(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;

			if (!less(k, j))
				break;

			exchange(k, j);
			k = j;

		}

	}

	public static void main(String[] args) {
		LastStoneWeight lastStoneWeight = new LastStoneWeight();
		int size = lastStoneWeight.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 2 });

		System.out.println(size);

	}

}
