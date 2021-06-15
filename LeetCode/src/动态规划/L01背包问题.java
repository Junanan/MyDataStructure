package 动态规划;

public class L01背包问题 {
	public static void main(String[] args) {
		int[] wt = {  2, 1, 3 };
		int[] val = { 4, 2, 3 };
		System.out.println(kProblem(3, 4, wt, val));

	}

	public static int kProblem(int n, int w, int[] wt, int[] val) {
//		dp[i][w]表示：对于前i个物品，当前背包的容量为w时，这种情况下可以装下的最大价值是dp[i][w]。
		int[][] dp = new int[n + 1][w + 1];
		// 初始化 重量与价格为0 无意义
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= w; i++) {
			dp[0][i] = 0;
		}
		dp[0][0] = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (j - wt[i-1] < 0) {// 超重 只能选择不装
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i-1]] + val[i-1]);
// 完全背包：	dp[i][j] = Math.max(dp[i - 1][j], dp[i] [j - wt[i-1]] + val[i-1]);
//两者区别在于物品能不能重复使用
				}
			}
		}
		return dp[n][w];
	}
	//完全背包 L322零钱
}