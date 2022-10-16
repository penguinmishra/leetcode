package com.code.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 */
public class MinimumDifficultyOfAJobSchedule {
	public static void main(String[] args) {
		MinimumDifficultyOfAJobSchedule o = new MinimumDifficultyOfAJobSchedule();
		int[] jobDifficulty = {1,2,3,4,5,6};
		int d = 2;
		System.out.println(o.minDifficulty(jobDifficulty, d));
	}

	public int minDifficulty(int[] jobDifficulty, int d) {
		if (d > jobDifficulty.length) return -1;
		if (d == jobDifficulty.length) return Arrays.stream(jobDifficulty).sum();
		int[][] mem = new int[jobDifficulty.length + 1][d + 1];
		for(int[] arr : mem) Arrays.fill(arr, -1);
		return md(jobDifficulty, 0, d, mem);
	}

	private int md(int[] jd, int start, int d, int[][] mem) {
		if(d == 1) {
			int max = 0;
			while(start < jd.length) max = Math.max(max, jd[start++]);
			return max;
		}
		if(mem[start][d] != -1) return mem[start][d];
		int max  = 0;
		int r = Integer.MAX_VALUE;
		for (int i = start; i <= jd.length - d; i++) {
			max = Math.max(max, jd[i]);
			r = Math.min(r, max + md(jd, i + 1, d - 1, mem));
		}
		return mem[start][d] = r;
	}
}
