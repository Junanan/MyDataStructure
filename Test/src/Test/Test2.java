package Test;

import javax.sound.midi.spi.SoundbankReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Test2 {
    public static class ListNode {
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
//        root.left = root2;
//        root.right = root3;
//        root2.left = root4;
//        root2.right = root5;
//        root3.left = root6;
//        root3.right = root7;
        root3.left = root;
        root3.right = root4;
        root.right = root2;
        ListNode head = new ListNode(1);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        ListNode next5 = new ListNode(5);
        ListNode next6 = new ListNode(6);
        ListNode next7 = new ListNode(7);
        ListNode next8 = new ListNode(8);
        head.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
        next5.next = next6;
        next6.next = next7;
        next7.next = next8;
        Test2 test2 = new Test2();
        System.out.println();
        StringBuilder resString = new StringBuilder();
        String str = new String("zxc");
        test2.change(str);
        System.out.println(str);
        String a = "111";
        a = "222";
        System.out.println(a);
    }


    public void change(String str) {
        str = "asv";
    }


    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return (x == -1 || x == 1) ? 1 : 0;
        }
        if (n == 0) {
            return 1;
        }
        boolean flag = true;
        if (n < 0) {
            n = -n;
            flag = false;
        }
        double res = 0;
        if ((n & 1) != 1) {
            res = myPow(x * x, n / 2);
        } else {
            res = x * myPow(x * x, (n - 1) / 2);
        }
        return flag ? res : 1 / res;
    }

}







