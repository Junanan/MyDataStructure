package 二叉树;

import java.util.HashMap;
import java.util.Map;

public class Five {
//	输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//	例如，给出
//	前序遍历 preorder = [3,9,20,15,7]
//	中序遍历 inorder = [9,3,15,20,7]
//	返回如下的二叉树：
//
//	    3
//	   / \
//	  9  20
//	    /  \
//	   15   7
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Solution {

		// 使用全局变量是为了让递归方法少传一些参数，不一定非要这么做

		private Map<Integer, Integer> reverses;
		private int[] preorder;

		public TreeNode buildTree(int[] preorder, int[] inorder) {
			int preLen = preorder.length;
			int inLen = inorder.length;
			// 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
			reverses = new HashMap<>(inLen);
			for (int i = 0; i < inLen; i++) {
				reverses.put(inorder[i], i);
			}
			return buildTree(0, preLen - 1, 0, inLen - 1);
		}

		/**
		 * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
		 *
		 * @param preL 前序遍历数组的区间左端点
		 * @param preR 前序遍历数组的区间右端点
		 * @param inL  中序遍历数组的区间左端点
		 * @param inR  中序遍历数组的区间右端点
		 * @return 构建的新二叉树的根结点
		 */
		private TreeNode buildTree(int preL, int preR, int inL, int inR) {
			if (preL > preR || inL > inR) {
				return null;
			}
			// 构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素
			int pivot = preorder[preL];
			TreeNode root = new TreeNode(pivot);
			int pivotIndex = reverses.get(pivot);////使得根节点 这一数值的位置是已知的
			////为了提升搜索效率，本题解使用哈希表 dic 预存储中序遍历的值与索引的映射关系，每次搜索的时间复杂度为 O(1)O(1)。
			// 这一步得画草稿，计算边界的取值，必要时需要解方程，并不难
			root.left = buildTree(preL + 1, preL + (pivotIndex - inL), inL, pivotIndex - 1);////递归处理左子树区间
			root.right = buildTree(preL + (pivotIndex - inL) + 1, preR, pivotIndex + 1, inR);/////递归处理右子树区间
			return root;
		}
	}

}
