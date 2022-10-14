package com.code.leetcode;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */
public class DeleteTheMiddleNodeOfALinkedList {
	public static void main(String[] args) {
		DeleteTheMiddleNodeOfALinkedList o = new DeleteTheMiddleNodeOfALinkedList();
		ListNode head = o.new ListNode(1);
		head.next = o.new ListNode(3);
		head.next.next = o.new ListNode(4);
		head.next.next.next = o.new ListNode(7);
		head.next.next.next.next = o.new ListNode(1);
		head.next.next.next.next.next = o.new ListNode(2);
		head.next.next.next.next.next.next = o.new ListNode(6);

		head = o.deleteMiddle(head);
		System.out.println();
	}

	public ListNode deleteMiddle(ListNode head) {
		if (head.next == null) return null; // 1 element in list. Deleting it would leave nothing. return null
		// two pointers - slow and fast
		ListNode s = head;
		ListNode f = head.next.next;
		// 2 elements in list. f would now point to null. Delete the second one by
		// setting s.next to null
		if (f == null) {
			s.next = null;
			return head;
		}

		// more than 2 elements. Dry run this for 3 elements and you'd be good
		while (f.next != null) {
			s = s.next;
			f = f.next.next;
			if (f == null) break;
		}
		// s.next is the element to be deleted. Point s.next by skipping s.next
		s.next = s.next.next;
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
