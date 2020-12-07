package 回溯法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//示例:
//
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class L46全排列 {
	List<List<Integer>> res;
	public List<List<Integer>> permute(int[] nums) {
		res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtracking(nums,list);
		return res;
    }
//	list 这个变量所指向的对象在递归的过程中只有一份，深度优先遍历完成以后，因为回到了根结点（因为我们之前说了，从深层结点回到浅层结点的时候，需要撤销之前的选择），
//	 这些地址被添加到 res 变量，但实际上指向的是同一块内存地址，因此我们会看到 6 个空的列表对象。解决的方法很简单，在 res.add(list); 这里做一次拷贝即可
	private void backtracking(int[] nums, List<Integer> list) {
		if(list.size()==nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i =0;i<nums.length;i++) {
			if(list.contains(nums[i])) continue;
		list.add(nums[i]);
		backtracking(nums, list);///进入下一步决策
		list.remove(list.size()-1);////撤销当前决策的选择
		}
	}
	
}
