package 动态规划;

import java.util.Arrays;

//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
//示例:
//
//输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
public class L300最长上升子序列 {
//	定义状态：由于一个子序列一定会以一个数结尾，于是将状态定义成：dp[i] 表示 以 nums[i] 结尾 的「上升子序列」的长度。注意：这个定义中 nums[i] 必须被选取，且必须是这个子序列的最后一个元素；
//	考虑状态转移方程：
//	遍历到 nums[i] 时，需要把下标 i 之前的所有的数都看一遍；
//	只要 nums[i] 严格大于在它位置之前的某个数，那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列；
//	因此，dp[i] 就等于下标 i 之前严格小于 nums[i] 的状态值的最大者 +1+1。
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int res = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				//
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				res = Math.max(res, dp[i]);
			}
		}
		return res;
	}


}
