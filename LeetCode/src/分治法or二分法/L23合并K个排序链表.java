package ���η�or���ַ�;
public class L23�ϲ�K���������� {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 public ListNode mergeKLists(ListNode[] lists) {
	        if (lists == null || lists.length == 0) return null;
	        return merge(lists, 0, lists.length - 1);
	    }

	private ListNode merge(ListNode[] lists, int i, int j) {
		if(i<j) {
			int mid = (i+j)/2;
			ListNode l1 =merge(lists,i,mid);
			ListNode l2 =merge(lists,mid+1,j);
			return mergeTwoList(l1,l2);
		}
		return lists[i];
	}

	private ListNode mergeTwoList(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		//l1.next ����ԭ����  Ҳ���½�һ��ͷ���P  p.next = /  
		///���ݹ鿴��ֻʣһ���ڵ�δ�Ƚ� ����l1[0] ���Զ�Ӧ�ĵݹ��� �϶��� l1ȱ��һ���ڵ�  ���Ծ���l1.next
		if(l1.val<l2.val) {
			l1.next = mergeTwoList(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoList(l1, l2.next);
			return l2;
		}
	}

}
