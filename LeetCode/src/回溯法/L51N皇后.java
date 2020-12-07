package 回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//上图为 8 皇后问题的一种解法。
//
//给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
//每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//示例:
//
//输入: 4
//输出: [	
// [".Q..",  // 解法 1
//  "...Q",	
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
public class L51N皇后 {
	List<List<String>> res;
	public List<List<String>> solveNQueens(int n) {
		res = new ArrayList<>();
		char[][] board = new char[n][n];
		for(char[]a : board) Arrays.fill(a, '.'); 
		backtracking(0,board);
		return res;
    }
	private void backtracking(int row, char[][] board) {
		if(board.length==row) {
			res.add(charToString(board));
			return;
		}
		int n = board[row].length;
		for(int cow=0;cow<n;cow++) {
			if(!isvalid(board,row,cow)) continue;
			board[row][cow] = 'Q';
			backtracking(row+1, board);
			board[row][cow] = '.';
		}
	}
	 private boolean isvalid(char[][] board, int row, int cow) {
		int n = board.length;
		//检查正上方列是否有皇后冲突    
		for(int i=row;i>=0;i--) {
			if(board[i][cow]=='Q') return false;
		}
		//检查右上方是否有皇后冲突
		for(int i = row-1,j= cow+1;i>=0&&j<n;i--,j++) {
			if(board[i][j]=='Q') return false;
		}
		//检查左上方是否有皇后冲突
		for(int i = row-1,j= cow-1;i>=0&&j>=0;i--,j--) {
			if(board[i][j]=='Q') return false;
		}
		return true;
	}
	private static List<String> charToString(char[][] array) {
	        List<String> result = new LinkedList<>();
	        for (char[] chars : array) {
	            result.add(String.valueOf(chars));
	        }
	        return result;
	    }

}
