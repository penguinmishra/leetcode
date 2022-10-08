package com.code.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
		int i = 0, j = height.length - 1, max = 0;
		while (i < j) {
			int h = height[i] <= height[j] ? height[i] : height[j];
			int cap = h * (j - i);
			max = max >= cap  ? max : cap;
			if (height[j] < height[i]) j--;
			else i++;
		}
		return max;
	}
}
