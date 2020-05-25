package 剑指offer;

//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
// 
//
//示例 1:
//
//给定二叉树 [3,9,20,null,null,15,7]
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class T53 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return recus(root) != -1;
	}

	// 后序遍历
	private int recus(TreeNode root) {
		if (root == null)
			return 0;
		int left = recus(root.left);
		if (left == -1)
			return -1;
		int right = recus(root.right);
		if (right == -1)
			return -1;
		return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
	}

	public boolean isBalancedd(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
	}

	private int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		return Math.max(left, right) + 1;
	}

}
