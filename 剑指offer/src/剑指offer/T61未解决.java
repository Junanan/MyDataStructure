package 剑指offer;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Queue;
//
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//
//若队列为空，pop_front 和 max_value 需要返回 -1
//
//示例 1：
//
//输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
//示例 2：
//
//输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
public class T61未解决 {
	static class MaxQueue {
		Queue<Integer> a;
		Deque<Integer> b;
	    public MaxQueue() {
	    	a = new LinkedList<>(); 
	    	b = new LinkedList<>(); 
	    }
	    public int max_value() {
	    	if(a.isEmpty()) return-1;
	    	return b.peekLast();
	    }
	    public void push_back(int value) {
	    	a.add(value);
	    	if(b.isEmpty()||b.peekLast()<value) b.add(value);
	    }
	    
	    public int pop_front() {
	    	if(a.isEmpty()) return-1;
	    	int temp = a.remove();
	    	if(temp==b.peekFirst())  b.removeFirst();
	    	return temp;
	    }
	}
	public static void main(String[] args) {
		Deque<Integer> b = new LinkedList<>();
		MaxQueue a = new MaxQueue();
		a.push_back(94);
		a.push_back(16);
		a.push_back(89);
		a.pop_front();
		a.push_back(22);
		System.out.println(a.pop_front());
	}
	

}
