package 动态规划;

public class Rodcutting {
	// 自底向上
	public static int bottomup(int n, int[] princes) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				dp[i] = Math.max(dp[i], Math.max(princes[j] + princes[i - j], princes[j] + dp[i - j]));
		}
		return dp[n];
	}

	// 自顶向下 暴力递归
	public static int brutalforce(int n, int[] princes) {
		if (n == 0)
			return 0;
		int res = -1;
		for (int i = 1; i <= n; i++) {
			res = Math.max(res, princes[i] + brutalforce(n - i, princes));
		}
		return res;
	}

	// 带备忘录的递归
	public static int memorizedCutRod(int n, int[] princes) {
		int[] dp = new int[n + 1];
		for (int i = 0; i <=n; i++) {
			dp[i] = -1;
		}
		return memorized(n, princes, dp);
	}

	private static int memorized(int n, int[] princes, int[] dp) {
		if (dp[n] != -1)
			return dp[n];
		int q = -1;
		if (n == 0)
			q = 0;
		else {
			for (int i = 1; i <=n; i++) {
				q = Math.max(q, princes[i] + memorized(n - i, princes, dp));
			}
			dp[n] = q;
		}
		return q;
	}

	public static void main(String[] args) {
		int[] profit = new int[] { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		for (int i = 1; i <= 10; i++) {
			System.out.println(memorizedCutRod(i, profit));
		}
	}
}
