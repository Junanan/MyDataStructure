package List;
//����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
//ʾ�� 1:
//����: 1->1->2
//���: 1->2
public class T2 {
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	 public static ListNode deleteDuplicates(ListNode head) {
	        if(head==null) return null;
	        ListNode cur=head;
	        while(cur!=null&&cur.next!=null) {
	        	if(cur.next.val==cur.val) {
	        		cur.next = cur.next.next;
	        	}else cur = cur.next;
	        }
	        return head;
	    }
	 public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		n1.next = new ListNode(1);
		n1.next.next = new ListNode(1);
		deleteDuplicates(n1);
		
	}
//	 ԭ����д���ڲ����Ƕ�̬�ģ�Ҳ���ǿ�ͷ��public class��ͷ��
//	 ����������public static class main����Java�У����еľ�̬��������ֱ�ӵ��ö�̬������ֻ�н�ĳ���ڲ�������Ϊ��̬�࣬Ȼ����ܹ��ھ�̬���е��ø���ĳ�Ա�������Ա������
//	 �����ڲ��������䶯������£���򵥵Ľ���취�ǽ�public class��Ϊpublic static class.
	
}
