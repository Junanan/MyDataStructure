package HOT100;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
//示例：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
public class L21合并两个有序链表 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode dump = new ListNode(0);
		ListNode cur = dump;
		while(l1!=null&&l2!=null) {
			if(l1.val<l2.val) {
				cur.next = l1;
				l1 = l1.next;
				cur = cur.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
				cur = cur.next;
			}
		}
		if(l1!=null) {
			cur.next = l1;
		}
		if(l2!=null) {
			cur.next = l2;
		}
		return dump.next;
		
	}

		
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l11 = new ListNode(2);
		ListNode l111 = new ListNode(4);
		l1.next = l11;
		l11.next = l111;
		ListNode l2 = new ListNode(1);
		ListNode l22 = new ListNode(2);
		ListNode l222 = new ListNode(4);
		l2.next = l22;
		l22.next = l222;
		mergeTwoLists(l1, l2);
	}
}
