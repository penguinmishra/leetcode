package com.code.leetcode;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
	public static void main(String[] args) {
		
		char[][] sudoku = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		
		ValidSudoku o = new ValidSudoku();
		System.out.println(o.isValidSudoku(sudoku));
	}

	public boolean isValidSudoku(char[][] board) {
		return isValidSudoku(board, 0, 0 , board.length);
	}
	
	private boolean isValidSudoku(char[][] board, int i, int j, int n) {
		if(i == n) return true;
		if(j == n) return isValidSudoku(board, i + 1, 0, n);
		if(board[i][j] == '.') return isValidSudoku(board, i, j + 1, n);
		
		if(!isPlaceable(board, i, j, board[i][j], n)) return false;
		return isValidSudoku(board, i, j + 1, n);
	}

	private boolean isPlaceable(char[][] board, int i, int j, char no, int n) {
		for(int k = 0; k < j; k++) if(board[i][k] == no) return false;
		
		for(int k = j + 1; k < n; k++) if(board[i][k] == no) return false;
		
		for(int k = 0; k < i; k++) if(board[k][j] == no) return false;
		
		for(int k = i + 1; k < n; k++) if(board[k][j] == no) return false;
		
		System.out.println(i + " "+ j);
		int sx = (i / 3) * 3;
		int sy = (j / 3) * 3;
		
		for(int x = sx; x < sx + 3; x++)
			for(int y = sy; y < sy + 3; y++)
				if(x != i && y != j && board[x][y] == no) return false;
		
		return true;
	}
}
