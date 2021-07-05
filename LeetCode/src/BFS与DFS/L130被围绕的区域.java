package BFS与DFS;
//给定一个二维的矩阵，包含?'X'?和?'O'（字母 O）。
//
//找到所有被 'X' 围绕的区域，并将这些区域里所有的?'O' 用 'X' 填充。
//
//示例:
//
//X X X X
//X O O X
//X X O X
//X O X X
//运行你的函数后，矩阵变为：
//
//X X X X
//X X X X
//X X X X
//X O X X

public class L130被围绕的区域 {
	 public void solve(char[][] board) {
		 if(board==null) return;
		 for(int i=0;i<board.length;i++) {
			 for(int j=0;j<board[0].length;j++) {
				 boolean edge = i==0||i==board.length-1||j==0||j==board[0].length-1;  //遍历周围
				 if(edge&&board[i][j] == 'O') {
					 dfs(board,i,j);
				 }
			 }
		 }
		 for(int i=0;i<board.length;i++) {
			 for(int j=0;j<board[0].length;j++) {
				 if(board[i][j]=='O') {
					 board[i][j] = 'X';
				 }
				 if(board[i][j]=='#') {
					 board[i][j] = 'O';
				 }
			 }
		 }
}

	private void dfs(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X'||board[i][j]=='#')
			return ;
		board[i][j] = '#';
		 dfs(board, i + 1, j);
		 dfs(board, i, j + 1);
		 dfs(board, i - 1, j);
		 dfs(board, i, j -1);
	}
}
