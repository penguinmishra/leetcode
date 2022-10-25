package com.code.leetcode;
/**
 * https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {
public static void main(String[] args) {
	SetMismatch o = new SetMismatch();
	int[] nums = {1,2,2,4};
	int[] res = o.findErrorNums(nums);
	for(int i : res)
		System.out.print(i + " ");
}

public int[] findErrorNums(int[] nums) {
    int[] res=new int[2];
	for (int i = 0; i < nums.length;) {
		int value = nums[i];
		if (value != nums[value - 1]) {
			int temp = nums[i];
			nums[i] = nums[value - 1];
			nums[value - 1] = temp;
		} else {
			i++;
		}
	}
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] != i + 1) {
            res[0] = nums[i];
            res[1] = i + 1;
            break;
		}
	}
    return res;
}
}
