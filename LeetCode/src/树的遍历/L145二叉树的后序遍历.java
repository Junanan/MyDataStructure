package ���ı���;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class L145�������ĺ������ {
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
				stack.push(null);///�ڵ�ǰ�ڵ�֮ǰ����һ���սڵ��ʾ�Ѿ����ʹ���
				if(temp.right!=null) stack.push(temp.right);
				if(temp.left!=null) stack.push(temp.left);
			}else {//�սڵ��ʾ֮ǰ�Ѿ����ʹ��ˣ�������Ҫ������˵ݹ�֮�������
				res.add(stack.pop().val);
			}
		}
		return res;
    }
}
