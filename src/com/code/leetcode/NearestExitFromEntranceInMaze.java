package com.code.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 */
public class NearestExitFromEntranceInMaze {
	
	public static void main(String[] args) {
		char[][] maze = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
		int[] entrance = {1, 0};
		NearestExitFromEntranceInMaze o = new NearestExitFromEntranceInMaze();
		System.out.println(o.nearestExit(maze, entrance));
	}
	
	public int nearestExit(char[][] maze, int[] entrance) {
		int rows = maze.length;
		int columns = maze[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		int ans = 0;
		queue.offer(entrance);
		
		while(!queue.isEmpty()) {
			ans++;
			int size = queue.size();
			while(size-- > 0) {
				// poll + mark visited
				int[] current = queue.poll();
				int x = current[0];
				int y = current[1];
				maze[x][y] = '+';
				for(int[] dir : directions) {
					int newX = x + dir[0];
					int newY = y + dir[1];
					if(newX < 0 || newY < 0 || newX > rows - 1 || newY > columns - 1 || maze[newX][newY] == '+') continue;
					if(newX == 0 || newY == 0 || newX == rows - 1 || newY == columns - 1) return ans;
					// offer + mark visited
					queue.offer(new int[] {newX, newY});
					maze[newX][newY] = '+';
				}
				
			}
		}
		return -1;
	}
}
