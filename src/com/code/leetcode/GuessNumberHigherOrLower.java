package com.code.leetcode;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class GuessNumberHigherOrLower {
	public int guessNumber(int n) {
		int start = 1; // because n can start from 1
		while (start <= n) {
			int middle = start + (n - start) / 2;
			int a = guess(middle);
			if (a < 0) n = middle - 1;
			else if (a > 0) start = middle + 1;
			else return middle;
		}
		return -1; // did not find the number. Will never reach here as per the problem
	}

	/**
	 * Dummy guess method. The method would be implicitly provided by the problem
	 * 
	 * @param n
	 * @return
	 */
	private int guess(int n) {
		return -1;
	}
}
