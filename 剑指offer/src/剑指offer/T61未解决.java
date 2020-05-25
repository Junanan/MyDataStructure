package ��ָoffer;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Queue;
//
//�붨��һ�����в�ʵ�ֺ��� max_value �õ�����������ֵ��Ҫ����max_value��push_back �� pop_front �ľ�̯ʱ�临�Ӷȶ���O(1)��
//
//������Ϊ�գ�pop_front �� max_value ��Ҫ���� -1
//
//ʾ�� 1��
//
//����: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//���: [null,null,null,2,1,2]
//ʾ�� 2��
//
//����: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//���: [null,-1,-1]
public class T61δ��� {
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
