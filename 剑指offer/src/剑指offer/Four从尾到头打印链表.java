package ��ָoffer;
import java.util.*;
import java.util.LinkedList;

public class Four��β��ͷ��ӡ���� {
//	����һ�������ͷ�ڵ㣬��β��ͷ����������ÿ���ڵ��ֵ�������鷵�أ���
//	���룺head = [1,3,2]
//	�����[2,3,1]
	// �ݹ鷨
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
//////��ͷ��β��������� ����Ȼ���뵽��ջʵ��  �뵽��ջ �ݹ��ڱ����Ͼ���һ��ջ�ṹ Ȼ���ֺ���Ȼ���뵽�˵ݹ�ʵ��------
		static List<Integer> tmp = new ArrayList<Integer>();
		public static int[] reversePrint(ListNode head) {
			revese(head);
			int[] res = new int[tmp.size()];/////ת��Ϊ����
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
		///����ջ��
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
