package com.code.leetcode;

/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */
public class CheckIfTwoStringArraysAreEquivalent {
	public static void main(String[] args) {
		CheckIfTwoStringArraysAreEquivalent o = new CheckIfTwoStringArraysAreEquivalent();
		String[] word1 = { "ab", "c" };
		String[] word2 = { "a" };
		System.out.println(o.arrayStringsAreEqual(word1, word2));
	}

	public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
		return String.join("", word1).equals(String.join("", word2));
	}

	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		int i = 0, j = 0;
		for (int ii = 0, jj = 0; i < word1.length && j < word2.length;) { // ii & jj point to each char in word1 & word2 element words
			if (word1[i].charAt(ii) != word2[j].charAt(jj)) return false;
			ii++; jj++;
			if (ii == word1[i].length()) { // if ii reached the end of the element word, move i to point to next element in array and set ii to zero
				i++;
				ii = 0;
			}
			if (jj == word2[j].length()) { // if jj reached the end of the element word, move j to point to next element in array and set jj to zero
				j++;
				jj = 0;
			}
		}
		return i == word1.length && j == word2.length; // don't return default true. It fails for this scenario for example: word1 = ["ab", "c"] and word2 = ["a"]
	}
}
