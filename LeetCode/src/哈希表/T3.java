package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
//示例 1:
//输入: nums = [1,2,3,1], k = 3
//输出: true
//示例 2:
//输入: nums = [1,0,1,1], k = 1
//输出: true
public class T3 {
	  public static boolean containsNearbyDuplicate(int[] nums, int k) {
		  HashMap<Integer, Integer> map = new HashMap<>();
		  for(int i =0;i<nums.length;i++)
		  {
			  if(map.containsKey(nums[i])&&Math.abs(map.get(nums[i])-i)<=k) {
				  return true;
			  }
				  map.put(nums[i],i);
		  }
		  return false;
	    }
	  public static void main(String[] args) {
		int[] nums = new int[] {1,0,1,1};
		System.out.println(containsNearbyDuplicate(nums,1));
	}

}
