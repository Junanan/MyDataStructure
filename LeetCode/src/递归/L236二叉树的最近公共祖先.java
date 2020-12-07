package 递归;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
//
//示例 1:
//
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//示例 2:
//
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
public class L236二叉树的最近公共祖先 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	//函数作用
//	如果 p 和 q 都存在，则返回它们的公共祖先；
//	如果只存在一个，则返回存在的一个；
//	如果 p 和 q 都不存在，则返回NULL
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||root==p||root==q) return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left==null) return right;
		if(right==null) return left;
		return root;
		
	}
//	复杂度分析
//
//	时间复杂度：O(N)O(N)，其中 NN 是二叉树的节点数。	二叉树的所有节点有且只会被访问一次，因此时间复杂度为 O(N)O(N)。
//
//	空间复杂度：O(N)O(N) ，其中 NN 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 NN，因此空间复杂度为 O(N)O(N)。
}
