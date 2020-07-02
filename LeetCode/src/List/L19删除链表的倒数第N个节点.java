package List;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
//示例：
//
//给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//说明：
//
//给定的 n 保证是有效的。
//
//进阶：
//
//你能尝试使用一趟扫描实现吗？
public class L19删除链表的倒数第N个节点 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null) return null;
		ListNode dummp = new ListNode(0);
		dummp.next = head;
		ListNode cur = dummp ;
		ListNode pre = dummp ;
		while((n--)!=0) {
			pre = pre.next;
		}
		while(pre.next!=null) {
			cur = cur.next;
			pre = pre.next;
		}
		cur.next = cur.next.next;
		return dummp.next; /// 不能返回head 因为可能将头结点删掉
    }

}
