package com.code.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
	public static void main(String[] args) {
		ThreeSumClosest o = new ThreeSumClosest();
		int[] nums = {-1,2,1,-4};
		System.out.println(o.threeSumClosest(nums, 1));
	}

	public int threeSumClosest(int[] nums, int target) {
		/*
		 * sort the array because we if a running sum falling short, we can move to the
		 * next larger element in array.
		 */
		Arrays.sort(nums);
		/*
		 * initialise your result with first three elements. In case we have just 3
		 * elements, this will become our result
		 */
		int result = nums[0] + nums[1] + nums[2];
		
		/* Start iteration from 0 -> last index */
		
		for(int i = 0; i< nums.length; i++) {
			/* First pointer left. Point to the i + 1 */
			int l = i + 1;
			/* Second pointer. Point to the last element in array */
			int r = nums.length - 1;
			
			while(l < r) {
				/* calculate our running sum. csum = current sum */
				int csum = nums[i] + nums[l] + nums[r];
				/* If our csum is closer to target, update the result with our running sum. */
				if(Math.abs(csum - target) < Math.abs(result - target)) {
					result = csum;
				}
				
				/*
				 * if our running sum is greater than target sum, we need to make it smaller.
				 * Chuck the last element. Move right pointer to a smaller element
				 */
				if(csum > target) r--;
				/*
				 * if our running sum is less than target sum, we need to make it larger. Kick
				 * out the left element. Move left pointer to a larger element
				 */
				else if(csum < target) l++;
				/*
				 * This line will make your code faster. There is no sum closer to the target
				 * than target itself. If you have found the csum == target, return csum..or
				 * target whatever
				 */
				else return csum; // you can return target also since target == csum
			}
		}
		return result;
	}
}
