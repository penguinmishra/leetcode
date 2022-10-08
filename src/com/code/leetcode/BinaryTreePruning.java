package com.code.leetcode;

/**
 * https://leetcode.com/problems/binary-tree-pruning/
 */
public class BinaryTreePruning {
	public static void main(String[] args) {
		BinaryTreePruning obj = new BinaryTreePruning();
		TreeNode root = obj.new TreeNode(1);

		root.left = obj.new TreeNode(0);
		root.left.left = obj.new TreeNode(0);
		root.left.right = obj.new TreeNode(0);
		root.right = obj.new TreeNode(1);
		root.right.right = obj.new TreeNode(1);
		root.right.left = obj.new TreeNode(0);

		System.out.println(pruneTree1(root));
		System.out.println();
	}

	public static TreeNode pruneTree1(TreeNode root) {
		if (root == null) return null;
		root.left = pruneTree1(root.left);
		root.right = pruneTree1(root.right);
		if (root.left == null && root.right == null && root.val == 0) return null;
		return root;
	}

	public class TreeNode {
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
