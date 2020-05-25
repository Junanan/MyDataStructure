package DFS回溯BFS动态规划;
import java.util.*;

import BinaryTree.*;
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//[
//  [3],
//  [20,9],
//  [15,7]
//]
public class T31 {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>>  res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> temp = new LinkedList<>();
			for(int i = queue.size();i>0;i--) {
				TreeNode node = queue.poll();
				temp.add(node.value);
				if(node.leftNode!=null)  queue.offer(node.leftNode);
				if(node.rightNode!=null)  queue.offer(node.rightNode);
			}
			if(res.size()%2==1) Collections.reverse(temp);
			res.add(temp);
		}
		return res;
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
			List<List<Integer>> a = levelOrder(root);
			for(int i=0;i<a.size();i++) {
				System.out.println(a.get(i));
			}
		}
}
