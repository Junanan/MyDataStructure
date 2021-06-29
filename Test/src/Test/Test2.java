package Test;

import sun.security.jca.GetInstance;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
        ListNode cur = head;
        int a = 2;
        test2.te3(a);
        String b = "b";
        StringBuilder b1 = new StringBuilder();
        b1.append('b');
        test2.te(b);
        test2.te2(b1);
        System.out.println(b);
        System.out.println(b1.toString());
        List list = new LinkedList<>();
        list.size();
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
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) return mid;
            //当nums[mid]>=nums[i] 表示前半部分有序，可以在此处判断缩小范围
            if (nums[i] < nums[mid]) {
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
                //要么后半部分有序
            } else {
                if (target > nums[mid] && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        MaxValue(root);
        return res;
    }

    private int MaxValue(TreeNode root) {
        if (root == null) return 0;
        int leftMax = MaxValue(root.left);
        int rightMax = MaxValue(root.right);
        if (root.left != null) {
            leftMax += root.left.val;
        } else {
            leftMax = 0;
        }
        if (root.right != null) {
            rightMax += root.right.val;
        } else {
            rightMax = 0;
        }
        res = Math.max(res, root.val + leftMax + rightMax);
        //不能返回负效应
        return Math.max(root.val + Math.max(leftMax, rightMax), 0);
    }

    private int maxPath(TreeNode root) {
        if (root == null) return 0;
        int leftMax;
        int rightMax;
        if (root.left != null && root.left.val == root.val) {
            leftMax = maxPath(root.left);
        } else {
            leftMax = 0;
        }
        if (root.right != null && root.right.val == root.val) {
            rightMax = maxPath(root.right);
        } else {
            rightMax = 0;
        }
        res = Math.max(res, leftMax + rightMax);
        return Math.max(leftMax, rightMax) + 1;
    }

    private TreeNode build(int[] preorder, int[] inorder, int p_start, int p_end, int i_start, int i_end) {
        if (p_start == p_end) return null;
        int val = preorder[p_start];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.left = build(preorder, inorder, p_start + 1, p_start + 1 + index - i_start, i_start, index);
        root.right = build(preorder, inorder, p_start + 1 + index - i_start, p_end, index + 1, i_end);
        return root;
    }

    List<List<Integer>> resList;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return resList;
        }
        List<Integer> list = new LinkedList<>();
        recurs(root, sum, list);
        return resList;
    }

    private void recurs(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            resList.add(new LinkedList<>(list));
            return;
        }
        recurs(root.left, sum, list);
        recurs(root.right, sum, list);
        list.remove(list.size() - 1);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int i, int j) {
        while (i < j) {
            int mid = i + (j - i) / 2;
            ListNode listNode = mergeList(lists, i, mid);
            ListNode listNode1 = mergeList(lists, mid + 1, j);
            return merge(listNode, listNode1);
        }
        return lists[i];
    }

    private ListNode merge(ListNode listNode, ListNode listNode1) {
        if (listNode == null) return listNode1;
        if (listNode1 == null) return listNode;
        if (listNode.val < listNode1.val) {
            listNode.next = merge(listNode.next, listNode1);
            return listNode;
        } else {
            listNode1.next = merge(listNode, listNode1.next);
            return listNode1;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode cur = head;
        ListNode pre = head;
        ListNode mid;
        while (pre.next != null && pre.next.next != null) {
            cur = cur.next;
            pre = pre.next.next;
        }
        mid = cur.next;
        cur.next = null;
        cur = head;
        rervse(mid);
        merge(cur, head);
    }

    private ListNode rervse(ListNode mid) {
        if (mid == null) return null;
        ListNode temp = rervse(mid.next);
        ListNode du = temp;
        while (du != null) {
            du = du.next;
        }
        du.next = mid;
        mid.next = null;
        return temp;
    }

    public int majorityElement(int[] nums) {
        int flag = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == flag) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                flag = nums[i];
                count = 1;
            }
        }
        return flag;
    }
}




