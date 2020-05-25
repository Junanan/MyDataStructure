package ��ָoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//����һ������ nums �ͻ������ڵĴ�С k�����ҳ����л�������������ֵ��
//
//����: nums = [1,3,-1,-3,5,3,6,7], �� k = 3
//���: [3,3,5,5,6,7] 
//����: 
//
//  �������ڵ�λ��                ���ֵ
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
public class T60 {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length==0 || k==0) return new int[0];	
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> Deque = new LinkedList<>();
		for (int j = 0, i = 1 - k; j < nums.length; j++, i++) {
			while (i > 0 && Deque.peekFirst() == nums[i - 1])
				Deque.removeFirst();
			while (!Deque.isEmpty() && nums[j] > Deque.peekLast())
				Deque.removeLast();
			Deque.addLast(nums[j]);
			if(i>=0)res[i] = Deque.peek();
		}
		return res;
	}  ///ά��˫��ջ  �����ǵ���ջ
	//////ջ����ȡ
	public static int[] maxSlidingWindoww(int[] nums, int k) {
		if(nums.length==0 || k==0) return new int[0];	
		int[] res = new int[nums.length - k + 1];
		Stack<Integer> s = new Stack<>();
		for(int j=0,i= 1-k;j<nums.length;j++,i++) {
			if(j>k-1&&s.peek()==nums[i-1]) s.pop();
			if(s.isEmpty()||s.peek()<nums[j]) s.push(nums[j]);
			if(j>=k-1) res[i] = s.peek(); 
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1,3,1,2,0,5};
		System.out.println(Arrays.toString(maxSlidingWindoww(nums, 3)));
	}
}
