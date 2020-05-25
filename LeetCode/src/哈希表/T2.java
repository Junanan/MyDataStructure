package 哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//给定一个整数数组，判断是否存在重复元素。
//
//如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
//示例 1:
//
//输入: [1,2,3,1]
//输出: true
//示例 2:
//
//输入: [1,2,3,4]
//输出: false
public class T2 {
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> map =new HashSet<>();
		for(Integer i : nums) {
			if(map.contains(i)) return true;
			map.add(i);
		}
		return false;
    }
public static void main(String[] args) throws Exception {
	int[] nums = new int[] {};
	System.out.println(containsDuplicate(nums));
}
}
