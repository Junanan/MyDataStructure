package 树的遍历;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
//示例：
//二叉树：[3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
public class L102二叉树的层序遍历 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root==null) return new ArrayList<>();
		Queue<TreeNode>  queue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int size = queue.size();
			for(int i=0;i<size;i++) {
				TreeNode temp = queue.poll();
				list.add(temp.val);
				if(temp.left!=null) queue.offer(temp.left);
				if(temp.right!=null) queue.offer(temp.right);
			}
			res.add(list);
		}
		return res;
    }
}
