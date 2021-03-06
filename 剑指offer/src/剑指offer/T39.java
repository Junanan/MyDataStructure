package 剑指offer;
//输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//要求时间复杂度为O(n)。
//示例1:
//输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
public class T39 {
	public static int maxSubArrayy(int[] nums) {
		 int sum =0;
		 int res = nums[0];
		 for(int num:nums) {
			 if(sum>0) {
				 sum+=num;
			 }else {
				 sum = num;
			 }
			 res = Math.max(res, sum);
		 }
		 return res;
	    }
	public static void main(String[] args) {
		System.out.println(maxSubArrayy(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
	}
}
