package HOT100;

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 
//
//示例 1:
//
//输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//示例 2:
//
//输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
public class L152乘积最大子数组 {
	 public int maxProduct(int[] nums) {
		 int len = nums.length;
		 if(len==0) return 0;
		 int ans = nums[0]; //结果可能为非连续的数组 所以要用ans 来记录最大值
		 int[] max = new int[len];
		 int[] min = new int[len];
		 max[0] = nums[0];
		 min[0] = nums[0];
		 for(int i=1;i<len;i++) {
			 max[i] = Math.max(max[i-1]*nums[i], Math.max(nums[i], min[i-1]*nums[i]));
			 min[i] = Math.min(min[i-1]*nums[i], Math.min(nums[i], max[i-1]*nums[i]));
			 ans = Math.max(ans, max[i]);
		 }
		 return  ans;
		 
	    }
}
