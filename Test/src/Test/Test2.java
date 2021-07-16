package Test;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Pattern;

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
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        ListNode head = new ListNode(1);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        ListNode next5 = new ListNode(5);
//        ListNode next6 = new ListNode(6);
        ListNode next7 = new ListNode(7);
        ListNode next8 = new ListNode(8);
        head.next = next2;
        next2.next = next3;
        next3.next = next4;
        next4.next = next5;
//        next5.next = next6;
//        next6.next = next7;
        next7.next = next8;
        Test2 test2 = new Test2();
    }

    class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue1.offer(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (queue2.isEmpty()) {
                while (!queue1.isEmpty()) {
                    queue2.offer(queue1.poll());
                }
            }
            if (queue2.isEmpty()) {
                return -1;
            }
            return queue2.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (queue2.isEmpty()) {
                while (!queue1.isEmpty()) {
                    queue2.offer(queue1.poll());
                }
            }
            if (queue2.isEmpty()) {
                return -1;
            }
            return queue2.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            if (queue2.isEmpty()) {
                while (!queue1.isEmpty()) {
                    queue2.offer(queue1.poll());
                }
            }
            return queue2.isEmpty();
        }
    }
}




