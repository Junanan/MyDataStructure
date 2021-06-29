package 回溯法;
// 一类题https://leetcode-cn.com/problems/longest-univalue-path/solution/yi-pian-wen-zhang-jie-jue-suo-you-er-cha-94j7/
public class L129求根节点到叶节点数字之和 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        StringBuilder stringBuilder ;
        int res;
        public int sumNumbers(TreeNode root) {
            if(root == null) {
                return 0;
            }
            stringBuilder = new StringBuilder();
            res = 0;
            backTracking(root);
            return res;
        }
        private void backTracking(TreeNode root){
            if(root == null) return ;
            stringBuilder.append(String.valueOf(root.val));
            if(root.left == null && root.right == null) {
                int a = Integer.parseInt(stringBuilder.toString());
                res += a;
            }
            backTracking(root.left);

            backTracking(root.right);

            stringBuilder.deleteCharAt(stringBuilder.length()-1);


        }

    }
}
