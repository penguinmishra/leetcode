package com.code.leetcode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList a = new FlattenBinaryTreeToLinkedList();
		TreeNode node = a.new TreeNode(1);
		node.left = a.new TreeNode(2);
		node.left.left = a.new TreeNode(3);
		node.left.right = a.new TreeNode(4);
		node.right = a.new TreeNode(5);
		node.right.right = a.new TreeNode(6);
		a.flatten(node, a);
	}

	TreeNode prev = null;

	public void flatten(TreeNode root, FlattenBinaryTreeToLinkedList a) {
		buildFromRightMostNodeAndUp(root); // this is the key method.
		// print node values
		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
	}
	
	/**
	 * Go to the right most end first. set null to the right and left children to it
	 * and update prev node with its value. Visalise a root and its lone left and
	 * right children - code will make more sense if you take a small input
	 */
	private void buildFromRightMostNodeAndUp(TreeNode root) {
		if(root == null) return;
		buildFromRightMostNodeAndUp(root.right);
		buildFromRightMostNodeAndUp(root.left);
		root.right = prev; // first iteration prev = null
		root.left = null; // update left child with null
		prev = root; // update prev node with current root
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
