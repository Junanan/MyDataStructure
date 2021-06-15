package ���ı���;
import java.util.*;

public class L145�������ĺ������ {
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<Integer> postorderTraversal(TreeNode root) {
		if(root==null) return new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new LinkedList<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			res.add(temp.val);
			if(temp.left!=null) stack.push(temp.left);
			if(temp.right!=null) stack.push(temp.right);
		}
		Collections.reverse(res);
		return res;
	}
}
