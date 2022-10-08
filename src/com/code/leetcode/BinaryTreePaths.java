package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
	public static void main(String[] args) {
		BinaryTreePaths o = new BinaryTreePaths();
		TreeNode root = o.new TreeNode(1);
		root.left = o.new TreeNode(2);
		root.right = o.new TreeNode(3);
		root.left.right = o.new TreeNode(5);

		System.out.println(binaryTreePaths(root));
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		binaryTreePaths(root, result, "");
		return result;
	}

	private static void binaryTreePaths(TreeNode root, List<String> result, String path) {
		if (root == null) return;
		path += root.val;
		if (root.left == null && root.right == null) result.add(path);
		binaryTreePaths(root.left, result, path + "->");
		binaryTreePaths(root.right, result, path + "->");
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