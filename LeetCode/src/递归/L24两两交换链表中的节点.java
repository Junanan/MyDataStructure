package �ݹ�;

//����һ���������������������ڵĽڵ㣬�����ؽ����������
//
//�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
//
//ʾ��:
//
//���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
public class L24�������������еĽڵ� {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		head.next = swapPairs(next.next); // head��������ɽ���������
		next.next = head;
		return next;
	}
}
//����ֹ������ʲô����µݹ���ֹ��û�ý�����ʱ�򣬵ݹ����ֹ���¡���˵�����ֻʣһ���ڵ����û�нڵ��ʱ����Ȼ�ݹ����ֹ�ˡ�
//
//�ҷ���ֵ������ϣ������һ���ݹ鷵��ʲô��Ϣ���������ǵ�Ŀ���������������������ڵĽڵ㣬�����Ȼϣ����������һ���ݹ�����Ѿ���ɽ����������Ѿ�����õ�����
//
//�����ݹ�Ӧ����ʲô����ϵڶ���������ͼ������ֻ���Ǳ����ݹ飬�����������������������ʵҲ�������ڵ㣺head��head.next���Ѵ�����������֡�
//�������ݹ������Ҳ���ǽ�����3���ڵ��е�ǰ�����ڵ㣬�ͺ�easy�ˡ�
//public ListNode swapPairs(ListNode head) {
//    ListNode pre = new ListNode(0);
//    pre.next = head;
//    ListNode temp = pre;
//    while(temp.next != null && temp.next.next != null) {
//        ListNode start = temp.next;
//        ListNode end = temp.next.next;
//        temp.next = end;
//        start.next = end.next;
//        end.next = start;
//        temp = start;
//    }
//    return pre.next;
//}
