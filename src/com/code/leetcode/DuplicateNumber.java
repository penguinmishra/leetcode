package com.code.leetcode;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class DuplicateNumber {
	public static void main(String[] args) {
		DuplicateNumber o = new DuplicateNumber();
		int[] arr = { 1, 3, 4, 2, 2 };
		System.out.println(o.findDuplicate(arr));
	}

	public int findDuplicate(int[] nums) {
		return findDuplicate(nums, nums.length);
	}

	private int findDuplicate(int[] nums, int n) {
		// here nums = [1, 3, 4, 2, 2]
		for (int i = 0; i < n;) {
			int value = nums[i];
			if (value != nums[value - 1]) {
				// swap arr[i] with arr[value-1]
				int temp = nums[i];
				nums[i] = nums[value - 1];
				nums[value - 1] = temp;
			} else {
				i++;
			}
		}
		// here nums becomes = [1, 2, 3, 4, 2]
		int val = -1;
		for (int i = 0; i < n; i++) {
			if (nums[i] != i) {
				val = nums[i];
			}
		}
		return val;
	}
}
