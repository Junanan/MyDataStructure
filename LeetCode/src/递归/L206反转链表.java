package 递归;

//反转一个单链表。
//
//示例:
//
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
public class L206反转链表 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		// 把 1 分离出来，然后假设后面的 2345NULL 都已经反转好了(即 NULL<-2<-3<-4<-5)
		ListNode cur = reverseList(head.next);
		// 这时候开始处理1，把1接上cur就完成任务了。此时head是1，cur是 NULL<-2<-3<-4<-5。此时 head->next仍然是2
		// head->next->next是NULL。所以写了这一行之后，就会变成 1<-2<-3<-4<-5
		head.next.next = head;
		// 这一行就是把 NULL接在 1 的后面，变成 NULL<-1<-2<-3<-4<-5
		head.next = null;
		return cur;
	}
}
