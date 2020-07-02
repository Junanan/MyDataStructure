package List;
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//
//输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
public class L61旋转链表 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	 public static ListNode rotateRight(ListNode head, int k) {
		 if(head==null||head.next==null||k==0) return head;
		 int len =0;
		 ListNode cur = head;
		 while(cur!=null) {
			 len++;
			 cur = cur.next;
		 }
		 cur = head;
		 int changelength = k % len;
		 int golength = len - changelength;
		 if(changelength==0) return head; ///////!!!!!
		 ListNode temp = head;
		 for(int i =1 ;i<=golength-1;i++) {
			 temp = temp.next;
		 }
		 for(int i =1 ;i<=len-1;i++) {
			 cur = cur.next;
		 }
		 ListNode res = temp.next;
		 temp.next =null;
		 cur.next = head;
		 return res;
	 }
//   public static ListNode rotateRight(ListNode head, int k) {
//	 if(head==null||head.next==null||k==0) return head;
//	 int len =0;
//	 ListNode cur = head;
//	 while(cur!=null) {
//		 len++;
//		 cur = cur.next;
//	 }
//	 cur = head;
//	 int move = k % len;
//     if(move==0) return head;
//	 int temp = move+1;
//	 while((temp--)!=0) {
//		 cur =cur.next;
//	 }
//	 ListNode res = new ListNode(0);
//	 ListNode cur2 = res;
//	 while(cur!=null) {
//		 cur2.next = new ListNode(cur.val); 
//		 cur = cur.next;
//		 cur2 = cur2.next;
//	 }
//	 int last = len -move;
//	 while(((last)--)!=0) {
//		 cur2.next = new ListNode(head.val);
//		 head = head.next;
//		 cur2 = cur2.next;
//	 }
//	 return res.next;
//    }
	 public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		head.next = n2;
		n2.next =n3 ;
		n3.next =n4;
		n4.next =n5;
		rotateRight(head,2);
	}
}
