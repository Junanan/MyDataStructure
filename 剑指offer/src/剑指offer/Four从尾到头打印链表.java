package 剑指offer;
import java.util.*;
import java.util.LinkedList;

public class Four从尾到头打印链表 {
//	输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//	输入：head = [1,3,2]
//	输出：[2,3,1]
	// 递归法
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
//////重头到尾的输出数据 很自然的想到了栈实现  想到了栈 递归在本质上就是一个栈结构 然后又很自然的想到了递归实现------
		static List<Integer> tmp = new ArrayList<Integer>();
		public static int[] reversePrint(ListNode head) {
			revese(head);
			int[] res = new int[tmp.size()];/////转换为数组
			for (int i = 0; i < tmp.size(); i++) {
				res[i] = tmp.get(i);
			}
			return res;
		}
		private static void revese(ListNode head) {
			if (head != null) {
				revese(head.next);
				tmp.add(head.val);
			}
		}
		///辅助栈法
	    public int[] reversePrintt(ListNode head) {
	        LinkedList<Integer> stack = new LinkedList<Integer>();
	        while(head != null) {
	            stack.addLast(head.val);
	            head = head.next;
	        }
	        int[] res = new int[stack.size()];
	        for(int i = 0; i < res.length; i++)
	            res[i] = stack.removeLast();
	    return res;
	    }
	}
}
