package 栈与队列;

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
	
	
	//但是，有一个疑问就是，LinkedList实现的是Deque（是一个双端队列）这个能通过吗？

// 你好~ 我认为本题目 Java 使用 Stack / LinkedList / ArrayDeque 都是可以的，
//	因为题目的本意应该是让我们使用 先进后出 实现 先进先出 ，而不是考察对某一集合框架的具体使用。
//	以上三种类型的区别可参考 Stack，ArrayDeque，LinkedList的区别 ，
//	文中指出：频繁的插入和删除操作首选 LinkedList ，并且通常情况下不推荐使用Vector以及其子类 Stack 。
	
	///一个栈暂时存储数组 一个栈用来当成队列
	static class CQueuee {
		LinkedList<Integer> a;
		LinkedList<Integer> b;
		public CQueuee() {
			a = new LinkedList<>();
			b = new LinkedList<>();
		}

		public void appendTail(int value) {
			a.addLast(value);

		}

		public int deleteHead() {
			if (!b.isEmpty())
				return b.removeLast();
			if (a.isEmpty())
				return -1;
			while (!a.isEmpty()) {
				b.add(a.removeLast());
			}
			return b.removeLast();
		}

//	    public void main(String[] args) {
//			CQueue aa =new CQueue();
	}

	public static void main(String[] args) {
		CQueuee aa = new CQueuee();
		aa.appendTail(1);
		aa.appendTail(2);
		int a1 = aa.deleteHead();
		System.out.println(a1);
	}

}
