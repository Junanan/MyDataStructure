package 代码的鲁棒性;

import 剑指offer.T20.ListNode;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//示例:
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
public class T21 {
	//思路 1->2->3->4->5  这是链表不是数组 反过来指就行了 1<-2<-3<-4<-5
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
		// 三指针法
		public ListNode reverseList(ListNode head) {
			// 初始化三指针
			ListNode pre = null, tem = null;
			ListNode cur = head;
			while (cur != null) {
				tem = cur.next;// 暂时储存cur下一个节点  防止链表断裂
				cur.next = pre;// cur下一个节点指向pre
				pre = cur;// 向前一个节点
				cur = tem;// 向前一个节点
			}
			return pre;// 返回头指针
		}
		
		// 递归法
		public static ListNode reverseListt(ListNode head) {
			// 递归停止条件
			if (head == null || head.next == null) {
				return head;
			}
			ListNode cur = reverseListt(head.next);// 递归使得cur=最后一个节点，假设1-2-3-4-5 cur=5
			// head =4 head.next =5 head.next.next=null
			head.next.next = head;
			head.next = null;// 防止链表循环
			return cur;// 每次都返最后一个节点
		}
	}

}
