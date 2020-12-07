package List;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
//并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//示例：
//
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
public class L2两数之和 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode pre = new ListNode(0); // 哑巴节点？
		ListNode cur = pre;
		int carry = 0;
		while (l1.next != null || l2.next != null || carry > 0) { // 这里的carry大于0 是因为当最后一个节点可能进一位
			cur.next = new ListNode(0);
			cur = cur.next;
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			cur.val = carry % 10;
			carry = carry / 10;
		}
		return pre.next;
	}

	public static void main(String[] args) {
		System.out.println(9 / 10);
	}
}
