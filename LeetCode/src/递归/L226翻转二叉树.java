package 递归;
//翻转一棵二叉树。
//
//示例：
//输入：
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//输出：
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
public class L226翻转二叉树 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	public static TreeNode invertTree(TreeNode root) {
		if(root==null) return null;
		TreeNode tmp = root.right;
		root.right = root.left;
		root.left = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
    }

//	public static void swap(TreeNode val, TreeNode val2) {
//		TreeNode temp = val;
//		val = val2;
//		val2 = temp;
//	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n7 = new TreeNode(7);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n6 = new TreeNode(6);
		TreeNode n9 = new TreeNode(9);
		root.left =n2;
		root.right = n7;
		n2.left =n1;
		n2.right =n3;
		n7.left = n6;
		n7.right = n9;
		invertTree(root);
		System.out.println(root.left.val);
	}
}
