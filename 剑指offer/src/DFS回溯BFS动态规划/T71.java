package DFS回溯BFS动态规划;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
//满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
public class T71 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == q || root == p)
			return root;
		TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
		if (leftNode == null)
			return rightNode;
		if (rightNode == null)
			return leftNode;
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(4);
		root.left = n4;
		root.right = n1;
		n4.right = n6;
		n4.left = n5;
		n6.left = n7;
		n6.right = n8;
		n1.left = n2;
		n1.right = n3;
		System.out.println(lowestCommonAncestor(root, n7, n8).val);
	}
}
