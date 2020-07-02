package 快慢指针遍历;
//给定一个链表，判断链表中是否有环。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//示例 1：
//
//输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
//示例 2：
//
//输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
//
//
//示例 3：
//
//输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
public class L141环形链表 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
//	快慢指针法
//	两个指针 p1 和 p2 ，初始指向头节点
//	开启循环，p1 每次推进 1 个节点，p2 每次推进 2 个节点，不断比较它们指向的节点
//	如果出现相同，说明有环，如果不同，继续循环
//	类似“追及问题”
//	2 个人在环形跑道上赛跑，从同一个起点出发，一个跑得快，一个跑得慢，在某一时刻，速度快的必定会追上速度慢的
//	只要是跑道是环形的
public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null) {	
        	if(fast.next==null) return false;
        	slow = slow.next;
        	fast = fast.next.next;
        	if(fast==slow) return true;
        }
        return false;
    }

}
