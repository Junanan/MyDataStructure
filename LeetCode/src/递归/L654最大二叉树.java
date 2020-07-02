package 递归;

import java.util.HashMap;
import java.util.Map;

//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//二叉树的根是数组中的最大元素。
//左子树是通过数组中最大值左边部分构造出的最大二叉树。
//右子树是通过数组中最大值右边部分构造出的最大二叉树。
//通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
// 
//
//示例 ：
//
//输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
public class L654最大二叉树 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int[] nums;
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		this.nums = nums;
		int len = nums.length;
		if (len == 0)
			return null;
		return recus(0, len);

	}
	private TreeNode recus(int left, int right) {
		if (left >= right)
			return  null;
		int res = Integer.MIN_VALUE;
		int index = 0;
		for (int i = left; i < right; i++) {
			if (nums[i] > res) {
				res = nums[i];
				index = i;
			}
		}
		TreeNode root = new TreeNode(res);
		root.left = recus(left, index);
		root.right = recus(index + 1, right);
		return root;
	}

	public static TreeNode constructMaximumBinaryTreee(int[] nums) {
		if (nums.length == 1)
			return new TreeNode(nums[0]);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
			max = Math.max(max, nums[i]);
		}
		int k = map.get(max);
		int[] lnum = new int[k];
		int[] rnum = new int[nums.length - k - 1];
		System.arraycopy(nums, 0, lnum, 0, k);
		System.arraycopy(nums, k + 1, rnum, 0, nums.length - k - 1);
		TreeNode root = new TreeNode(max);
		root.left = constructMaximumBinaryTreee(lnum);
		root.right = constructMaximumBinaryTreee(rnum);
		return root;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = Integer.MIN_VALUE;
		int[] nums = new int[] { 3, 5, 12, 3, 2 };
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
			max = Math.max(max, nums[i]);
		}
	}
}
