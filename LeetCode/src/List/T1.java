package List;
import ListNode.*;
//将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//示例：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
public class T1 {
	///递归法   不常用
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
    }
	///迭代法
	public ListNode mergeTwoListss(ListNode l1, ListNode l2) {
		ListNode prehead  = new ListNode(-1);////创建一个哨兵节点
		ListNode prev = prehead.next;
		while(l1!=null&&l2!=null) {
			if(l1.val<l2.val) {
				prev.next = l1;
				l1=l1.next;
			}else {
				prev.next = l2;
				l2=l2.next;
			}
		}
			prev = prev.next; 
		//处理多余的节点
		if(l1.next!=null) prev.next = l1;
		if(l2.next!=null) prev.next = l2;
		return prehead.next;////???为什么不是rturn prehead  答 prehead 在创建是-1 若返回perhead 则 头结点为-1
	}
	
	
	


}
