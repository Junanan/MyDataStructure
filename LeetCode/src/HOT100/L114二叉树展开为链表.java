package HOT100;

import HOT100.L105从前序与中序遍历序列构造二叉树.TreeNode;

//给定一个二叉树，原地将它展开为一个单链表。
//
// 
//
//例如，给定二叉树
//
//    1
//   / \
//  2   5
// / \   \
//3   4   6
//将其展开为：
//
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
public class L114二叉树展开为链表 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	// 使用递归 将root 左右子树弄成已展开为链表  千万别考虑其细节
	 public void flatten(TreeNode root) {
	        if(root==null) return ;
	        flatten(root.left);
	        flatten(root.right);
	        TreeNode temp = root.right;
	        root.right = root.left;
	        root.left = null;
	        //将原先的right接到 left的后端
	        while(root.right!=null) {
	        	root = root.right;
	        }
	        root.right = temp;
	   }
	 public static void main(String[] args) {
		System.out.println(1&1);
	}
}
