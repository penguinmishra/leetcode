package com.code.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/make-the-string-great/
 */
public class MakeTheStringGreat {
	public static void main(String[] args) {
		MakeTheStringGreat o = new MakeTheStringGreat();
		String s = "leEeetcode";
		System.out.println(o.makeGood(s));
	}

	public String makeGood(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) stack.pop();
			else stack.push(c);
		}

		StringBuilder sb = new StringBuilder();
		for (char c : stack) sb.append(c);
		return sb.toString();
	}
}
