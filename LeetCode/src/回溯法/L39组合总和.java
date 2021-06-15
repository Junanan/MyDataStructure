package 回溯法;

import java.util.ArrayList;
import java.util.List;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。
//
//说明：
//
//所有数字（包括 target）都是正整数。
//解集不能包含重复的组合。 
//示例 1：
//
//输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//示例 2：
//
//输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
public class L39组合总和 {
    static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, list, 0);
        return res;
    }

    private static void backtrack(int[] candidates, int target, List<Integer> list, int j) {
        if (target == sumList(list)) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = j; i < candidates.length; i++) {
            if (sumList(list) > target) {
                break;
            }
            list.add(candidates[i]);
            backtrack(candidates, target, list, i);
            list.remove(list.size() - 1);
        }
    }

    private static int sumList(List<Integer> list) {
        if (list.size() == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}
