package com.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
	public static void main(String[] args) {
		ThreeSum o = new ThreeSum();
		int[] nums = { -2, 0, 1, 1, 2 };
		System.out.println(o.threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int l = i + 1, r = nums.length - 1;

			while (l < r) {
				int csum = nums[i] + nums[l] + nums[r];
				if (csum < 0) l++;
				else if (csum > 0) r--;
				else {
					set.add(List.of(nums[i], nums[l], nums[r]));
					l++;
					r--;
				}
			}
		}
		return new ArrayList<>(set);
	}
}
