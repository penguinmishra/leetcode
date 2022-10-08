package com.code.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree {
	public static void main(String[] args) {
		AverageOfLevelsInBinaryTree obj = new AverageOfLevelsInBinaryTree();
		TreeNode root = obj.new TreeNode(2147483647);
		root.left = obj.new TreeNode(2147483647);
		// root.left.right = obj.new TreeNode(25);
		root.right = obj.new TreeNode(2147483647);
		// root.right.left = obj.new TreeNode(15);
		// root.right.right = obj.new TreeNode(7);
		// root.right.right.right = obj.new TreeNode(21);

		System.out.println(averageOfLevels(root));
		System.out.println(averageOfLevels2(root));
	}

	public static List<Double> averageOfLevels2(TreeNode root) {
		List<Double> result = new ArrayList<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			double sum = 0.0;
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			result.add(sum / n);
		}
		return result;
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		int level = levels(root);
		List<Double> result = new ArrayList<>();
		for (int i = 1; i <= level; i++) {
			List<Integer> valuesAsList = getLevelValuesAsList(root, i);
			double sum = 0;
			for (int v : valuesAsList)
				sum += v;
			result.add(sum / valuesAsList.size());
		}
		return result;
	}

	private static List<Integer> getLevelValuesAsList(TreeNode root, int level) {
		if (root == null)
			return new ArrayList<>();
		if (level == 1) {
			List<Integer> l = new ArrayList<>();
			l.add(root.val);
			return l;
		}
		List<Integer> left = getLevelValuesAsList(root.left, level - 1);
		List<Integer> right = getLevelValuesAsList(root.right, level - 1);
		left.addAll(right);
		return left;
	}

	private static int levels(TreeNode root) {
		if (root == null)
			return 0;
		int left = levels(root.left);
		int right = levels(root.right);
		return left > right ? left + 1 : right + 1;
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
