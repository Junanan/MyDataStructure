package Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
//		   Pattern pattern = Pattern.compile("\\d?");
//		   Matcher matcher = pattern.matcher("lkl123jkjl?");
////		   System.out.println(matcher.group());
//		   System.out.println(matcher.matches());
//		   System.out.println(matcher.pattern());
//		   System.out.println(uniqueOccurrences(new int[] {1,2,2,3,1,1}));
        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(8);
        TreeNode root4 = new TreeNode(11);
        TreeNode root5 = new TreeNode(13);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(2);
        TreeNode root9 = new TreeNode(1);
        root.left = root2;
        root2.left = root4;
        root4.left = root7;
        root4.right = root8;
        root.right = root3;
        root3.left = root5;
        root3.right = root6;
        root6.right = root9;
        Test test = new Test();
//		test.reconstructQueue(new int[1][2]);
//		Test.hasPathSum(root,2);
        int[] res = new int[]{2, 3, 1, 1, 4};
        int[][] a2 = new int[2][1];
//        Arrays.sort(a2, (a, b) -> b[0] - a[0]);
//        System.out.println(test.canJump(new int[]{2, 3, 1, 1, 4}));
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        HashSet set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[len - 1];
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                }
                maxLen = Math.max(dp[i][j], maxLen);
            }
        }
        return maxLen * maxLen;
    }

    public int findDuplicate(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                res = nums[i];
            }
        }
        return res;
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur != null) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        Node pre = cur;
        while (pre != null) {
            pre.next = map.get(pre).next;
            pre.random = map.get(pre).random;
            pre = pre.next;
        }
        return cur;
    }
}
