package 动态规划;

public class L518零钱兑换II {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        //将第一列全部初始化为 11，当背包容量为 00 时，无论是多少枚硬币凑成 00 元都只有一种方法，就是一个也不选
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
