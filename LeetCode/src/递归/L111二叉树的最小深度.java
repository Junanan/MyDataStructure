package 递归;


//给定一个二叉树，找出其最小深度。
//最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//说明: 叶子节点是指没有子节点的节点。
public class L111二叉树的最小深度 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		if(root.right==null) return minDepth(root.left)+1;
		else if(root.left==null) return minDepth(root.right)+1;
		else return Math.min(minDepth(root.right), minDepth(root.left))+1;
    }
////如果按最大深度算  1,2 例子过不了
}
	