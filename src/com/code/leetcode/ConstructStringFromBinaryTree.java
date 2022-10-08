package com.code.leetcode;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class ConstructStringFromBinaryTree {

	public static void main(String[] args) {
		ConstructStringFromBinaryTree o = new ConstructStringFromBinaryTree();
		TreeNode root = o.new TreeNode(1);
		root.left = o.new TreeNode(2);
		root.right = o.new TreeNode(3);
		root.left.left = o.new TreeNode(4);
		System.out.println(tree2str(root));
	}

	public static String tree2str(TreeNode root) {
		if (root == null) return "";
		String result = root.val + "";
		String left = tree2str(root.left);
		String right = tree2str(root.right);
		if (left == "" && right == "") return result;
		if (left == "") return result + "()(" + (right) + ")";
		if (right == "") return result + "(" + left + ")";
		return result + "(" + left + ")" + "(" + right + ")";
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
