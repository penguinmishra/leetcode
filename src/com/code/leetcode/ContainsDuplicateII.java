package com.code.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {
public static void main(String[] args) {
	ContainsDuplicateII o = new ContainsDuplicateII();
	int[] nums = {1,2,3,1};
	System.out.println(o.containsNearbyDuplicate(nums, 2));
}

public boolean containsNearbyDuplicate(int[] nums, int k) {
	Set<Integer> set = new HashSet<>();
	for (int i = 0; i < nums.length; i++) {
		if (i > k) set.remove(nums[i - k - 1]);
		boolean present = !set.add(nums[i]);
		if (present) return true;
	}
	return false;
}

public boolean containsNearbyDuplicate2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
        if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) return true;
        map.put(nums[i], i);
    }
    return false;
}
}
