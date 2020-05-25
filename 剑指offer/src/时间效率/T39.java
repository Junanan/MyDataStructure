package 时间效率;
//输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
//要求时间复杂度为O(n)。
//
// 
//
//示例1:
//
//输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
public class T39 {
	  public int maxSubArray(int[] nums) {
		  //动态规划
		  int res = nums[0];
		  for(int i=1 ;i<nums.length;i++ ) {
			  nums[i]+=Math.max(nums[i-1], 0);
			  res = Math.max(res, nums[i]);
		  }
		  return res;

	    }

}
