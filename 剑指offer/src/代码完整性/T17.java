package 代码完整性;
//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//
//返回删除后的链表的头节点。
//
//注意：此题对比原题有改动
//
//示例 1:
//
//输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
//删除链表的节点
public class T17 {
	public static class ListNode {
		ListNode next;
		int val;
		public ListNode(int x) {
			val = x;
			////////剑指offer算法代码比较繁琐 思路很棒
		}
	//双指针时间删除节点
	public ListNode deleteNode(ListNode head, int val) {
		if(head.val==val) return head.next;
		ListNode cur= head.next,pre = head;
		while(cur!=null&&cur.val!=val) {
			 pre = cur;
			 cur = cur.next;
		}
		pre.next =cur.next;
		return head;
}
	}

}
