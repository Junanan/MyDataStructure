package HOT100;

public class L160œ‡Ωª¡¥±Ì {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null) return null;
		ListNode p = headA;
		ListNode q = headB;
		while(p!=q) {
			p = p==null?headB:p.next;
			q = q==null?headA:q.next;
		}
		return q;
	}

}
