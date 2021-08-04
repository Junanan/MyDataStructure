package ���ݷ�;
// һ����https://leetcode-cn.com/problems/longest-univalue-path/solution/yi-pian-wen-zhang-jie-jue-suo-you-er-cha-94j7/
public class L129����ڵ㵽Ҷ�ڵ�����֮�� {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        int res = 0;
        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;
            StringBuilder sb = new StringBuilder();
            backing(root,sb);
            return res;
        }

        private void backing(TreeNode root, StringBuilder sb) {
            if (root == null) return ;
            sb.append(String.valueOf(root.val));
            if (root.left == null && root.right == null) {
                res += Integer.valueOf(sb.toString());
            }
            backing(root.left,sb);
            backing(root.right,sb);
            //StringBuilder �����ô��� ֻҪ�ڵݹ���Ҷ�ӽڵ���ݾ�����
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
