package 递归;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//示例:
//
//给定 1->2->3->4, 你应该返回 2->1->4->3.
public class L24两两交换链表中的节点 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		head.next = swapPairs(next.next); // head链接已完成交换的链表
		next.next = head;
		return next;
	}
}
//找终止条件。什么情况下递归终止？没得交换的时候，递归就终止了呗。因此当链表只剩一个节点或者没有节点的时候，自然递归就终止了。
//
//找返回值。我们希望向上一级递归返回什么信息？由于我们的目的是两两交换链表中相邻的节点，因此自然希望交换给上一级递归的是已经完成交换处理，即已经处理好的链表。
//
//本级递归应该做什么。结合第二步，看下图！由于只考虑本级递归，所以这个链表在我们眼里其实也就三个节点：head、head.next、已处理完的链表部分。
//而本级递归的任务也就是交换这3个节点中的前两个节点，就很easy了。
//public ListNode swapPairs(ListNode head) {
//    ListNode pre = new ListNode(0);
//    pre.next = head;
//    ListNode temp = pre;
//    while(temp.next != null && temp.next.next != null) {
//        ListNode start = temp.next;
//        ListNode end = temp.next.next;
//        temp.next = end;
//        start.next = end.next;
//        end.next = start;
//        temp = start;
//    }
//    return pre.next;
//}
