package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class L101对称二叉树 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 构建判断做左右子树值的函数
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return islr(root.left, root.right);
	}

	private boolean islr(TreeNode l, TreeNode r) {
		// 终止条件
		if (l == null && r == null)
			return true;

		if (l == null || r == null)
			return false;

		if (l.val != r.val)
			return false;

		return islr(l.left, r.right) && islr(l.right, r.left);
	}
	 public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res = new ArrayList<>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        while(!queue.isEmpty()){
	             List<Integer> temp = new ArrayList<>();
	             for(int i=0;i<queue.size();i++){
	                 TreeNode node = queue.poll();
	                 temp.add(node.val);
	                 if(node.left!=null) queue.offer(node.left);
	                 if(node.right!=null) queue.offer(node.right);
	             }
	             res.add(temp);
	        }
	        return res;
	    }
	 public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		System.out.println(s);
		input.close();
	}
}
