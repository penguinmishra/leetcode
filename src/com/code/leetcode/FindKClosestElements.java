package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 */

public class FindKClosestElements {
	public static void main(String[] args) {
		FindKClosestElements o = new FindKClosestElements();
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(o.findClosestElements(arr, 4, -1));
	}

	/**
	 * Idea is to have two pointers l & r and check if lth element has smaller diff
	 * or rth element. If lth element has lesser diff, we need to take lth index
	 * element and reject rth. move 1 to left if you rejected rth element. Move 1 to
	 * right if you rejected lth element.
	 */
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int l = 0, r = arr.length - 1;
		while (r - l >= k) {
			if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) r--;
			else l++;
		}
		List<Integer> result = new ArrayList<>();
		for (int i = l; i <= r; i++, l++) result.add(arr[l]);
		return result;
	}
}
