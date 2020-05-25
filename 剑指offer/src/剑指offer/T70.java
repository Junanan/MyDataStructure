package 剑指offer;

import 剑指offer.T71.TreeNode;

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//示例 1:
//
//输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
//示例 2:
//
//输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
public class T70 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		while (root != null) {
			if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else
				break;
		}
		return root;
	}
	// 迭代
	public static TreeNode lowestCommonAncestorr(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val < p.val && root.val < q.val) {
			 return lowestCommonAncestorr(root.right, p, q);
		}
		if (root.val > p.val && root.val > q.val) {
			 return lowestCommonAncestorr(root.left, p, q);
		}
		return root;
	}
	// 递归
	public static void main(String[] args) {
		TreeNode root =  new TreeNode(5);
		TreeNode n2 =  new TreeNode(2);
		TreeNode n3 =  new TreeNode(3);
		TreeNode n4 =  new TreeNode(4);
		TreeNode n6 =  new TreeNode(6);
		TreeNode n7 =  new TreeNode(7);
		TreeNode n8 =  new TreeNode(8);
		root.left = n4;
		root.right =n7;
		n4.right = n3;
		n4.left = n2;
		n7.left = n6;
		n7.right=n8;
		System.out.println(lowestCommonAncestorr(root, n6, n8).val);
	}
}
