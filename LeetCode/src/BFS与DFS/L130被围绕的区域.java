package BFS��DFS;
//����һ����ά�ľ��󣬰���?'X'?��?'O'����ĸ O����
//
//�ҵ����б� 'X' Χ�Ƶ����򣬲�����Щ���������е�?'O' �� 'X' ��䡣
//
//ʾ��:
//
//X X X X
//X O O X
//X X O X
//X O X X
//������ĺ����󣬾����Ϊ��
//
//X X X X
//X X X X
//X X X X
//X O X X

public class L130��Χ�Ƶ����� {
	 public void solve(char[][] board) {
		 if(board==null) return;
		 for(int i=0;i<board.length;i++) {
			 for(int j=0;j<board[0].length;j++) {
				 boolean edge = i==0||i==board.length-1||j==0||j==board[0].length-1;  //������Χ
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
