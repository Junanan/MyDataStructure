package 回溯法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的每个数字在每个组合中只能使用一次。
//
//说明：
//
//所有数字（包括目标数）都是正整数。
//解集不能包含重复的组合。 
//示例 1:
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//示例 2:
//
//输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
public class L40组合总数2 {
	static List<List<Integer>> res;

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtrack(candidates, list, target, 0);
		return res;
	}

	private static void backtrack(int[] candidates, List<Integer> list, int target, int j) {
		if (listsum(list) == target&&!res.contains(list)) {
			res.add(new ArrayList<>(list));
			return;
		}
		if(listsum(list)>target) return;
		for (int i = j; i < candidates.length; i++) {
			list.add(candidates[i]);
			backtrack(candidates, list, target, i+1);  /// 不能重复使用数字 从下一个数字开始选择
			list.remove(list.size() - 1);
		}
	}

	private static int listsum(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] candidates = new int[] { 10,1,2,7,6,1,5 };
		int target = 8;
		System.out.println(combinationSum2(candidates, target));
	}
}
