package 动态规划;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//问总共有多少条不同的路径？
public class L62 {
	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[n][m];
		for(int i =1 ;i<m;i++) {
			dp[0][i] =1;
		}
		for(int i =1 ;i<n;i++) {
			dp[i][0] =1;
		}
		for(int i =1;i<n;i++) {
			for(int j =1;j<m;j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		return dp[n-1][m-1];
    }
	public static void main(String[] args) {
		System.out.println(uniquePaths(7,3));
	}
	
}
