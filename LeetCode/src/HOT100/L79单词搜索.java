package HOT100;

import java.util.Arrays;

//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
// 
//
//示例:
//
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
public class L79单词搜索 {
	public static boolean exist(char[][] board, String word) {
		int sum = 0;
		int m = board[0].length;
		int n = board.length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(backtrack(board, word, sum,i,j)) return true;
			}
		}
		return false;
	}
	/// 考虑清楚这个函数的作用
	private static boolean backtrack(char[][] board, String word, int sum, int i, int j) {
		if(i<0||i>=board.length||j<0||j>=board[0].length||word.charAt(sum)!=board[i][j]) return false;
		if(sum==word.length()-1) return true;
			char temp = board[i][j];
			board[i][j] = '0';
			if(backtrack(board,word,sum+1,i+1,j)||
			backtrack(board,word,sum+1,i-1,j)||
			backtrack(board,word,sum+1,i,j-1)||
			backtrack(board,word,sum+1,i,j+1)) return true;
			board[i][j] = temp;
		return false;
	}
	public static void main(String[] args) {
		char[][] b = new char[][] {
			{'A','B','C','E'},
		    {'S','F','C','S'},
		    {'A','D','E','E'}
		   };
	exist(b,"ABCCED") ;                     
	}
}
