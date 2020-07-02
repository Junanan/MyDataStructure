package ListNode;

import List.L61Ðý×ªÁ´±í.ListNode;

public class Test {
	public static void main(String[] args) {
		MyListNode b = new MyListNode();
		b.addLast(1);
		b.addLast(2);
		b.addLast(3);
		System.out.println(b.get(0));
		b.addIndex(3, 22);
		b.show();
		b.deleteIndex(3);
		System.out.println("===");
		b.show();
	}
//	ListNode head = new ListNode(1);
//	ListNode n2 = new ListNode(2);
//	ListNode n3 = new ListNode(3);
//	ListNode n4 = new ListNode(4);
//	ListNode n5 = new ListNode(5);
//	head.next = n2;
//	n2.next =n3 ;
//	n3.next =n4;
//	n4.next =n5;
    
}
