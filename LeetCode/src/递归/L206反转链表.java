package �ݹ�;

//��תһ��������
//
//ʾ��:
//
//����: 1->2->3->4->5->NULL
//���: 5->4->3->2->1->NULL
public class L206��ת���� {
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
		// �� 1 ���������Ȼ��������� 2345NULL ���Ѿ���ת����(�� NULL<-2<-3<-4<-5)
		ListNode cur = reverseList(head.next);
		// ��ʱ��ʼ����1����1����cur����������ˡ���ʱhead��1��cur�� NULL<-2<-3<-4<-5����ʱ head->next��Ȼ��2
		// head->next->next��NULL������д����һ��֮�󣬾ͻ��� 1<-2<-3<-4<-5
		head.next.next = head;
		// ��һ�о��ǰ� NULL���� 1 �ĺ��棬��� NULL<-1<-2<-3<-4<-5
		head.next = null;
		return cur;
	}
}
