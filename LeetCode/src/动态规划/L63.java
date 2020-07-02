package 动态规划;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//网格中的障碍物和空位置分别用 1 和 0 来表示。
public class L63 {
	 public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 int m = obstacleGrid.length;
		 int n = obstacleGrid[0].length;
		 int[][] dp = new int[m][n];
		 //初始化边界
		 if(obstacleGrid[0][0]==0) dp[0][0] =1;
		 for(int i =1 ; i<m;i++) {
			 if(obstacleGrid[i][0]==0) dp[i][0]=dp[i-1][0];
		 }
		 for(int j =1 ; j<n;j++) {
			 if(obstacleGrid[0][j]==0) dp[0][j]=dp[0][j-1];
		 }
		 //状态转移
		 for(int i = 1;i<m;i++) {
			 for(int j =1;j<n;j++) {
				 if(obstacleGrid[i][j]==0) dp[i][j] = dp[i-1][j]+dp[i][j-1];
			 }
		 }
		 return dp[m-1][n-1];
	 }
	public static void main(String[] args) {
		int[][] a = new int[][] {
		                          {0,0,0},
		                          {0,1,0},
		                          {0,0,0}};  
		System.out.println(uniquePathsWithObstacles(a));
	}


}
