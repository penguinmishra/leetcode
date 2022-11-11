package com.code.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray o = new RemoveDuplicatesFromSortedArray();
		System.out.println(o.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
	}

	public int removeDuplicates(int[] nums) {
		int i = 0, j = 1;
		while (j < nums.length) {
			if (nums[i] == nums[j]) {
				j++;
			} else {
				i += 1;
				nums[i] = nums[j];
				j++;
			}
		}
		return i + 1;
	}
}
