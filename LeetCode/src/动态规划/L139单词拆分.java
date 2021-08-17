package 动态规划;

import java.util.HashSet;
import java.util.List;

public class L139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        HashSet set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) { //遍历背包
            for (int j = 0; j < i; j++) { //遍历物品
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
