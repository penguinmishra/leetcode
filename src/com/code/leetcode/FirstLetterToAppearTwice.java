package com.code.leetcode;

public class FirstLetterToAppearTwice {
	public static void main(String[] args) {
		FirstLetterToAppearTwice o = new FirstLetterToAppearTwice();
		System.out.println(o.repeatedCharacter("ab"));
	}

	public char repeatedCharacter(String s) {
		int[] arr = new int[26];
		for (char a : s.toCharArray()) {
			int v = arr[a - 'a'];
			if (v + 1 == 2) return a;
			arr[a - 'a']++;
		}
		/*
		 * code will never reach here because s will contain at least one letter that
		 * appears twice.
		 */
		return '\n';
	}
}
