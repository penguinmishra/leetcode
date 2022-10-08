package com.code.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInAString {
	public static void main(String[] args) {
		FirstUniqueCharacterInAString o = new FirstUniqueCharacterInAString();
		System.out.println(o.firstUniqChar("leetcode"));
	}

	public int firstUniqChar(String s) {
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		for (int i = 0; i < s.length(); i++) {
			int v = s.charAt(i) - 'a';
			/*
			 * if it's -1, assign a positive value to it because this char is occurring for
			 * the very first time.
			 */
			if (arr[v] == -1) arr[v] = i;
			/*
			 * if it's already +ve number, that means it has already occurred by the above
			 * logic. Now assign a -ve number to it. you can write any -ver number here.
			 */
			else if (arr[v] >= 0) arr[v] = -2;
		}
		int result = -1;
		/* choose the lowest +ve value from arr */
		for (int i = 0; i < 26; i++) {
			if (arr[i] >= 0) {
				result = result == -1 ? arr[i] : (arr[i] < result ? arr[i] : result);
			}
		}
		return result;
	}
}
