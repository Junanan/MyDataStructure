package HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
// 
//
//示例：
//
//给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]

public class L15三数之和 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int start = 0; start < nums.length - 1; start++) {
			int i = start + 1;
			int j = nums.length-1;
			if(nums[start]>0) return res;
			if(start>0&&nums[start]==nums[start-1]) continue;
			while (i < j) {
				int num = nums[start] + nums[i] + nums[j];
				if(num == 0) {
				res.add(helper(nums,start,i,j));
				while(i<j&&nums[i]==nums[i+1]) i++; 
				while(i<j&&nums[j]==nums[j-1]) j--; 
				i++;
				j--;
				}
				if (num < 0) {
					i++;
				} else if (num > 0) {
					j--;
				} 
			}
		}
		return res;
	}

	private List<Integer> helper(int[] nums ,int start, int i, int j) {
		List<Integer> list = new ArrayList<>();
		list.add(nums[start]);
		list.add(nums[i]);
		list.add(nums[j]);
		return list;
	}
}
