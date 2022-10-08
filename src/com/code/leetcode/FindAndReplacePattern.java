package com.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern {
	public static void main(String[] args) {
		String pattern = "abb";
		String[] words = { "cee", "abc", "deq", "mee", "aqq", "dkd", "ccc" };
		System.out.println(findAndReplacePattern(words, pattern));
		System.out.println(findAndReplacePattern2(words, pattern));
	}

	private static List<String> findAndReplacePattern(String[] words, String pattern) {
		int n = pattern.length();
		List<String> result = new ArrayList<>();
		for (String word : words) {
			int[] p = new int[26];
			int[] w = new int[26];
			boolean samePattern = true;
			for (int i = 0; i < n; i++) {
				int pc = pattern.charAt(i) - 'a';
				int wc = word.charAt(i) - 'a';
				if (p[pc] != w[wc]) {
					samePattern = false;
					break;
				} else {
					p[pc] = w[wc] = i + 1;
				}
			}
			if (samePattern)
				result.add(word);
		}
		return result;
	}

	private static List<String> findAndReplacePattern2(String[] words, String pattern) {
		int[] patternFrequencyArr = getFrequencyArr(pattern);
		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (word.length() == pattern.length()) {
				int[] wordFrequencyArr = getFrequencyArr(word);
				if (Arrays.equals(wordFrequencyArr, patternFrequencyArr)) {
					result.add(word);
				}
			}
		}
		return result;
	}

	private static int[] getFrequencyArr(String word) {
		HashMap<Character, Integer> map = new HashMap<>();
		int l = word.length();
		int[] res = new int[l];
		for (int i = 0; i < l; i++) {
			map.putIfAbsent(word.charAt(i), map.size());
			res[i] = map.get(word.charAt(i));
		}
		return res;
	}
}
