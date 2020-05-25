package 剑指offer;

import java.util.LinkedList;
import java.util.Stack;

public class Six {
//	用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
//  分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )	
//	示例 1：
//	输入：
//	["CQueue","appendTail","deleteHead","deleteHead"]
//	[[],[3],[],[]]
//	输出：[null,null,3,-1]
//	["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//			[[],[],[5],[2],[],[]]
//			输出：[null,-1,null,null,5,2]
		class CQueue {
		    Stack<Integer> stack1;
		    Stack<Integer> stack2;
		    int size;

		    public CQueue() {
		        stack1 = new Stack<Integer>();
		        stack2 = new Stack<Integer>();
		        size = 0;
		    }
		    
		    public void appendTail(int value) {
		        while (!stack1.isEmpty()) {
		            stack2.push(stack1.pop());
		        }
		        stack1.push(value);
		        while (!stack2.isEmpty()) {
		            stack1.push(stack2.pop());
		        }
		        size++;
		    }
		    
		    public int deleteHead() {
		        if (size == 0) {
		            return -1;
		        }
		        size--;
		        return stack1.pop();
		    }
		}

		/**
		 * Your CQueue object will be instantiated and called as such:
		 * CQueue obj = new CQueue();
		 * obj.appendTail(value);
		 * int param_2 = obj.deleteHead();
		 */

	public static void main(String[] args) {
////		CQueue aa = new CQueue();
//		aa.appendTail(1);
//		aa.appendTail(2);
//		int a1 = aa.deleteHead();
//		System.out.println(a1);
	}

}
