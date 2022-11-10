package com.code.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveAllAdjacentDuplicatesInString {
	public static void main(String[] args) {
		RemoveAllAdjacentDuplicatesInString o = new RemoveAllAdjacentDuplicatesInString();
		String s = "azxxzy";
		System.out.println(o.removeDuplicates(s));
	}

	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.add(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}
}
