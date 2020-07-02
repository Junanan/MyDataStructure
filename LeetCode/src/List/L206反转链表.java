package List;

public class L206·´×ªÁ´±í {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public static ListNode reverseList(ListNode head) {
		if(head==null||head.next==null) return null;
		ListNode pre = null;
		ListNode cur = head;
		while(head!=null) {
			head = head.next;
			cur.next = pre;
			pre = cur;
			cur = head;
		}
		return pre;
	}
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
		reverseList(head);
//		ListNode cur = head;
//		int n =2;
//		while((n--)!=0) {
//			cur = cur.next;
//		}
//		System.out.println(cur.val);
	}
}
