package 树的遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BFS与DFS.L102二叉树的层序遍历.TreeNode;

public class L144二叉树的前序遍历 {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<Integer> preorderTraversal(TreeNode root) {
		if(root==null) return new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			res.add(temp.val);
			if(temp.right!=null) stack.push(temp.right);
			if(temp.left!=null) stack.push(temp.left);
		}
		return res;
    }
	static TreeNode a;
	public static TreeNode search(TreeNode root,int key) {
		if(root.val==key) return root;
		if(root.val>key) a =search(root.left, key);
		if(root.val<key) a =search(root.right, key);
		return a;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode n9 = new TreeNode(1);
		TreeNode n20 = new TreeNode(10);
		TreeNode n15 = new TreeNode(5);
		TreeNode n7 = new TreeNode(11);
		root.left = n9;
		root.right = n20;
		n20.right = n7;
		n20.left = n15;
		System.out.println(search(root, 11).val);
	}
}
