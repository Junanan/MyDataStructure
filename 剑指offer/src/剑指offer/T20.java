package ��ָoffer;
//����һ����������������е�����k���ڵ㡣Ϊ�˷��ϴ�����˵�ϰ�ߣ������1��ʼ�������������β�ڵ��ǵ�����1���ڵ㡣
//���磬һ��������6���ڵ㣬��ͷ�ڵ㿪ʼ�����ǵ�ֵ������1��2��3��4��5��6���������ĵ�����3���ڵ���ֵΪ4�Ľڵ㡣
//ʾ����
//����һ������: 1->2->3->4->5, �� k = 2.
//�������� 4->5.
public class T20 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		// ˫ָ�뷨
		public ListNode getKthFromEnd(ListNode head, int k) {
			ListNode format = head, latter = head;// ��ʼ��˫ָ��
			// �����³����
			if (head == null || k == 0)
				return null;

			for (int i = 0; i < k; i++) {// ʹ��format �� latter ʼ�վ���K����λ
				if (format.next != null) {//���K-1���ڽڵ���������ɿ�ָ���쳣      �����³����
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
