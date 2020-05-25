package 剑指offer;

public class Ten {
//	请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
//每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
//
//	[["a","b","c","e"],
//	["s","f","c","s"],
//	["a","d","e","e"]]
//
//	但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
//
//	 
//
//	示例 1：
//
//	输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//	输出：true
	public boolean exist(char[][] board, String word) {
		char[] words = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, words, i, j, 0))
					return true;
			}
		}
		return false;
	}

	boolean dfs(char[][] board, char[] word, int i, int j, int k) {
		if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
			return false;
		if (k == word.length - 1)
			return true;
		char tmp = board[i][j];
		board[i][j] = '/';
		boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1)
				    || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
		board[i][j] = tmp;
		return res;
	}
	// 深度优先算法 DFS  回溯法
		//思路：① 首先他是一个矩阵 所以肯定要有两个指针两个for做遍历  一个方法做遍历 一个方法做递归
		//     ② dfs 是一个递归 所以在递归的方法里要有结束的语句 也就是回溯语句（剪枝）
		//     ③用‘/’ 赋给当前值 相当于加了个易遍历的标志 递归后记得重新赋回去
		//     ④当K等于自身的长度 也就是完全相等了 
}
