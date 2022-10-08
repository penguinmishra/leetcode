package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		BinaryTreeInorderTraversal o = new BinaryTreeInorderTraversal();
		TreeNode root = o.new TreeNode(1);
		root.right = o.new TreeNode(2);
		root.right.left = o.new TreeNode(3);
		List<Integer> result = o.inorderTraversal(root);
		System.out.println(result);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		inOrder(root, result);
		return result;
	}

	private void inOrder(TreeNode root, List<Integer> result) {
		if (root == null) return;
		inOrder(root.left, result);
		result.add(root.val);
		inOrder(root.right, result);
	}

	/* Definition for a binary tree node. */
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
