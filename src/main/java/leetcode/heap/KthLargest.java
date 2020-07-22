package leetcode.heap;

import java.util.PriorityQueue;

class KthLargest {
	PriorityQueue<Integer> heap;
	int k;

	public KthLargest(int k, int[] nums) {
		heap = new PriorityQueue(k);
		this.k = k;
		for (int i : nums) {
			add(i);
		}
	}

	public int add(int val) {
		if (heap.size() < k) {
			heap.offer(val);
		} else if (val > heap.peek()) {
			heap.poll();
			heap.offer(val);
		}
		return heap.peek();
	}

	public static void main(String[] args) {
		int k = 3;

		KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });

		int val = kthLargest.add(3);
		// val = kthLargest.add(5);
		// val = kthLargest.add(10);
		System.out.println(val);
	}

}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
