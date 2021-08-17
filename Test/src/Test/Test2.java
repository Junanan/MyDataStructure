package Test;

import com.sun.javafx.image.IntPixelGetter;

import javax.sound.midi.spi.SoundbankReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        StringBuilder resString = new StringBuilder();
        String str = new String("zxc");
        test2.change(str);
        String a = "123";
        a = "222";
//        test2.print(new int[]{1,2,3,4,5,6});
        System.out.println(2 ^ 8);
    }


    public void change(String str) {
        str = "asv";
    }

    // 多线程交替打印数组
    public void print(int[] nums) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                for (int num : nums) {
                    if ((num & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + num);
                    }
                    condition2.signal();//叫醒其他线程，这里就是t2
                    condition1.await();//让自己阻塞，让出锁
                }
                condition2.signal();//必须要有，因为两个线程的try里面的最后一步是阻塞，如果线程执行完了还在阻塞肯定不对，必须要唤醒，才能正确结束程序
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A").start();
        new Thread(() -> {
            lock.lock();
            try {
                for (int num : nums) {
                    if ((num & 1) != 1) {
                        System.out.println(Thread.currentThread().getName() + num);
                    }
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

//    public String decodeString(String s) {
//        Stack<Integer> stack_num = new Stack<>();
//        Stack<String> stack_str = new Stack<>();
//        int num = 0;
//        String str = "";
//        StringBuilder res = new StringBuilder();
//        StringBuilder temp = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (s.charAt(i) == '[') {
//                stack_num.add(num);
//                num = 0;
//                stack_str.add(temp.toString());
//                temp = new StringBuilder();
//
//            }else if (s.charAt(i) ==']') {
//                for (int j = 0; j < stack_num.pop(); j++) {
//
//                }
//            }else if ('a' < s.charAt(i) && s.charAt(i) < 'z') {
//                temp.append(c);
//            }else {
//                num = num * 10 + Integer.parseInt(c);
//            }
//        }
//    }
}








