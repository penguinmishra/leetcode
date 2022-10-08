package com.code.leetcode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 5, 7, 7, 8, 8, 10 };
		int[] result = searchRange(arr, 8);
		System.out.println(result[0] + " " + result[1]);
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		if (nums == null || nums.length == 0 || nums[0] > target) return result;
		int start = search(nums, target);
		int end = start;
		if (start == -1) {
			result[0] = start;
			result[1] = end;
			return result;
		}

		while (start > 0 && nums[start - 1] == target) start--;

		while (end < nums.length - 1 && nums[end + 1] == target) end++;

		result[0] = start;
		result[1] = end;
		return result;
	}

	private static int search(int[] arr, int search) {
		int start = 0;
		int end = arr.length;
		while (start < end) {
			int mid = (start + end) / 2;
			if (arr[mid] == search) return mid;
			else if (arr[mid] < search) start = mid + 1;
			else end = mid;
		}
		return -1;
	}

}
