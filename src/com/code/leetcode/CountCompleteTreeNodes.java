package com.code.leetcode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodes {
	public static void main(String[] args) {
		CountCompleteTreeNodes o = new CountCompleteTreeNodes();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		System.out.println(o.countNodes(root));
	}

	/**
	 * Idea: A COMPLETE BINARY TREE can be created in two ways:<br/>
	 * <br/>
	 * 1. Left and right subtrees have same heights That means that the right
	 * subtree may or may not have the rightmost node to it. In this case, the left
	 * subtree's every node would have 2 children each. See
	 * <a href= "https://shorturl.at/jtY38">this complete binary tree</a><br/>
	 * <br/>
	 * 2. Left subtree may have one more level that the right subtree may not have.
	 * But in that case, right subtree's every node would have 2 children each. See
	 * <a href="https://shorturl.at/LVYZ7">this complete binary tree</a> <br/>
	 * </br>
	 * 
	 * To implement the first point, we can calculate heights of root's left and
	 * right subtrees's left subtrees respectively. If both of them are equal, then
	 * we can be sure that each node in left subtree has 2 children. But the same
	 * cannot be said for the right subtree so we invoke the same method on right
	 * subtree again to get its # of nodes.<br/>
	 * <br/>
	 * For the second point, the height of root's left would be greater than root's
	 * right. But we can be sure that the root's right subtree nodes have 2 children
	 * each. To get the # of nodes from root's left subtree, we can invoke the same
	 * method again.
	 * 
	 * @param root node
	 * @return # of nodes in a COMPLETE BINARY TREE.
	 */
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		
		int leftLeftheight = height(root.left);
		int rightLeftheight = height(root.right);
		
		if (leftLeftheight == rightLeftheight) {
			return (1 << leftLeftheight) + countNodes(root.right);
		} else if (leftLeftheight > rightLeftheight) {
			return (1 << rightLeftheight) + countNodes(root.left);
		}
		return -1; // for a complete binary tree, we will never reach here.
	}

	private int height(TreeNode node) {
		if (node == null) return 0;
		return 1 + height(node.left);
	}
	
	/**
	 * this solution works for all the binary trees. It traverses all the nodes in
	 * worst case condition. Not recommended for complete binary tree
	 */
	public int countNodes2(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

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