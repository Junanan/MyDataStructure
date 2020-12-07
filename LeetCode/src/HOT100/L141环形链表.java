package HOT100;

//����һ�������ж��������Ƿ��л���
//
//Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
public class L141�������� {
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
	//�쳣��
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
