package 动态规划;
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。
//
//示例:
//
//输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
public class L64 {
	public int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length; 
		for(int i = 1;i<row;i++) {
			grid[i][0]+=grid[i-1][0];
		}
		for(int j = 1;j<row;j++) {
			grid[0][j]+=grid[0][j-1];
		}
		for(int i =1 ;i<row;i++) {
			for(int j=1;j<col;j++) {
				grid[i][j] +=Math.min(grid[i][j-1], grid[i-1][j]);
			}
		}
		return grid[row-1][col-1];
    }
}
