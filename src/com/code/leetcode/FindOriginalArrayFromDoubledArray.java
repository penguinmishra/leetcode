package com.code.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-original-array-from-doubled-array/
 *
 */
public class FindOriginalArrayFromDoubledArray {
	public static void main(String[] args) {
		int[] changed = { 1, 3, 4, 2, 6, 8 };
		changed = findOriginalArray(changed);
		for (int x : changed)
			System.out.print(x + " ");
	}

	public static int[] findOriginalArray(int[] changed) {
		if (changed.length % 2 == 1)
			return new int[0];
		Arrays.sort(changed);
		int[] result = new int[changed.length / 2];
		int i = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int n : changed) {
			if (!queue.isEmpty() && n == queue.peek()) {
				queue.poll();
			} else {
				if (i == result.length)
					return new int[0];
				queue.offer(n * 2);
				result[i++] = n;
			}
		}
		return queue.isEmpty() ? result : new int[0];
	}
}
