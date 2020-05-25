package 举例让抽象问题具体化;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import BinaryTree.*;
//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//例如:
//给定二叉树: [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回： 
//[3,9,20,15,7] 
public class T29 {
	 public static int[] levelOrder(TreeNode root) {
		 ArrayList<Integer> res = new ArrayList<Integer>();
		 Queue<TreeNode> queue = new LinkedList<TreeNode>() ;
		 queue.offer(root);
		 while(!queue.isEmpty())//////循环的条件
		{    TreeNode temp = queue.poll();
			 res.add(temp.value);
			 if(temp.leftNode!= null) queue.offer(temp.leftNode);
			 if(temp.rightNode!= null) queue.offer(temp.rightNode);
			 
		 }
		 //Arrays.toString 不适用于Integer类型 
		 int[] ans = new int[res.size()];
		 for(int i =0;i<res.size();i++) {
			 ans[i] = res.get(i);
		 }
		 return ans;
		 
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
		int[] a = levelOrder(root);
		System.out.println(Arrays.toString(a));
	}
}
