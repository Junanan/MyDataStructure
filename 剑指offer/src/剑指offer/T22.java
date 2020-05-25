package 剑指offer;

import java.util.Arrays;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
//示例1：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
public class T22 {
//	public class ListNode {
//		      int val;
//		     ListNode next;
//		    ListNode(int x) { val = x; }
//	}
	//归并排序的思想
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 ////代码鲁棒性
		 if(l1==null) return l2;
		 if(l2==null) return l1;
		 //创建虚拟头结点 如果没有虚拟头结点 第一个节点可能是l1的也可能是l2的
		 ListNode dum = new ListNode(0) , cur = dum;////// dum 为虚拟头结点head  
		 while(l1!=null&&l2!=null) {
			 if(l1.val<l2.val) {
				 cur.next = l1;
				 l1=l1.next;
			 }else {
				 cur.next = l2;
				 l2=l2.next;
			 }
			 cur = cur.next;
		 }
		 //处理多余节点
		 if(l1!=null) cur.next = l1;
		 if(l2!=null) cur.next = l2;
		 return dum.next;
	    }
	 public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(3);
		ListNode b3 = new ListNode(4);
		a.append(a1).append(a2);
		b1.append(b2).append(b3);
		ListNode g = mergeTwoLists(a, b1);
		g.show();
	}

}
