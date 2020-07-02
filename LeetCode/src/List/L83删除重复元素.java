package List;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//示例 1:
//输入: 1->1->2
//输出: 1->2
public class L83删除重复元素 {
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
			 else cur = cur.next; //// 没有else的话 如果有多个重复就跳过了1->1->1  输出：1->1;
		 }
		 return head;
	 } 

	
}
