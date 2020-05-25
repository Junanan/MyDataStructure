package �����³����;

import ��ָoffer.T20.ListNode;

//����һ������������һ�������ͷ�ڵ㣬��ת�����������ת�������ͷ�ڵ㡣
//ʾ��:
//����: 1->2->3->4->5->NULL
//���: 5->4->3->2->1->NULL
public class T21 {
	//˼· 1->2->3->4->5  �������������� ������ָ������ 1<-2<-3<-4<-5
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
		// ��ָ�뷨
		public ListNode reverseList(ListNode head) {
			// ��ʼ����ָ��
			ListNode pre = null, tem = null;
			ListNode cur = head;
			while (cur != null) {
				tem = cur.next;// ��ʱ����cur��һ���ڵ�  ��ֹ�������
				cur.next = pre;// cur��һ���ڵ�ָ��pre
				pre = cur;// ��ǰһ���ڵ�
				cur = tem;// ��ǰһ���ڵ�
			}
			return pre;// ����ͷָ��
		}
		
		// �ݹ鷨
		public static ListNode reverseListt(ListNode head) {
			// �ݹ�ֹͣ����
			if (head == null || head.next == null) {
				return head;
			}
			ListNode cur = reverseListt(head.next);// �ݹ�ʹ��cur=���һ���ڵ㣬����1-2-3-4-5 cur=5
			// head =4 head.next =5 head.next.next=null
			head.next.next = head;
			head.next = null;// ��ֹ����ѭ��
			return cur;// ÿ�ζ������һ���ڵ�
		}
	}

}
