package �ݹ�;
//����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
//ʾ�� 1:
//
//����: 1->1->2
//���: 1->2
//ʾ�� 2:
//
//����: 1->1->2->3->3
//���: 1->2->3
public class L83ɾ�����������е��ظ�Ԫ�� {
	 public class ListNode {
		     int val;
		    ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode deleteDuplicates(ListNode head) {
	        if (head == null) {
	            return null;
	        }
	        if (head.next == null) {
	            return head;
	        }  
	        if (head.val == head.next.val) {
	            head = deleteDuplicates(head.next);
	        } else {
	            head.next = deleteDuplicates(head.next);
	        }
	        return head;
	    }
}
//����ֹ��������headָ������ֻʣһ��Ԫ�ص�ʱ����Ȼ�ǲ������ظ��ģ����return
//
//����Ӧ�÷���ʲôֵ��Ӧ�÷��ص���Ȼ���Ѿ�ȥ�ص������ͷ�ڵ�
//
//ÿһ��Ҫ��ʲô������Ͽ��ǣ���ʱhead.next�Ѿ�ָ��һ��ȥ�ص������ˣ������ݵڶ�������Ӧ�÷���һ��ȥ�ص������ͷ�ڵ㡣
//�����һ��Ӧ���������жϵ�ǰ��head��head.next�Ƿ���ȣ���������˵�����ˣ�����head.next�����򷵻�head
