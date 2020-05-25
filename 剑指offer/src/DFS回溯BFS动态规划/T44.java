package DFS回溯BFS动态规划;
//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）
//。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
//给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
//示例 1:
//输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
public class T44 {
	 public static int maxValue(int[][] grid) {
		 int row = grid.length;
		 int col = grid[0].length;
		 for(int i =0 ;i<row;i++) {
			 for(int j=0;j<col;j++) {
				 if(i==0&&j==0) continue;
				 else if(i==0&&j!=0) {
					 grid[i][j]+=grid[i][j-1];
				 }else if(i!=0&&j==0) {
					 grid[i][j]+=grid[i-1][j];
				 }else {
					 grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
				 }
				 
			 }
		 }
		 return grid[row-1][col-1];
	 }
	 //动态规划  若要grid[row-1][col-1] 最大 则其上边和左边就要最大  进而分治
	 public static int maxValuee(int[][] grid) {
		 int res=0;
		 int i = grid.length-1;
		 int j = grid[0].length-1;
		 return dfs(grid,i,j,0,0);
	    }
	private static int  dfs(int[][] grid, int r, int l,int i,int j) {
		if(i>r||j>l) return 0;
		return grid[i][j]+Math.max(dfs(grid,r,l,i+1,j),dfs(grid,r,l,i,j+1));
	}
	//递归超时 会有大量重复  类似二叉树的高度题目 
	
	public static void main(String[] args) {
		int[][] s = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(maxValue(s));
	}

}
