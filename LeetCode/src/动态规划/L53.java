package 动态规划;

import java.util.TreeMap;
import java.util.TreeSet;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//示例:
//
//输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
public class L53 {
	 public static int maxSubArray(int[] nums) {
		 int[] dp = new int[nums.length]; 
		 //dp[i] 代表之前累加数或者当前的数
		 dp[0] = nums[0];
		 int res = nums[0];  //当nums = [1];
		 for(int i =1 ;i<nums.length;i++ ) {
			 dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
			 res = Math.max(res, dp[i]);
		 }
		 return res;
	 }
	 //贪心
	 public static int maxSubArrayy(int[] nums) {
		 int sum =0;
		 int res = nums[0];
		 for(int num:nums) {
			 if(sum>=0) {
				 sum+=num;
			 }else {
				 sum = num;
			 }
			 res = Math.max(res, sum);
		 }  
		 return res;
	    }
	public static void main(String[] args) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(1, 2);
		map.put(6, 9);
		TreeSet<Integer> m = new TreeSet<>();
		m.add(2);
		m.add(6);
		m.add(28);
		m.add(4);
		map.put(3, 3);
		map.put(9, 10);
		map.put(5, 4);
		System.out.println(map.keySet());
		System.out.println(m.toString());
	}
}	
