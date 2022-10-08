package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParantheses {
	public static void main(String[] args) {
		System.out.println(generateParanthesis(3));
	}

	private static List<String> generateParanthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParanthesis(n, 0, 0, 0, "", result);
		return result;
	}

	private static void generateParanthesis(int n, int open, int close, int index, String output, List<String> result) {
		if (index == 2 * n) {
			result.add(output);
		}

		if (open < n) {
			generateParanthesis(n, open + 1, close, index + 1, output + "(", result);
		}

		if (close < open) {
			generateParanthesis(n, open, close + 1, index + 1, output + ")", result);
		}
	}
}
