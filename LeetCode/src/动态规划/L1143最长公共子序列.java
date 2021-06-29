package 动态规划;

public class L1143最长公共子序列 {
    //最值问题->动态规划
    // 想象出矩阵
    public int longestCommonSubsequence(String text1, String text2) {
        char[] strArr1 = text1.toCharArray();
        char[] strArr2 = text2.toCharArray();
        int[][] dp = new int[strArr1.length][strArr2.length];
        if(strArr1[0] == strArr2[0]) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < strArr1.length; i++) {
            if (strArr1[i] == strArr2[0]){
                dp[i][0] = 1;
            }else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < strArr2.length; i++) {
            if (strArr1[0] == strArr2[i]){
                dp[0][i] = 1;
            }else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < strArr1.length; i++) {
            for (int j = 1; j < strArr2.length; j++) {
                if (strArr1[i] == strArr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
        }
        return dp[strArr1.length - 1][strArr2.length - 1];
    }
}
