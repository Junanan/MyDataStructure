package Test;

import java.util.*;

public class Test2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int listSize = 0;
        while (cur != null) {
            listSize++;
            cur = cur.next;
        }
        k = k % listSize;
        if (k == 0) return head;
        int count = listSize - k - 1;
        cur = head;
        while (count != 0) {
            cur = cur.next;
            count--;
        }
        ListNode curHead = cur.next;
        cur.next = null;
        ListNode cur2 = curHead;
        while (cur2.next != null) {
            cur2 = cur2.next;
        }
        cur2.next = head;
        return curHead;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        Test2 test2 = new Test2();
        List list = new LinkedList<>();
        list.size();
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                root = root.left;
                stack.push(root);
            }
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) {
                root = temp.right;
                stack.push(root);
            }
        }
        return res;
    }

    public int pivotIndex(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = len - 1; j > i; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum) return -1;
        }
        return -1;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
        }
        Collections.reverse(res);
        return res;
    }

    public String decodeString(String s) {
        Stack<String> stack_string = new Stack<>();
        Stack<Integer> stack_num = new Stack<>();
        StringBuilder res = new StringBuilder();
        char[] charArr = s.toCharArray();
        int num = 0;
        for (char c : charArr) {
            if (c == '[') {
                stack_num.add(num);
                stack_string.add(res.toString());
                res = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int temp = stack_num.pop();
                StringBuilder tempString = new StringBuilder();
                while (temp > 0) {
                    tempString.append(res);
                    temp--;
                }
                res = new StringBuilder(stack_string.pop() + tempString);
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + Integer.parseInt("" + c);//*10 是因为可能有两位的数字
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
    public int countSubstrings(String s) {
        int len = s.length();
        if (len < 2) return 1;
        char[] arrString = s.toCharArray();
        boolean[][] dp =new boolean[len][len];
        int res = 0;
        for(int j = 1; j < len; j++){
            for (int i = 0; i <= j; i++){
                if(arrString[i] == arrString[j]) {
                    if (j - i <3 ) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] ) {
                    res ++;
                }

            }
        }
        return res;
    }
}

