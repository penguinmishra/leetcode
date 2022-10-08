package com.code.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/decode-ways/
 */

public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays o = new DecodeWays();
		System.out.println(o.numDecodings("06"));
	}

	public int numDecodings(String s) {
		int n = s.length();
		int[] mem = new int[n];
		Arrays.fill(mem, -1);
		return numDecodings(s, 0, mem);
	}

	private int numDecodings(String s, int i, int[] mem) {
		int n = s.length();
		if (i == n) return 1;
		if (s.charAt(i) == '0') return 0;
		if (mem[i] != -1) return mem[i];
		int count = numDecodings(s, i + 1, mem);
		if (i < n - 1 && ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0')) < 27) {
			count += numDecodings(s, i + 2, mem);
		}
		return mem[i] = count;
	}
}
