package ��̬�滮;

public class L518��Ǯ�һ�II {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        //����һ��ȫ����ʼ��Ϊ 11������������Ϊ 00 ʱ�������Ƕ���öӲ�Ҵճ� 00 Ԫ��ֻ��һ�ַ���������һ��Ҳ��ѡ
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
