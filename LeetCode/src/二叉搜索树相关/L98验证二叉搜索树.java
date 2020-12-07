package 二叉搜索树相关;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//假设一个二叉搜索树具有如下特征：
//
//节点的左子树只包含小于当前节点的数。
//节点的右子树只包含大于当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。
//示例 1:
//
//输入:
//    2
//   / \
//  1   3
//输出: true
//示例 2:
//
//输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
public class L98验证二叉搜索树 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	List<Integer> res ;
	public boolean isValidBST(TreeNode root) {
		if(root==null) return true;
		res = new ArrayList<>();
		Inorder(root);
		for(int i =1 ;i<res.size();i++) {
			if(res.get(i-1)>=res.get(i)) return false;
		}
		return true;
	}
	private void Inorder(TreeNode root) {
		if(root==null) return;
		Inorder(root.left);
		res.add(root.val);
		Inorder(root.right);
	}
	public boolean isValidBSTt(TreeNode root) { /// 错的
		if(root==null) return true;
		return isleft(root)&&isright(root)&&isValidBST(root.left)&&isValidBST(root.right);
				
    }
	private boolean isleft(TreeNode root) {
		if(root.left!=null) {
			if(root.left.val<root.val) {
				return true;
			}else {
				return false;
			}
		}
		return true;
	}
	private boolean isright(TreeNode root) {
		if(root.right!=null) {
			if(root.right.val>root.val) {
				return true;
			}else {
				return false;
			}
		}
		return true;
	}
}
