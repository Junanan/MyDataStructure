package 动态规划;
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
// 
//
//示例 1:
//
//输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//示例 2:
//
//输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//示例 3:
//
//输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
public class L122 {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len < 2)
			return 0;
		 // 0：持有现金
        // 1：持有股票
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
		int[][] dp = new int[len][2];
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		for (int i = 1; i < len; i++) {
			 // 这两行调换顺序也是可以的
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]-prices[i]);
		}
		return dp[len - 1][0];
    }
//	想到动态规划的原因是：可以用贪心算法解决的问题，一般情况下都可以用动态规划。因此，不妨从 “状态”、“状态转移方程” 的角度考虑一下，使用动态规划的思路解决这道问题。
//
//	根据 「力扣」第 121 题的思路，需要设置一个二维矩阵表示状态。
//
//	第 1 步：定义状态
//	状态 dp[i][j] 定义如下
//
//	第一维 i 表示索引为 i 的那一天（具有前缀性质，即考虑了之前天数的收益）能获得的最大利润；
//	第二维 j 表示索引为 i 的那一天是持有股票，还是持有现金。这里 0 表示持有现金（cash），1 表示持有股票（stock）。
//	第 2 步：思考状态转移方程
//	状态从持有现金（cash）开始，到最后一天我们关心的状态依然是持有现金（cash）；
//	每一天状态可以转移，也可以不动。状态转移用下图表示：
//
//
//	（状态转移方程写在代码中）
//
//	说明：
//
//	因为不限制交易次数，除了最后一天，每一天的状态可能不变化，也可能转移；
//	写代码的时候，可以不用对最后一天单独处理，输出最后一天，状态为 0 的时候的值即可。
//	第 3 步：确定起始
//	起始的时候：
//
//	如果什么都不做，dp[0][0] = 0；
//	如果买入股票，当前收益是负数，即 dp[0][1] = -prices[i]；
//	第 4 步：确定终止
//	终止的时候，上面也分析了，输出 dp[len - 1][0]，因为一定有 dp[len - 1][0] > dp[len - 1][1]。
	
	//第 5 步：考虑状态压缩
	 public int maxProfittt(int[] prices) {
	        int len = prices.length;
	        if (len < 2) {
	            return 0;
	        }

	        // cash：持有现金
	        // hold：持有股票
	        // 状态数组
	        // 状态转移：cash → hold → cash → hold → cash → hold → cash
	        int[] cash = new int[len];
	        int[] hold = new int[len];

	        cash[0] = 0;
	        hold[0] = -prices[0];

	        for (int i = 1; i < len; i++) {
	            // 这两行调换顺序也是可以的
	            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
	            hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
	        }
	        return cash[len - 1];
	    }
	 public int maxProfitt(int[] prices) {
	        int len = prices.length;
	        if (len < 2) {
	            return 0;
	        }

	        // cash：持有现金
	        // hold：持有股票
	        // 状态转移：cash → hold → cash → hold → cash → hold → cash

	        int cash = 0;
	        int hold = -prices[0];

	        int preCash = cash;
	        int preHold = hold;
	        for (int i = 1; i < len; i++) {
	            cash = Math.max(preCash, preHold + prices[i]);
	            hold = Math.max(preHold, preCash - prices[i]);

	            preCash = cash;
	            preHold = hold;
	        }
	        return cash;
	    }
	 // 贪心
//	 “贪心算法” 和 “动态规划”、“回溯搜索” 算法一样，完成一件事情，是分步决策的；
//	 “贪心算法” 在每一步总是做出在当前看来最好的选择，我是这样理解 “最好” 这两个字的意思：
//	 “最好” 的意思往往根据题目而来，可能是 “最小”，也可能是 “最大”；
//
//	 贪心算法和动态规划相比，它既不看前面（也就是说它不需要从前面的状态转移过来），也不看后面（无后效性，后面的选择不会对前面的选择有影响），因此贪心算法时间复杂度一般是线性的，空间复杂度是常数级别的。
//
//	 这道题 “贪心” 的地方在于，对于 “今天的股价 - 昨天的股价”，得到的结果有 3 种可能：（1）正数（2）0（3）负数。
//
//	 贪心算法的决策是：只加正数。
	  public int maxProfi(int[] prices) {
		   int res = 0;
	        int len = prices.length;
	        for (int i = 0; i < len - 1; i++) {
	            int diff = prices[i + 1] - prices[i];
	            if (diff > 0) {
	                res += diff;
	            }
	        }
	        return res;
	    }
}
