package HOT100;

//请判断一个链表是否为回文链表。
//
//示例 1:
//
//输入: 1->2
//输出: false
//示例 2:
//
//输入: 1->2->2->1
//输出: true
public class L234回文链表 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	 public static boolean isPalindrome(ListNode head) {
         if(head==null||head.next==null) return true;
         ListNode mid = getmid(head);
         //反转后一段的链表 前半段的会错
         ListNode pre = reverse(mid);
         ListNode cur = head;
         while(cur!=null&&pre!=null){
             if(cur.val!=pre.val) return false;
             cur = cur.next;
             pre = pre.next;
         }
         return true;
     }
     private static ListNode getmid(ListNode head){
         if(head==null||head.next==null) return head;
         ListNode pre =head;
         ListNode cur =head;
         while(pre!=null&&pre.next!=null){
             pre = pre.next.next;
             cur = cur.next;
         }
         return cur;
     }
     private static ListNode reverse(ListNode head) {
         ListNode prev = null;
         ListNode cur = head;
         while (cur != null) {
             ListNode next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
         }
         return prev;
     }
     public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode root2 = new ListNode(0);
		ListNode root3 = new ListNode(1);
//		ListNode root4 = new ListNode(1);
		root.next = root2;
		root2.next = root3;
//		root3.next = root4;
		System.out.println(isPalindrome(root));
	}
}
