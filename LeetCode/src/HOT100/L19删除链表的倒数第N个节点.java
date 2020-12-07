package HOT100;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//示例：
//
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
public class L19删除链表的倒数第N个节点 {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode removeNthFromEnd(ListNode head, int n) {
		 if(head==null) return null;
		ListNode dump = new ListNode(0);
		dump.next =head;
		ListNode pre =  dump;
		ListNode cur =  dump;
		for(int i=0;i<=n;i++) {
			pre = pre.next;
		}
		while(pre.next!=null) {
			pre = pre.next;
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return dump.next;
    }
}
