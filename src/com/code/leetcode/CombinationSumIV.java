package com.code.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSumIV {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int target = 4;
		System.out.println(combinationSum4(nums, target));
	}

	public static int combinationSum4(int[] nums, int target) {
		int[] t = new int[target + 1];
		Arrays.fill(t, -1);
		return combinationSumRec(nums, target, t);
	}

	public static int combinationSumRec(int[] nums, int target, int[] t) {
		if (target == 0) return 1;
		if (target < 0) return 0;
		if (t[target] != -1) return t[target];

		int combinations = 0;
		for (int i = 0; i < nums.length; i++) combinations += combinationSumRec(nums, target - nums[i], t);
		return t[target] = combinations;
	}
}