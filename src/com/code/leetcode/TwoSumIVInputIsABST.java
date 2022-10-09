package com.code.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIVInputIsABST {
	public static void main(String[] args) {
		TwoSumIVInputIsABST o = new TwoSumIVInputIsABST();
		TreeNode root = o.new TreeNode(5);
		root.left = o.new TreeNode(3);
		root.left.left = o.new TreeNode(2);
		root.left.right = o.new TreeNode(4);
		root.right = o.new TreeNode(6);
		root.right.right = o.new TreeNode(7);
		System.out.println(o.findTarget(root, 6));
	}

	public boolean findTarget(TreeNode root, int k) {
		return f(root, k, new HashSet<>());
	}
	
	private boolean f(TreeNode node, int k, Set<Integer> vals) {
		if(node == null) return false;
		if(vals.contains(k - node.val)) return true;
		vals.add(node.val);
		return f(node.left, k, vals) || f(node.right, k, vals);
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
