package HOT100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//说明：不允许修改给定的链表。
public class L142环形链表2 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
//	其中【*】为快慢指针首次相遇点，入环前距离为【D】，慢指针入环后走过的距离为【S1】，环剩下距离为【S2】
//
//	首次相遇
//	1.慢指针 S = D + S1
//	2.快指针 F = D + n(S1 + S2) + S1 其中n>=1,快指针起码走了一圈以上才可能相遇
//	3.又因为 F = 2S 慢指针走一步，快指针走两步
//	4.代入1，2 可得 2(D + S1) = D + n(S1 + S2) + S1
//	各种移项可得 D = (n-1)S1 + nS2 = (n-1)(S1 + S2) + S2
//	5.其中 n为快指针绕的圈数
//	n=1 D = S2
//	n=2 D = 一圈 + S2
//	n=3 D = 两圈 + S2
//	所以其实我们并不关心绕了多少圈，就知道 n圈+S2就是入环点了
//	6.人为构造碰撞机会，让快指针重新出发（但这次一次走一步），只要碰撞了，就是入环位置了，管他慢指针在环里绕了多少圈
public ListNode detectCycle (ListNode head) {
        ListNode pre = head.next;
        ListNode cur = head;
        while(pre!=null&&pre.next!=null) {
        	if(cur==pre) {
        		break;
        	}
        	cur =cur.next;
        	pre =pre.next.next;
        }
        pre = head;
        while(pre!=null) {
        	if(cur==pre) {
        		break;
        	}
        	cur=cur.next;
        	pre=pre.next;
        }
        return pre;
    }
public static void main(String[] args) {
	String a = "asd";
	a.length();
	StringBuilder as = new StringBuilder();
	as.length();
	List<Character> a2= new ArrayList<Character>();
	a2.size();
	Queue<Character> a3 = new LinkedList<Character>();
	a3.size();
	Stack<Character> a4 = new Stack<>();
	a4.size();
	HashMap<Integer, Integer> map = new HashMap<>();
	map.size();
	int[] a6 = new int[] {12,3,5,4,3,2};
	a6[0] =1;
	int a7 =a6.length;

}

}
