package 剑指offer;
//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
//示例：
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//返回链表 4->5.
public class T20 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		// 双指针法
		public ListNode getKthFromEnd(ListNode head, int k) {
			ListNode format = head, latter = head;// 初始化双指针
			// 代码的鲁棒性
			if (head == null || k == 0)
				return null;

			for (int i = 0; i < k; i++) {// 使得format 与 latter 始终距离K个单位
				if (format.next != null) {//如果K-1大于节点总数会造成空指针异常      代码的鲁棒性
					format = format.next;
				} else
					return null;
			}
			while (format != null) {
				format = format.next;
				latter = latter.next;
			}
			return latter;
		}

	}
}
