package com.code.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
	public static void main(String[] args) {
		AddTwoNumbers obj = new AddTwoNumbers();
		ListNode a = obj.new ListNode(2);
		a.next = obj.new ListNode(4);
		a.next.next = obj.new ListNode(3);
		ListNode b = obj.new ListNode(5);
		b.next = obj.new ListNode(6);
		b.next.next = obj.new ListNode(4);
		ListNode n = obj.addTwoNumbers(a, b);
		System.out.println(n);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head; // we'll use curr reference to build the final linked list
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10); // in first iteration our list becomes : 0 -> first_sum -> null
			curr = curr.next; // move curr reference to node which has first_sum as value
			if (l1 != null) l1 = l1.next; // move l1 reference to point to next node in first list
			if (l2 != null) l2 = l2.next; // move l2 reference to point to next node in second list
		}
		if (carry != 0) curr.next = new ListNode(carry); // if in the end you are left with a carry, add that as the last node.
		return head.next; // head is still at 0 while we used curr to move references.
	}
	
	/* Definition for singly-linked list. */
	class ListNode {
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
