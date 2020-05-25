package 画图让抽象问题形象化;

//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
//例如输入：
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//镜像输出：
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
public class T24 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	public TreeNode mirrorTree(TreeNode root) {
		if(root == null) return null;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTree(root.left);
		mirrorTree(root.right);
	return root;
    }

}
