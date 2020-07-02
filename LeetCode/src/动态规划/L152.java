package 动态规划;
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//示例 1:
//输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//示例 2:
//
//输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
public class L152 {
	public int maxProduct(int[] nums) {
		int imax = 1;
		int imin = 1;
		int max = Integer.MIN_VALUE;
		for(int i =1 ; i<nums.length;i++) {
			if(nums[i]<0) {
				int temp = imax;
				imin=imax  ;
				temp = imin;
			}
			//维护一个最小值  当nums[i]<0 nums[i] * min = max
			imax = Math.max(nums[i], imax*nums[i]);
			imin = Math.min(nums[i], imin*nums[i]);
			max = Math.max(max , imax);
		}
		return max;
		
    }
	
}
