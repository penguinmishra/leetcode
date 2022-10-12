package com.code.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle/submissions/
 */
public class LargestPerimeterTriangle {
	public static void main(String[] args) {
		LargestPerimeterTriangle o = new LargestPerimeterTriangle();
		int[] nums = { 1, 2, 1 };
		System.out.println(o.largestPerimeter(nums));
	}

	public int largestPerimeter(int[] nums) {
		if (nums.length < 3) return 0;
		Arrays.sort(nums);
		for (int i = nums.length - 3; i >= 0; i--)
			if (nums[i] + nums[i + 1] > nums[i + 2])
				return nums[i] + nums[i + 1] + nums[i + 2];
		return 0;
	}
}
