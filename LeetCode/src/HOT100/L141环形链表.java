package HOT100;

//给定一个链表，判断链表中是否有环。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
public class L141环形链表 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode pre = head.next;
		ListNode cur = head;
		while (pre != null && pre.next != null) {
			if (cur == pre)
				return true;
			cur = cur.next;
			pre = pre.next.next;
		}
		return false;
	}
	//异常版
	public boolean slowAndFastExceptionSolution(ListNode head) {
		try {
			ListNode slow = head;
			ListNode fast = head.next;
			while (!slow.equals(fast)) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
