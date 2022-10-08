package com.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum o = new CombinationSum();
		int[] candidates = { 2, 3, 5 };
		int target = 8;
		System.out.println(o.combinationSum(candidates, target));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		combinationSum(candidates, target, in, result, 0);
		return result;
	}

	private static void combinationSum(int[] candidates, int target, List<Integer> in, List<List<Integer>> result,
			int start) {
		if (target == 0) {
			result.add(new ArrayList<>(in));
			return;
		}
		if (target < 0) return;	//you may encounter some list of 2,4,5 for a target of 8. target would become -ve. Should not consider that.
		for (int i = start; i < candidates.length; i++) { // starting from start because we should not go back to
															// earlier elements in array
			in.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], in, result, i);
			in.remove(in.size() - 1); // backtrack because list is pass by reference between method calls and removal
										// needs to be handled manually.
		}
	}
}
/**
 * Reason on why we start from i = start: If you take candidates = [2,3,5] and
 * target = 8, and you start from i = 0, in each iteration you are going back to
 * 0th element. You get [[2, 2, 2, 2], [2, 3, 3], [3, 2, 3], [3, 3, 2], [3, 5],
 * [5, 3]] as response. Note that when you consider 3 at 0th place, you are
 * going back to 2 and adding that to your answer. Instead you should not start
 * from 0 but from the index where you are currently on. So, if you are
 * considering 3, you are going back to 0th element (2) and constructing your
 * answer. Instead you should move forward and not start from 0. Start from the
 * index you are considering at in.add(candidates[i])
 */
