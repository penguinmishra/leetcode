package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {
		BinaryTreePostorderTraversal obj = new BinaryTreePostorderTraversal();
		TreeNode root = obj.new TreeNode(1);
		root.right = obj.new TreeNode(2);
		root.left = obj.new TreeNode(3);
		System.out.println(postorderTraversal(root));
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		postOrderTraversal(root, result);
		return result;
	}

	private static void postOrderTraversal(TreeNode node, List<Integer> result) {
		if (node == null) return;
		if (node.left != null) postOrderTraversal(node.left, result);
		if (node.right != null) postOrderTraversal(node.right, result);
		result.add(node.val);
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
