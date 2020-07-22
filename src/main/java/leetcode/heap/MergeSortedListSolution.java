package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedListSolution {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
		
		public int getVal() {
			return val;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {

		ListNode resultHead = null;
		ListNode current = null;

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(( o1,  o2) -> o1.getVal()- o2.getVal());

		for (ListNode listNode : lists) {
			pq.offer(listNode);
		}

		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			if (resultHead == null) {
				resultHead = node;
				current = node;
			} else {
				current.next = node;
				current = current.next;
			}

			if (node.next != null) {
				pq.add(node.next);
			}

		}

		return resultHead;
	}

	static void print(ListNode node) {
		ListNode current = node;
		while (current != null) {
			System.out.print("-->" + current.val);
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(5);
		print(list1);

		ListNode list2 = new ListNode(4);
		list2.next = new ListNode(8);
		print(list2);

		ListNode list3 = new ListNode(4);
		list3.next = new ListNode(6);
		list3.next.next = new ListNode(9);
		print(list3);

		ListNode list4 = new ListNode(2);
		list4.next = new ListNode(7);
		list4.next.next = new ListNode(10);
		print(list4);

		ListNode[] heads = new ListNode[] { list1, list2, list3, list4 };
		ListNode result = mergeKLists(heads);
		System.out.println("Merged Linked List: ");
		print(result);
	}

}
