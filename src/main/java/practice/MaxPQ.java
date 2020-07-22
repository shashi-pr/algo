package practice;

public class MaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N;

	public MaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity + 1];
	
	}

	public boolean isEmpty() {
		return true;
	}

	public Key deleteMax() {
		Key max = pq[1];
		exchange(1, N--);
		sink(1);
		pq[N + 1] = null;
		return max;
	}

	public void insert(Key key) {
		pq[++N] = key;
		swim(N);
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

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exchange(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	public static void main(String[] args) {
		MaxPQ maxPQ = new MaxPQ(10);
		maxPQ.insert("G");
		maxPQ.insert("I");
		maxPQ.insert("K");
		
		System.out.print(maxPQ.deleteMax());
	}

}
