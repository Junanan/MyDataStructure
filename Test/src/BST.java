
public class BST {
	public static class TreeNode{
		int val;
		TreeNode right;
		TreeNode left;
		public TreeNode(int x) {
			val = x;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(30);
		TreeNode n1 = new TreeNode(15);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(22);
		TreeNode n4 = new TreeNode(17);
		TreeNode n5 = new TreeNode(27);
		TreeNode n6 = new TreeNode(60);
		TreeNode n7 = new TreeNode(45);
		TreeNode n8 = new TreeNode(75);
		root.left = n1;
		root.right = n6;
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		n6.left = n7;
		n6.right = n8;
		System.out.println(TreeHeight(root));
		System.out.println(Tree_MinimumRecursive(root));
		System.out.println(Tree_MaximumIterative(root));
	}
	public static int TreeHeight(TreeNode root) {
		if(root==null) return 0;
		return java.lang.Math.max(TreeHeight(root.left), TreeHeight(root.right))+1;
	}
	void PreOrder(TreeNode root) {
		System.out.println(root.val);
		PreOrder(root.left);
		PreOrder(root.right);
	}
	void InOrder(TreeNode root) {
		InOrder(root.left);
		System.out.println(root.val);
		InOrder(root.right);
	}
	void PostOrder(TreeNode root) {
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.println(root.val);
	}
	public static int Tree_MinimumRecursive(TreeNode root) {
		if(root!=null&&root.left==null) return root.val;
		return Tree_MinimumRecursive(root.left);
	}
	public static int Tree_MaximumIterative(TreeNode root) {
		while(root.right!=null) {
			root = root.right;
		}
		return root.val;
	}

}
