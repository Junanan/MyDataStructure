package 双指针遍历滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
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

//犹豫不决先排序，步步逼近双指针
public class L15三数之和 {
	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || len < 3)
			return res;
		Arrays.sort(nums);

		for (int i = 0; i < len; i++) {
			if (nums[i] > 0)
				break;
			if (i>0&&nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				List<Integer> temp = new ArrayList<>();
				if (sum == 0) {
					temp.add(nums[i]);
					temp.add(nums[left]);
					temp.add(nums[right]);
					res.add(temp);

					while (left < right && nums[left + 1] == nums[left])
						left++;
					while (left < right && nums[right - 1] == nums[right])
						right--;
					left++;
					right--;
				} 
				else if (sum < 0)
					left++;
				else if (sum > 0)
					right--;
			}
		}
		return res;
	}
public static void main(String[] args) {
	int sum=1;
	if(sum>0) {
		
	}else if(sum<0) {
		
	}else {
		
	}
}
}
