package com.code.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/online-stock-span/description/
 *
 */
public class StockSpanner {
	Stack<int[]> stack;

	public StockSpanner() {
		stack = new Stack<>();
	}

	public int next(int price) {
		int v = 1;
		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			int[] arr = stack.pop();
			v += arr[1];
		}
		stack.push(new int[] { price, v });
		return v;
	}
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
 */