package 动态规划;

//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
//注意:
//
//每个数组中的元素不会超过 100
//数组的大小不会超过 200
//示例 1:
//
//输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
//示例 2:
//
//输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
public class L416分割等和子集 {
	public boolean canPartition(int[] nums) {
		int len = nums.length;
		int sum = 0;
		for (int a : nums) {
			sum += a;
		}
		if ((sum & 1) == 1)
			return false;
		int target = sum / 2;
//		状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j。
		// 创建二维状态数组，行：物品索引，列：容量（包括 0）
//		target + 1多出来的那 1 列，表示背包容量从 0 开始考虑。很多时候，我们需要考虑这个容量为 0 的数值。
		boolean[][] dp = new boolean[len][target + 1];

		if (nums[0] <= target) {
			dp[0][nums[0]] = true;
		}
		for (int i = 1; i < len; i++) {
			for (int j = 0; j <= target; j++) {
				// 直接从上一行先把结果抄下来，然后再修正
				dp[i][j] = dp[i - 1][j];
				if (nums[i] == j) {
					return true;
				}
				if (j - nums[i] > 0) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
				}
			}
		}
		return dp[len - 1][target];
	}
}
