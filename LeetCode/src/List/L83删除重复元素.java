package List;
//����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
//ʾ�� 1:
//����: 1->1->2
//���: 1->2
public class L83ɾ���ظ�Ԫ�� {
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	 public  ListNode deleteDuplicates(ListNode head) {
		 if(head==null) return null;
		 if(head.next==null) return head;
		 ListNode cur = head;
		 while(cur!=null&&cur.next!=null) {
			 if(cur.next.val==cur.val) cur.next = cur.next.next;
			 else cur = cur.next; //// û��else�Ļ� ����ж���ظ���������1->1->1  �����1->1;
		 }
		 return head;
	 } 

	
}
