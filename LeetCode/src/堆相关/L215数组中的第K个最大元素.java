package 堆相关;

import java.util.PriorityQueue;
import java.util.Queue;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//示例 1:
//
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//示例 2:
//
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
public class L215数组中的第K个最大元素 {
	public static int findKthLargest(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		int i =0;
		while(i<nums.length) {
			if(queue.size()<=k) queue.add(nums[i]);
			if(queue.size()>k) queue.poll();
			i++;
		}
		i = 0;
		int[] res = new int[k] ;
		for(int a : queue) {
			res[i++] = a;
		}
		return res[0];
	}
	public static int findKthLargestt(int[] nums, int k) {
		   int len = nums.length;
	        int left = 0;
	        int right = len - 1;
	        int target = len - k;
	        while (true) {
	            int index = partition(nums, left, right);
	            if (index == target) {
	                return nums[index];
	            } else if (index < target) {
	                left = index + 1;
	            } else {
	                right = index - 1;
	            }
	        }
	}
	
	private static int partition(int[] nums, int i, int j) {
		int left = i;
		int priority = nums[i];
		while(i<j) {
			while(i<j&&priority<=nums[j]) j--;
			while(i<j&&priority>=nums[i]) i++;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		  nums[left] = nums[i];
		  nums[i] = priority;
		return i;
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(3);
		queue.add(6);
		queue.add(2);
		queue.add(1);
		System.out.println(queue.poll());
		System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 5));
	}
}
