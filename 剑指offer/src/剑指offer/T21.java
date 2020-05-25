package 剑指offer;
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
		public ListNode reverseList(ListNode head) {
			// 初始化三指针
			ListNode pre = null, tem = null;
			ListNode cur = head;
			while (cur != null) {
				tem = cur.next;// 暂时储存cur下一个节点  防止链表断裂
				cur.next = pre;// cur节点（当前节点）指向pre
				pre = cur;// pre前进一位
				cur = tem;// cur前进一位
			}
			return pre;// 返回头指针
		}
	}

}
