package List;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//示例 1:
//输入: 1->1->2
//输出: 1->2
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
//	 原来我写的内部类是动态的，也就是开头以public class开头。
//	 而主程序是public static class main。在Java中，类中的静态方法不能直接调用动态方法。只有将某个内部类修饰为静态类，然后才能够在静态类中调用该类的成员变量与成员方法。
//	 所以在不做其他变动的情况下，最简单的解决办法是将public class改为public static class.
	
}
