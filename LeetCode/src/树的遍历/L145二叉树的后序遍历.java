package 树的遍历;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class L145二叉树的后序遍历 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res= new ArrayList<Integer>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			if(temp!=null) {
				stack.push(temp);
				stack.push(null);///在当前节点之前加入一个空节点表示已经访问过了
				if(temp.right!=null) stack.push(temp.right);
				if(temp.left!=null) stack.push(temp.left);
			}else {//空节点表示之前已经访问过了，现在需要处理除了递归之外的内容
				res.add(stack.pop().val);
			}
		}
		return res;
    }
}
