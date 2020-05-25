package 剑指offer;

import java.util.HashMap;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//示例 1:
//输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2
public class T37 {
	public static int majorityElementt(int[] nums) {
		int x=0,votes=0;
		for(int i=0;i<nums.length;i++) {
			if(votes==0) x = nums[i];
			votes+= nums[i]==x?1:-1; 
		}////摩尔投票法 所有数都认为自己是众数 和所有数对干 剩下的数一定是超过数组长度一半的众数；
		return x;
	}
	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer count = map.get(nums[i]);
			count = count == null ? 1 : ++count;///别写成count++
			map.put(nums[i], count);
			if(map.get(nums[i])>nums.length/2) return nums[i];
		}
		throw new IllegalArgumentException("不存在这个元素");
	}
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, 2, 2, 2, 5, 4};
		System.out.println(majorityElement(nums));
	}
}
