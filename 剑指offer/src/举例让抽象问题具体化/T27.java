package �����ó���������廯;
//����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص� min �����ڸ�ջ�У����� min��push �� pop ��ʱ�临�Ӷȶ��� O(1)��
//ʾ��:
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> ���� -3.
//minStack.pop();
//minStack.top();      --> ���� 0.
//minStack.min();   -  -> ���� -2.

import java.util.Stack;
//˼�����ø���ջ�����Сֵ(α����)
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
    	//a�Ƚ���pop ���aջ������bջ�� ��������Ҫɾ������һ����
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
