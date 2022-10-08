package com.code.leetcode;

/**
 * https://leetcode.com/problems/climbing-stairs
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		ClimbingStairs o = new ClimbingStairs();
		System.out.println(o.climbStairs(44));
	}

	public int climbStairs(int n) {
		int[] mem = new int[n + 1];
		return climbStairs(n, mem);
	}

	private int climbStairs(int n, int[] mem) {
		if (n == 1 || n == 2 || n == 3) return mem[n] = n;
		if (mem[n] != 0) return mem[n];
		return mem[n] = climbStairs(n - 1, mem) + climbStairs(n - 2, mem);
	}
}