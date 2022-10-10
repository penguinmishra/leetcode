package com.code.leetcode;

/**
 * https://leetcode.com/problems/break-a-palindrome/
 */
public class BreakAPalindrome {
	public static void main(String[] args) {
		BreakAPalindrome o = new BreakAPalindrome();
		String p = "aba";
		System.out.println(o.breakPalindrome(p));
		System.out.println(o.breakPalindrome2(p));
	}

	public String breakPalindrome(String palindrome) {
		return bp(palindrome.toCharArray(), 0, palindrome.length());
	}

	private String bp(char[] cs, int i, int n) {
		if (n == 1) return "";
		if (cs[i] != 'a' && i != n / 2) {
			cs[i] = 'a'; // if you hit the non-a character before middle index, change that and return
			return String.valueOf(cs);
		}
		if (i == n / 2) {
			cs[n - 1] = 'b'; // if you hit the middle index, change the last character and return
			return String.valueOf(cs);
		}
		return bp(cs, i + 1, n); // otherwise, increasing index by one and call recursively
	}

	public String breakPalindrome2(String palindrome) {
		int n = palindrome.length();
		if (n == 1)
			return "";
		char[] c = palindrome.toCharArray();
		for (int i = 0; i < n; i++) {
			if (c[i] != 'a' && i != n / 2) {
				c[i] = 'a'; // if you hit the non-a character before middle index, change that and return
				break;
			} else if (i == n / 2) {
				c[n - 1] = 'b';// if you hit the middle index, change the last character and return
				break;
			}
		}
		return String.valueOf(c);
	}

}
