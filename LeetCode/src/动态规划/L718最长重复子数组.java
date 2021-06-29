package 动态规划;

public class L718最长重复子数组 {
    //最值问题->动态规划
    // 想象出矩阵
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        if(nums1[0] == nums2[0]) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]){
                dp[i][0] = 1;
            }else {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i < nums2.length; i++) {
            if (nums1[0] == nums2[i]){
                dp[0][i] = 1;
            }else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
