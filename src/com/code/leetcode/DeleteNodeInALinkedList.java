package com.code.leetcode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInALinkedList {
	public static void main(String[] args) {
		DeleteNodeInALinkedList o = new DeleteNodeInALinkedList();
		ListNode head = o.new ListNode(4);
		head.next = o.new ListNode(5);
		head.next.next = o.new ListNode(1);
		head.next.next.next = o.new ListNode(9);
		o.deleteNode(head.next.next);
		System.out.println();
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
