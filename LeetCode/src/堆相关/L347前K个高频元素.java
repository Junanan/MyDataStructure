package 堆相关;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
// 
//
//示例 1:
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//
//输入: nums = [1], k = 1
//输出: [1]
public class L347前K个高频元素 {
	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Queue<Integer> queue = new PriorityQueue<Integer>((v1,v2)->map.get(v2)-map.get(v1));
		for(int i : nums) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else map.put(i, 1);
		}
		for(int i:map.keySet()) {
			queue.add(i);
		}
		//转为链表
		int[] res = new int[k];
		int i =0;
		while(i<k) res[i++] = queue.poll();
		return res;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
	}
}
