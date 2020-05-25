package 举例让抽象问题具体化;
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
//示例:
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   -  -> 返回 -2.

import java.util.Stack;
//思想运用辅助栈储存较小值(伪排序)
public class T27 {
	static class MinStack{
	Stack<Integer> a,b;
	public  MinStack() {
		a = new Stack<>();
		b = new Stack<>();
    }
    public void push(int x) {
    	a.add(x);
    	if(b.empty()||b.peek()>x) {
    	b.add(x);
    	}
    }
    
    public void pop() {
    	//a先进行pop 如果a栈顶等于b栈顶 则两个都要删除保持一致性
    	if(a.pop()==b.peek()) {
    		b.pop();
    	}

    }
    
    public int top() {
    	return a.peek();

    }
    
    public int min() {
    	return b.peek();
    	
    }
    public static void main(String[] args) {
		MinStack a = new MinStack();
		a.push(-2);
		a.push(0);
		a.push(-3);
		System.out.println(a.min());  
		a.pop();
		System.out.println(a.top());    
		System.out.println(a.min());   
	}
}
	
}
