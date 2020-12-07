package 递归;
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//本题中，一棵高度平衡二叉树定义为：
//
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//示例 1:
//
//给定二叉树 [3,9,20,null,null,15,7]
public class L110平衡二叉树 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public boolean isBalanced(TreeNode root) {
		if(root==null) return true;
		return Math.abs(maxdepth(root.left)-maxdepth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
	private int maxdepth(TreeNode root) {
		if(root==null) return 0;
		return Math.max(maxdepth(root.left), maxdepth(root.right))+1;
	}
}
//1.找终止条件。什么情况下递归应该终止？自然是子树为空的时候，空树自然是平衡二叉树了。
//2.应该返回什么信息：
//为什么我说这个题是集合了模版精髓？正是因为此题的返回值。要知道我们搞这么多花里胡哨的，都是为了能写出正确的递归函数，因此在解这个题的时候，
//我们就需要思考，我们到底希望返回什么值？
//何为平衡二叉树？平衡二叉树即左右两棵子树高度差不大于1的二叉树。而对于一颗树，它是一个平衡二叉树需要满足三个条件：它的左子树是平衡二叉树，
//它的右子树是平衡二叉树，它的左右子树的高度差不大于1。换句话说：如果它的左子树或右子树不是平衡二叉树，或者它的左右子树高度差大于1，那么它就不是平衡二叉树。
//
//而在我们眼里，这颗二叉树就3个节点：root、left、right。那么我们应该返回什么呢？如果返回一个当前树是否是平衡二叉树的boolean类型的值，
//那么我只知道left和right这两棵树是否是平衡二叉树，无法得出left和right的高度差是否不大于1，自然也就无法得出root这棵树是否是平衡二叉树了。
//而如果我返回的是一个平衡二叉树	的高度的int类型的值，那么我就只知道两棵树的高度，但无法知道这两棵树是不是平衡二叉树，自然也就没法判断root这棵树是不是平衡二叉树了。
//
//3.本级递归应该做什么。知道了第二步的返回值后，这一步就很简单了。目前树有三个节点：root，left，right。我们首先判断left子树和right子树是否是平衡二叉树，
//如果不是则直接返回false。再判断两树高度差是否不大于1，如果大于1也直接返回false。否则说明以root为节点的子树是平衡二叉树，那么就返回true和它的高度。
