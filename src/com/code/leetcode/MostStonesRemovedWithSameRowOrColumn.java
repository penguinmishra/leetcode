package com.code.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class MostStonesRemovedWithSameRowOrColumn {
	public static void main(String[] args) {
		MostStonesRemovedWithSameRowOrColumn o = new MostStonesRemovedWithSameRowOrColumn();
		int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
		System.out.println(o.removeStones(stones));
	}

	/**
	 * returns <code>stones.length - i</code> because if there are 6 connected
	 * nodes, <code>i</code> would be 1 (# of islands = 1). In this case, the answer
	 * should be 5 because question does not remove all 6 nodes - only 1 is left
	 * out. So, we need to do <code>length -
	 * i</code> (length - # of islands) to achieve the answer.
	 */
	public int removeStones(int[][] stones) {
		Set<int[]> visited = new HashSet<>();
		int i = 0;
		for (int[] stone : stones) {
			if (!visited.contains(stone)) {
				dfs(stone, visited, stones);
				i += 1;
			}
		}
		return stones.length - i;
	}

	private void dfs(int[] stone, Set<int[]> visited, int[][] stones) {
		visited.add(stone);
		for (int[] nextStone : stones) {
			if (!visited.contains(nextStone) && (nextStone[0] == stone[0] || nextStone[1] == stone[1])) {
				dfs(nextStone, visited, stones);
			}
		}
	}
}
