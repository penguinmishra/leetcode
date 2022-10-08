package com.code.leetcode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
	static ValidateBinarySearchTree a = new ValidateBinarySearchTree();
	private TreeNode prev;

	public static void main(String[] args) {
		TreeNode root = a.new TreeNode(5);
		root.left = a.new TreeNode(1);
		root.right = a.new TreeNode(4);
		root.right.left = a.new TreeNode(3);
		root.right.right = a.new TreeNode(6);
		System.out.println(a.isValidBST(root));
	}

	public boolean isValidBST(TreeNode root) {
		/* if the root is null - return true. */
		if (root != null) {
			/* keep going to the left recursively. */
			if (!isValidBST(root.left)) {
				/* If you find one node which doesn't follow BST, return false. */
				return false;
			}

			/*
			 * Now start coming up and check if the previous node value (if not a leaf node)
			 * had value less than the current node. If not so, then return false. Because
			 * while coming up, you are one level up and the previous node you were on
			 * should have value less than you are on.
			 */
			if (prev != null && root.val <= prev.val) {
				return false;
			}
			/*
			 * assign the previous node to the prev variable. Keeping track of the
			 * previously visited node!
			 */
			prev = root;
			/*
			 * make a recursive call on right subtree which would check if the right subtree
			 * is a BST. Note that if we hit this line, then we can be sure that the left
			 * subtree IS a BST and now we just have to do the same for right subtree.
			 */
			if (!isValidBST(root.right)) {
				return false;
			}
		}
		return true;
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
