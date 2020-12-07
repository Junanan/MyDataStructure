package 树的遍历;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回它的中序 遍历。
//
//示例:
//
//输入: [1,null,2,3]
	//   1
	//  / \
//     2   3
//    / \  / \   
//   6   7 4   5
//
//输出: [1,3,2]
public class L94二叉树的中序遍历 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	////颜色标记法
	public class colornode{
		TreeNode node;
		String color;
		public colornode(TreeNode node,String color) {
			this.color = color;           
			this.node = node;
		}
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root==null) return new ArrayList<>();
		Stack<colornode> stack = new Stack<>();
		stack.push(new colornode(root, "white"));
		List<Integer> res = new ArrayList<>();
		while(!stack.isEmpty()) {
			colornode temp = stack.pop();
			if(temp.color=="white") {
				if(temp.node.right!=null) stack.push(new colornode(temp.node.right, "white"));
				stack.push(new colornode(temp.node, "black"));
				if(temp.node.left!=null) stack.push(new colornode(temp.node.left, "white"));
			}else {
				res.add(temp.node.val);
			}
		}
		return res;
	}
	public List<Integer> inorderTraversall(TreeNode root) {
		if(root==null) return new ArrayList<>();
		Stack<TreeNode> stack =  new Stack<>();
		List<Integer> list = new ArrayList<Integer>();
		TreeNode cur = root;
		while(!stack.isEmpty()) {
			while(cur!=null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right!=null) {
				cur = node.right;
			}
		}
		return list;
    }
}
