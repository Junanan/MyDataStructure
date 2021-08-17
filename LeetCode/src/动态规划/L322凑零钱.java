package 动态规划;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
//
// 
//
//示例 1:
//
//输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1
//示例 2:
//
//输入: coins = [2], amount = 3
//输出: -1
public class L322凑零钱 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp[i][j] 表示前 i 种硬币凑成总数为 j 时所需的最少硬币数
        int dp[][] = new int[n + 1][amount + 1];
        // 初始状态：前 0 种硬币凑成总数 > 0 时不可能凑成，初始化为amount+1
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }
        //唯一的「状态」就是目标金额 amount
        //循环的顺序调换无影响
        for (int i = 1; i <= n; i++) {//遍历coin的面值
            for (int j = 1; j <= amount; j++) {  //遍历总数
                // 能凑就选择凑还是不凑
                if (j - coins[i - 1] < 0) dp[i][j] = dp[i - 1][j];
                    // 不能凑就只好不凑
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[n][amount] == amount + 1 ? -1 : dp[n][amount];
    }

}
