package 回溯法;

import java.util.ArrayList;
import java.util.List;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//
//示例:
//
//输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
public class L78子集 {
	static List<List<Integer>> res;
	 public static List<List<Integer>> subsets(int[] nums) {
		 res = new ArrayList<>();
		 List<Integer> list = new ArrayList<>();
		 backtrack(nums,list,0);
		 return res;
	    }
	private static void backtrack(int[] nums, List<Integer> list,int j) {
		res.add(new ArrayList<>(list));//
		for(int i=j;i<nums.length;i++) {
			if(list.contains(nums[i])) continue;
			list.add(nums[i]);
			backtrack(nums, list,i);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(subsets(new int[] {1,2,3}));
	}
}
