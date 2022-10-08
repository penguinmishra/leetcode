package com.code.leetcode;

/**
 * https://leetcode.com/problems/counting-bits/
 */

public class CountBits {
	public static void main(String[] args) {
		int[] result = countBits2(5);
		for (int x : result) System.out.print(x + " ");
	}

	public static int[] countBits(int n) {
		int[] result = new int[n + 1];
		int[] t = new int[n + 1];
		for (int i = 0; i <= n; i++) result[i] = countBit(i, t);
		return result;
	}

	/* Recursive Solution */
	private static int countBit(int n, int[] t) {
		if (n == 0 || n == 1) return n;
		if (t[n] != 0) return t[n];
		int count = 0;
		if (n % 2 == 0) count = countBit(n / 2, t);
		else count = countBit(n / 2, t) + 1;
		t[n] = count;
		return count;
	}

	/* Top Down Solution */
	public static int[] countBits2(int n) {
		int[] t = new int[n + 1];
		t[0] = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) t[i] = t[i / 2];
			else t[i] = t[i / 2] + 1;
		}
		return t;
	}
}
