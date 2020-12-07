package 分治法or二分法;
public class L23合并K个排序链表 {
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
		//l1.next 覆盖原链表  也可新建一个头结点P  p.next = /  
		///将递归看成只剩一个节点未比较 就是l1[0] 所以对应的递归中 肯定是 l1缺了一个节点  所以就是l1.next
		if(l1.val<l2.val) {
			l1.next = mergeTwoList(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoList(l1, l2.next);
			return l2;
		}
	}

}
