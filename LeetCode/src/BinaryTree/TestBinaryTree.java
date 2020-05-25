package BinaryTree;

public class TestBinaryTree {
	public static void main(String[] args) {
		//创建一棵树
		BinaryTree binTree = new BinaryTree();
		//创建一个根节点
		TreeNode root = new TreeNode(1);
		//把根节点赋给树
		binTree.setRoot(root);
		//创建右节点
		TreeNode rootr = new TreeNode(3);
		//创建左节点
		TreeNode rootl = new TreeNode(2);
		//设置为根节点的左节点
		root.setLeftNode(rootl);
		//设置为根节点的右节点
		root.setRightNode(rootr);
		//为第二层的左节点创建两个子节点
		rootl.setLeftNode(new TreeNode(4));
		rootl.setRightNode(new TreeNode(5));
		//为第二层右节点创建两个子节点
		rootr.setLeftNode(new TreeNode(6));
		rootr.setRightNode(new TreeNode(7));
		//前序遍历
		binTree.frontShow();
		System.out.print("===========");
		//中序遍历
		binTree.midShow();
		System.out.println("===========");
		//后序遍历
		binTree.backShow();
		//前序查找
		TreeNode result = binTree.frontsearch(3);
		System.out.println(result);
		//节点删除
		System.out.println("===========");
		binTree.delete(2);
		binTree.frontShow();


	}
}
