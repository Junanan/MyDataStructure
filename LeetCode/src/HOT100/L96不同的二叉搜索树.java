package HOT100;

//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
//示例:
//
//输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
public class L96不同的二叉搜索树 {
	// 选定一个数为根节点 看次节点的左右的节点有多少种二叉搜索树 相乘即可
	/// 递归超时
	public int numTrees(int n) {
		if (n == 1 || n == 0)
			return 1;
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans += numTrees(i - 1) * numTrees(n - i);
		}
		return ans;
	}

	// 超时后考虑带备忘录的递归
	public int numTrees2(int n) {
		int[] result = new int[n + 1];
		return helper(result, n);
	}

	private int helper(int[] result, int n) {
		if (n == 0 || n == 1)
			return 1;
		if (result[n] > 0)
			return result[n];
		for (int i = 1; i <= n; i++) {
			result[n] += helper(result, i - 1) * helper(result, n - i);
		}
		return result[n];
	}

	public int numTrees3(int n) {
		int[] dp = new int[n + 1];
		return recus(n, dp);
	}

	private int recus(int n, int[] dp) {
		if (n == 0 || n == 1)
			return 1;
		if (dp[n] > 0)
			return dp[n];
		for (int i = 1; i <= n; i++) {
			dp[i] += recus(i - 1, dp) * recus(n - i, dp);
		}
		return dp[n];
	}
}
