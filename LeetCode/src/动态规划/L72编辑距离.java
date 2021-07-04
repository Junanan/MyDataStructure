package ��̬�滮;

public class L72�༭���� {
    // �� 718 1143 һ�� ת���ɾ���

//     (1) dp[i-1][j-1]�����Ƚ� word1 ��ǰ 4 ���ַ� hors ת��Ϊ word2 ��ǰ 2 ���ַ� ro��Ȼ�󽫵�����ַ� word1[4]����Ϊ�±������ 0 ��ʼ�� �� e �滻Ϊ s�����滻Ϊ word2 �ĵ������ַ���word2[2]��

// (2) dp[i][j-1]�����Ƚ� word1 ��ǰ 5 ���ַ� horse ת��Ϊ word2 ��ǰ 2 ���ַ� ro��Ȼ����ĩβ����һ�� s�����������

    // (3) dp[i-1][j]�����Ƚ� word1 ��ǰ 4 ���ַ� hors ת��Ϊ word2 ��ǰ 3 ���ַ� ros��Ȼ��ɾ�� word1 �ĵ� 5 ���ַ�
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i ;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                //  ���ڵ�ǰ�����ַ���ͬ,����������κβ���,dp[i][j]=dp[i-1][j-1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    //     ֻ�ǵ�ǰλ�õ��ַ���ƥ��,�����滻���������߱����ͬ,
                    //    ���Դ�ʱdp[i][j]=dp[i-1][j-1]+1(�����1����ִ���滻����)
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j],dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
