package ��ָoffer;
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
		public ListNode reverseList(ListNode head) {
			// ��ʼ����ָ��
			ListNode pre = null, tem = null;
			ListNode cur = head;
			while (cur != null) {
				tem = cur.next;// ��ʱ����cur��һ���ڵ�  ��ֹ�������
				cur.next = pre;// cur�ڵ㣨��ǰ�ڵ㣩ָ��pre
				pre = cur;// preǰ��һλ
				cur = tem;// curǰ��һλ
			}
			return pre;// ����ͷָ��
		}
	}

}
