package com.code.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
	public static void main(String[] args) {
		MaximumLengthOfAConcatenatedStringWithUniqueCharacters o = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
		System.out.println(o.maxLength(List.of("cha","r","act","ers")));
	}

	public int maxLength(List<String> arr) {
		Map<String, Integer> mem = new HashMap<>();
		return maxLength(arr, 0, "", mem);
	}

	private int maxLength(List<String> arr, int start, String str, Map<String, Integer> mem) {

		if (!hasUniqueCharacters(str)) return 0;
		int max = str.length();
		
		if (start == arr.size()) return max;
		
		if(mem.get(str) != null) return mem.get(str);

		for (int i = start; i < arr.size(); i++) {
			max = Math.max(max, maxLength(arr, i + 1, str + arr.get(i), mem));
		}
		return max;
	}

	private boolean hasUniqueCharacters(String s) {
		Set<Character> set = new HashSet<>();
		for (char a : s.toCharArray()) {
			if (set.contains(a))
				return false;
			set.add(a);
		}
		return true;
	}
}
