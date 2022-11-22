package com.code.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {
	public static void main(String[] args) {
		PerfectSquares o = new PerfectSquares();
		int n = 10;
		System.out.println(o.numSquares(n));
	}
	
	public int numSquares(int n) {
		int[] mem = new int[n + 1];
		Arrays.fill(mem, -1);
		return numSquares(n, mem);
	}

	public int numSquares(int n, int[] mem) {
		if(n == 0) return 0;
		if(mem[n] != -1) return mem[n];
		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= Math.sqrt(n); i++) {
			result = Math.min(result, 1 + numSquares(n - i * i, mem));
		}
		return mem[n] = result;
	}
}
