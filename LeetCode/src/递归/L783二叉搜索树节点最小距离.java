package 递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import 递归.L654最大二叉树.TreeNode;

//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
//
//示例：
//
//输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
public class L783二叉搜索树节点最小距离 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	static int res = Integer.MAX_VALUE;
	static List<Integer> ans = new ArrayList<Integer>();
	public static int minDiffInBST(TreeNode root) {
		if(root==null) return 0;
		dfs(root);
		for(int i = 1;i<ans.size();i++) {
			res = Math.min(res, Math.abs(ans.get(i)-ans.get(i-1)));
		}
		return res;
	}

	private static void dfs(TreeNode root) {
		minDiffInBST(root.left);
		ans.add(root.val);
		minDiffInBST(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(96);
		TreeNode n2 = new TreeNode(12);
		TreeNode n7 = new TreeNode(13);
		TreeNode n1 = new TreeNode(52);
		TreeNode n3 = new TreeNode(29);
		root.left = n2;
		n2.right = n7;
		n7.right = n1;
		n1.left = n3;
		System.out.println(minDiffInBST(root));
	}
}
