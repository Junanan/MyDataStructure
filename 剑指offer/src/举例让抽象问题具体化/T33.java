package 举例让抽象问题具体化;

import BinaryTree.*;
import java.util.*;

public class T33 {
//	输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//	示例:
//	给定如下二叉树，以及目标和 sum = 22，
//	              5
//	             / \
//	            4   8
//	           /   / \
//	          11  13  4
//	         /  \    / \
//	        7    2  5   1
//	返回:
//	[
//	   [5,4,11,2],
//	   [5,8,4,5]
//	]
	//回溯法
	//在外部直接定义
	static List<List<Integer>> res = new LinkedList<>();
	static List<Integer> temp = new LinkedList<>();
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		recus(root, sum);
		return res;
	}
	static void recus(TreeNode root, int sum) {
		if (root == null) return;
		temp.add(root.value);
		sum = sum - root.value;
		if (sum == 0 && root.leftNode == null && root.rightNode == null) {
			res.add(new LinkedList<Integer>(temp));//?
		}
		recus(root.leftNode, sum);
		recus(root.rightNode, sum);
		temp.remove(temp.size() - 1);//删除不合的节点
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		TreeNode root = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		tree.setRoot(root);
		root.setLeftNode(n1);
		root.setRightNode(n2);
		n2.setLeftNode(n3);
		n2.setRightNode(n4);
		List<List<Integer>> a = pathSum(root, 30);
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}
}
