package com.code.leetcode;

/**
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
public class CheckIfTheSentenceIsPangram {
	public static void main(String[] args) {
		CheckIfTheSentenceIsPangram o = new CheckIfTheSentenceIsPangram();
		String sentence = "leetcode";
		System.out.println(o.checkIfPangram(sentence));
	}

	public boolean checkIfPangram(String sentence) {
		boolean[] arr = new boolean[26];
		for (char a : sentence.toCharArray()) arr[a - 'a'] = true;

		for (boolean b : arr) {
			if (!b) return false;
		}
		return true;
	}
}
