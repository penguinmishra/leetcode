package com.code.leetcode;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {
	public static void main(String[] args) {
		String s = "";
		String t = "c";
		System.out.println(isSubsequence(s, t));
		System.out.println(isSubsequenceBottomUp(s, t));
	}

	public static boolean isSubsequence(String s, String t) {
		int m = s.length();
		int n = t.length();
		boolean[][] mem = new boolean[m + 1][n + 1];
		return isSubsequence(s, t, m, n, mem);
	}

	private static boolean isSubsequence(String s, String t, int m, int n, boolean[][] mem) {
		if (m != 0 && n <= 0) return false;
		else if (m <= 0) return true;
		if (mem[m][n]) return mem[m][n];
		boolean isSubs = false;
		if (s.charAt(m - 1) == t.charAt(n - 1)) isSubs = isSubsequence(s, t, m - 1, n - 1, mem);
		else isSubs = isSubsequence(s, t, m, n - 1, mem);
		mem[m][n] = isSubs;
		return isSubs;
	}

	public static boolean isSubsequenceBottomUp(String s, String t) {
		int m = s.length();
		int n = t.length();
		boolean[][] mem = new boolean[m + 1][n + 1];
		for (int i = 0; i < n + 1; i++)
			mem[0][i] = true;
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					mem[i][j] = mem[i - 1][j - 1];
				} else {
					mem[i][j] = mem[i][j - 1];
				}
			}
		}
		return mem[m][n];
	}
}
