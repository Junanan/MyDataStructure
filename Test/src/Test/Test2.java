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
//        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
//        List<Integer> list = new LinkedList<>();
//        list.add(2);
//        list.add(1);
//        list.add(3);
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        System.out.println(list.toString());
//        Arrays.sort(nums, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
        int[][] a = new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}};
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        System.out.println(map.containsKey(2));
        numEquivDominoPairs(a);
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        for (int i = 0; i < dominoes.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(dominoes[i][0], 0);
            map.put(dominoes[i][1], 1);
            for (int j = i + 1; j < dominoes.length; j++) {
                if (map.containsKey(dominoes[j][0]) && map.containsKey(dominoes[j][1])) {
                    System.out.println("j:"+j+"map"+map.containsKey(dominoes[j][0])+"ssss"+dominoes[j][0]);
                    res ++;
                }
            }
        }
        return res;
    }
}
