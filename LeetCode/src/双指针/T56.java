package 双指针;

import java.util.Arrays;

//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//示例 1：
//输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
//示例 2：
//
//输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
public class T56 {
	  public static int[] twoSum(int[] nums, int target) {
		  int i =0 ;
		  int j =nums.length-1 ;
		  while(i<j) {
			  if(nums[j]+nums[i]>target) j--;
			  else if(nums[j]+nums[i]<target)i++;
			  else return new int[] {nums[i],nums[j]};
		  }
		  // return new int[0];
		  throw new IllegalArgumentException("不存在这个数");
	    }
//	  解题思路：
//	  利用 HashMap 可以通过遍历数组找到数字组合，时间和空间复杂度均为 O(N)O(N) ；
//	  注意本题的 numsnums 是 排序数组 ，因此可使用 双指针法 将空间复杂度降低至 O(1)O(1) 。
	  public static void main(String[] args) {
		int[] a = new int[] {2,7,11,15};
		System.out.println(Arrays.toString(twoSum(a,9)));
	}
}
