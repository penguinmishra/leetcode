package com.code.leetcode;

/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 */
public class AddOneRowToTree {
	public static void main(String[] args) {
		AddOneRowToTree o = new AddOneRowToTree();
		TreeNode root = o.new TreeNode(4);
		root.left = o.new TreeNode(2);
		root.left.left = o.new TreeNode(3);
		root.left.right = o.new TreeNode(1);
		root.right = o.new TreeNode(6);
		root.right.left = o.new TreeNode(5);
		TreeNode node = o.addOneRow(root, 1, 1);
		System.out.println(node);
	}

	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		/* depth = 1 is a given condition. */
		if (depth == 1) {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}
		/* This is our base condition. */
		if (depth == 2) {
			TreeNode left = new TreeNode(val);
			TreeNode right = new TreeNode(val);
			left.left = root.left;
			right.right = root.right;
			root.left = left;
			root.right = right;
			return root;
		}
		/* Recursive calls on subsequent left and right subtrees. */
		if (root.left != null) root.left = addOneRow(root.left, val, depth - 1);
		if (root.right != null) root.right = addOneRow(root.right, val, depth - 1);
		/* return the original root now that the tree has been modified. */
		return root;
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
