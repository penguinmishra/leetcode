package com.code.leetcode;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
	public static void main(String[] args) {
		ValidAnagram o = new ValidAnagram();
		System.out.println(o.isAnagram("aabca", "acaba"));
	}

	/**
	 * Idea: Keep +1 and -1 in an array on every iteration for characters in both
	 * the strings. In the end if all the values are zero, that means both the
	 * strings even out each other characters and so are anagram. If any of the
	 * number in array is non zero, the strings are not anagram.
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;	// If both strings are of different lengths, they can never be an anagram.
		int[] arr = new int[256];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)] += 1;
			arr[t.charAt(i)] -= 1;
		}

		for (int x : arr) {
			if (x != 0) return false; // if there is one non-zero number in array, return false.
		}
		return true;
	}
}
