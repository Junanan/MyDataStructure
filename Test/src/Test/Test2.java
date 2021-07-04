package Test;

import java.util.*;

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
        test2.minWindow("a","a");
    }

    private void te(String a) {
        a = "a";
    }

    private void te2(StringBuilder a) {
//        a.append('2');
        a = new StringBuilder('2');
    }

    private void te3(int a) {
        a = 100;
    }

    //    public int search(int[] nums, int target) {
//        int start = nums[0];
//        int i = 0;
//        int j = nums.length - 1;
//        while (i < j) {
//            int mid = i + (j - i) / 2;
//            if (target >= start) {
//
//            }
//        }
//    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1 - k, j = 0; j < nums.length; i++, j++) {
            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.pollLast();
            }
            queue.add(nums[j]);
            if (i > 0 && nums[i - 1] == queue.peek()) {
                queue.poll();
            }
            if (i >= 0) {
                res[i] = queue.peek();
            }
        }
        return res;
    }

    public int[] findMedianSortedArrays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int left = j;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                i = mid + 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = j;
        if (left < 0) {
            left = -1;
        }
        if (right >= nums.length) {
            right = -1;
        }
        return new int[]{left, right};
    }

    public int compareVersion(String version1, String version2) {
        String[] strArr1 = version1.split("\\.");
        String[] strArr2 = version2.split("\\.");
        int charValue1 = 0;
        int charValue2 = 0;
        int m = strArr1.length;
        int n = strArr2.length;
        int i = 0;
        int len = m > n ? m : n;
        while (i < len) {
            if (i < m) {
                charValue1 = Integer.valueOf(strArr1[i]);
            } else {
                charValue1 = 0;
            }
            if (i < n) {
                charValue2 = Integer.valueOf(strArr2[i]);
            } else {
                charValue2 = 0;
            }
            i++;
            if (charValue1 < charValue2) {
                return -1;
            } else if (charValue1 > charValue2) {
                return 1;
            }
        }
        return 0;
    }

    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        //两边夹 缩小区间  结束后 i == j 唯一值
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[j]) {  /*中值 > 右值，最小值在右半边，收缩左边界 不包括mid */
                i = mid + 1;
            } else { //中间值小于右边界 右边区域 肯定为单调递增 收缩右边界 包括mid
                j = mid;
            }
        }
        return nums[i];
    }

    public int searchInsert(int[] nums, int target) {
        //目的 寻找第一个大于 等于target 的数
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            }else {
                j = mid ;
            }
        }
        return i;
    }
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> need = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c,need.getOrDefault(c,0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {

            }
            //收缩左边界
            while (valid == need.size()) {
                char c2 = s.charAt(left);
                if (right - left < len) {
                     len = right - left + 1;
                     start = left;
                }
                if (need.containsKey(c2)) {
                    if (window.get(c2).equals(need.get(c2))) {
                        valid--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }
}




