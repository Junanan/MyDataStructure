package HOT100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回它的中序 遍历。
//
//示例:
//
//输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
public class L94二叉树的中序遍历 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			if (root.left != null) {
				root = root.left;
				stack.push(root);
			} else {
				TreeNode temp = stack.pop();
				res.add(temp.val);
				if (temp.right != null) {
					root = temp.right;
					stack.push(root);
				}
			}
		}
		return res;

	}
//	 这题的真正难点在于如何用非递归的方式实现。
//	 递归实现时，是函数自己调用自己，一层层的嵌套下去，操作系统/虚拟机自动帮我们用栈来保存了每个调用的函数，现在我们需要自己模拟这样的调用过程。
//	 递归的调用过程是这样的：
//
//
//	 dfs(root.left)
//	 	dfs(root.left)
//	 		dfs(root.left)
//	 			为null返回
//	 		打印节点
//	 		dfs(root.right)
//	 			dfs(root.left)
//	 				dfs(root.left)
//	 				........
}
