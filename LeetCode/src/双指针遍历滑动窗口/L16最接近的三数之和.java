package 双指针遍历滑动窗口;

import java.util.Arrays;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
// 
//
//示例：
//
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
public class L16最接近的三数之和 {
	public int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
		Arrays.sort(nums);
		int res = nums[0]+nums[1]+nums[2];
		for (int i = 0; i < len; i++) {
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum-target) < Math.abs(res-target) )
					res = sum;
				if (sum < target ) {
					left++;
				}else if (sum > target ) {
					right--;
				}else {
					return target;
				}
				
			}
		}
		return res;
	}
}
