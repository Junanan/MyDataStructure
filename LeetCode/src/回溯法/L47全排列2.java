package 回溯法;

import java.util.ArrayList;
import java.util.List;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//示例:
//
//输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class L47全排列2 {
	static List<List<Integer>> res;

	public static List<List<Integer>> permuteUnique(int[] nums) {
		res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		boolean[] isValid = new boolean[nums.length];
		backtrack(list, nums, isValid);
		return res;
	}

	private static void backtrack(List<Integer> list, int[] nums, boolean[] isValid) {
		if (list.size() == nums.length && !res.contains(list)) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {  /// 不需要Start  因为是全排列
			if (isValid[i])
				continue;
			if(i>0&&nums[i]==nums[i-1]&&isValid[i-1]) break;//剪枝 没有也行 不过时间起飞 (差不多其实)
			isValid[i] = true;
			list.add(nums[i]);
			backtrack(list, nums, isValid);
			isValid[i] = false;
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] { 1, 1, 2 }));
	}
}
