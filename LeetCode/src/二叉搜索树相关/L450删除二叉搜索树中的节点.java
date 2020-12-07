package 二叉搜索树相关;

//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//
//一般来说，删除节点可分为两个步骤：
//
//首先找到需要删除的节点；
//如果找到了，删除它。
//说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
//
//示例:
//
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
public class L450删除二叉搜索树中的节点 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		if (key < root.val )
			root.left = deleteNode(root.left, key);
		else if ( key > root.val )
			root.right = deleteNode(root.right, key);
		else {/// 找到了要删除的节点
			if(root.right==null) return root.left;
			if(root.left==null) return root.right;
			///左右节点都不为空
			// 要么用左子树的最大值替换  要么用右子树的最小值替换
			TreeNode Maxleft = Maxleft(root.left);
			root.val = Maxleft.val;
			root.left = deleteNode(root.left, root.val);//// root的左子树改变了 也需要进行二叉树平衡
		}
		return root;
	}

	private TreeNode Maxleft(TreeNode root) {
		while(root.right!=null) {
			root = root.right;
		}
		return root;
	}
}
