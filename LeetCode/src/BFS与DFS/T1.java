package BFS与DFS;

import BinaryTree.*;

//给定一个二叉树，找出其最大深度。
//
//二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
//说明: 叶子节点是指没有子节点的节点。
//
//示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class T1 {
	public static int maxDepth(TreeNode root) {
		if(root==null) return 0;
		int left = maxDepth(root.leftNode);//左子树的高度
		int right = maxDepth(root.rightNode);//右子树的高度
		return java.lang.Math.max(left, right)+1;//递归到max(0,0)返回0开始+1回溯
//		return java.lang.Math.max(maxDepth(root.leftNode), maxDepth(root.rightNode))+1;
    }
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		tree.setRoot(root);
		root.setLeftNode(n1);
		root.setRightNode(n2);
		n2.setLeftNode(n3);
		n2.setRightNode(n4);
		System.out.println(maxDepth(root));
	}

}
