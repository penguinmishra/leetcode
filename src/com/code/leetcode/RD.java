package com.code.leetcode;

public class RD {
	public static void main(String[] args) {
		RD o = new RD();
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head.next == null) return head;
		ListNode curr = head;
		while(curr.next != null) {
			if(curr.val == curr.next.val) continue;
		}
		return null;
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
