package HOT100;

import java.util.HashMap;

//
//�� O(n log n) ʱ�临�ӶȺͳ������ռ临�Ӷ��£��������������
//
//ʾ�� 1:
//
//����: 4->2->1->3
//���: 1->2->3->4
//ʾ�� 2:
//
//����: -1->5->3->4->0
//���: -1->0->3->4->5
public class L148�������� {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode  midNode= getmid(head);
		ListNode righthead = midNode.next;
		midNode.next =null;//�Ͽ�
		//����Ū����������
		ListNode left = sortList(head);   //�з���ֵ�ĵݹ� ����Ҫ��ֵȥ���ܵݹ�Ľ��
		ListNode right =sortList(righthead);
		//�ϲ�������������
		return merge(left,right);
	}



	private ListNode getmid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head;
		while (pre != null && pre.next != null) {
			pre = pre.next.next;
			cur = cur.next;
		}
		return cur;
	}
	private ListNode merge(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		}else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
	public static void main(String[] args) {
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		System.out.println(map.size());
	}
}
